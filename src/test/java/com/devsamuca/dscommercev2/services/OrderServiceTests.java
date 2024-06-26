package com.devsamuca.dscommercev2.services;

import com.devsamuca.dscommercev2.dto.OrderDTO;
import com.devsamuca.dscommercev2.entities.Order;
import com.devsamuca.dscommercev2.entities.OrderItem;
import com.devsamuca.dscommercev2.entities.Product;
import com.devsamuca.dscommercev2.entities.User;
import com.devsamuca.dscommercev2.repositories.OrderItemRepository;
import com.devsamuca.dscommercev2.repositories.OrderRepository;
import com.devsamuca.dscommercev2.repositories.ProductRepository;
import com.devsamuca.dscommercev2.services.exceptions.ForbiddenException;
import com.devsamuca.dscommercev2.services.exceptions.ResourceNotFoundException;
import com.devsamuca.dscommercev2.tests.OrderFactory;
import com.devsamuca.dscommercev2.tests.ProductFactory;
import com.devsamuca.dscommercev2.tests.UserFactory;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private  AuthService authService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private UserService userService;

    private Long existingOrderId, nonExistingOrderId, existingProductId, nonExistingProductId;
    private Order order;
    private OrderDTO orderDTO;

    private User admin, client;
    private Product product;

    @BeforeEach
    void setUp() throws Exception {
        existingOrderId = 1L;
        nonExistingOrderId = 2L;
        existingProductId = 1L;
        nonExistingProductId = 2L;

        admin = UserFactory.createCustomAdminUser(1L, "Jef");
        client = UserFactory.createCustomClientUser(2L, "Bob");

        order = OrderFactory.createOrder(client);
        orderDTO = new OrderDTO(order);
        product = ProductFactory.createProduct();

        Mockito.when(orderRepository.findById(existingOrderId)).thenReturn(Optional.of(order));
        Mockito.when(orderRepository.findById(nonExistingOrderId)).thenReturn(Optional.empty());

        Mockito.when(productRepository.getReferenceById(existingProductId)).thenReturn(product);
        Mockito.when(productRepository.getReferenceById(nonExistingProductId)).thenThrow(EntityNotFoundException.class);

        Mockito.when(orderRepository.save(any())).thenReturn(order);
        Mockito.when(orderItemRepository.saveAll(any())).thenReturn(new ArrayList<>(order.getItems()));
    }

    @Test
    public void findByIdShouldReturnOrderDTOWhenIdExistsAndAdminLogged() {
        Mockito.doNothing().when(authService).validadeSelfOrAdmin(any());

        OrderDTO result = orderService.findById(existingOrderId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingOrderId);
    }

    @Test
    public void findByIdShouldReturnOrderDTOWhenIdExistsAndSelfClientLogged() {
        Mockito.doNothing().when(authService).validadeSelfOrAdmin(any());

        OrderDTO result = orderService.findById(existingOrderId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingOrderId);
    }

    @Test
    public void findByIdShouldThrowsForbiddenExceptionWhenIdExistsAndOtherClientLogged() {
        Mockito.doThrow(ForbiddenException.class).when(authService).validadeSelfOrAdmin(any());
        Assertions.assertThrows(ForbiddenException.class, () -> {
           OrderDTO result = orderService.findById(existingOrderId);
        });
    }

    @Test
    public void findByIdShouldThrowsResourceNotFoundExceptionWhenIdDoesNotExist() {
        Mockito.doNothing().when(authService).validadeSelfOrAdmin(any());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            OrderDTO result = orderService.findById(nonExistingOrderId);
        });
    }

    @Test
    public void insertShouldReturnOrderDTOWhenAdminLogged() {
        Mockito.when(userService.authenticated()).thenReturn(admin);
        OrderDTO result = orderService.insert(orderDTO);

        Assertions.assertNotNull(result);
    }

    @Test
    public void insertShouldReturnOrderDTOWhenClientLogged() {
        Mockito.when(userService.authenticated()).thenReturn(client);
        OrderDTO result = orderService.insert(orderDTO);

        Assertions.assertNotNull(result);
    }

    @Test
    public void insertShouldThrowsUsernameNotFoundExceptionWhenUserNotLogged() {
        Mockito.doThrow(UsernameNotFoundException.class).when(userService).authenticated();

        order.setClient(new User());
        orderDTO = new OrderDTO(order);

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
           OrderDTO result =  orderService.insert(orderDTO);
        });
    }

    @Test
    public void insertShouldThrowEntityNotFoundExceptionWhenOrderProductIdDoesNotExist() {
        Mockito.when(userService.authenticated()).thenReturn(client);

        product.setId(nonExistingProductId);
        OrderItem orderItem = new OrderItem(order, product, 2, 10.0);
        order.getItems().add(orderItem);

        orderDTO = new OrderDTO(order);

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            OrderDTO result =  orderService.insert(orderDTO);
        });
    }
}
