# Sistema DSCommerce v2 API REST
## Projeto JAVA Springboot JPA

Desenvolvimento de recursos (endpoints) de API REST

Projeto desenvolvido durante aula do curso de Formação Desenvolvedor Moderno ministrado pela [DevSuperior](https://devsuperior.com.br) (Nélio Alves).
Utilizado banco de dados em memória H2.
Javaspringboot
Hibernate - Jakarta

### Documento de requisitos

Documento de requisitos pode ser acessado aqui -> [Documento de Requisitos](https://drive.google.com/drive/folders/1WTBggtq38cLeeQosPHjuhjSLxa94Lmx_)

### Modelo de classes
![image](https://github.com/Sammy192/classProject_dsCommerce_v1/assets/53224915/5b3a378c-3adb-4eec-8a17-f651b574d5f7)

### Modelo de camadas

![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/ed5e49ec-7d18-411e-8236-77c8b6439d96)


![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/59f90a78-aa53-41f4-9713-771635bdf343)


### EndPoints:

Retorna a busca de um produto por id
GET - http://localhost:8080/products/1

Retorna a busca de lista de produtos paginada
GET - http://localhost:8080/products?size=12&page=0&sort=name

Realiza o insert de um novo produto
POST - http://localhost:8080/products
No body:
```
{
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "price": 200.0
}
```

Realiza o update de um produto dado o seu id
PUT - http://localhost:8080/products/100
Body - utile o mesmo exemplo de um novo produto.

Realiza o delete de um produto dado o seu id
DEL - http://localhost:8080/products/10


 Pode ser baixado o projeto e subir localmente após importar o projeto em uma IDE de sua preferência.
