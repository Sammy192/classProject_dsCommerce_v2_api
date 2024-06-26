# Projeto Final - Sistema de Comércio Eletrônico DSCommerce
## Projeto JAVA Springboot JPA

![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/b378f1d6-98f2-4e58-83a3-67587171c1b9)
![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/4c049725-54c9-4793-8f96-151eea27443a)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este repositório contém o projeto final do treinamento **Java Spring Professional** ministrado pelo
professor [Nelio Alves](https://www.udemy.com/user/nelio-alves/), oferecido pela plataforma [DevSuperior](https://devsuperior.com.br/).</br></br>
Este projeto visa criar uma API RESTful de comércio
eletrônico usando tecnologias **Java, Spring Boot, Spring Data JPA, Bean Validation, PostgresSQL como banco de dados, Spring Security e JWT para controle de autenticação**.</br>

## Visão Geral do Sistema
O sistema desenvolvido neste projeto é uma aplicação completa de comércio eletrônico,
abrangendo cadastros de usuários, produtos e categorias. Cada usuário, seja cliente ou administrador,
tem sua própria área de interação com o sistema. Os administradores têm acesso à área administrativa para gerenciar
usuários, produtos e categorias.

## Testes implementados usando JUNI, mockMVC e cobertura de testes com Jacoco Report

## Funcionalidades Principais

- Cadastro e autenticação de usuários com diferentes papéis (cliente, administrador).
- Catálogo de produtos com capacidade de filtragem por nome.
- Adição, remoção e alteração de itens no carrinho de compras.
- Registro de pedidos com status dinâmicos (aguardando pagamento, pago, enviado, entregue, cancelado).
- Área administrativa para gerenciamento de usuários, produtos e categorias.


### Documento de requisitos

Documento de requisitos pode ser acessado aqui -> [Documento de Requisitos](https://drive.google.com/drive/folders/1WTBggtq38cLeeQosPHjuhjSLxa94Lmx_)

### Modelo de classes
![image](https://github.com/Sammy192/classProject_dsCommerce_v1/assets/53224915/5b3a378c-3adb-4eec-8a17-f651b574d5f7)

### Modelo de camadas

![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/ed5e49ec-7d18-411e-8236-77c8b6439d96)


![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/59f90a78-aa53-41f4-9713-771635bdf343)


## Como executar este projeto
##### Pré-requisitos:
- **Java 17**: [JDK 17](https://www.oracle.com/java/technologies/downloads/) ou superior.
- **IDEs**: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) ou [Spring Tools](https://spring.io/tools).

##### Passos:

1. **Clone o repositório**</br>
Abra o terminal e navegue até o diretório onde deseja armazenar o projeto.
Clone o reposiório.

2. **Abra o projeto no IntelliJ IDEA ou STS:**</br>
- _IntelliJ IDEA_: Abra o IntelliJ IDEA e selecione "Open" no menu principal. Navegue até o diretório do projeto e selecione o arquivo pom.xml.
- _Spring Tools Suite_: Abra o STS e selecione "Import...​" > "Existing Maven Projects". Navegue até o diretório do projeto e selecione o arquivo pom.xml.

3. **Baixe as dependências do Maven:**</br>
Aguarde até que o IntelliJ ou STS baixe automaticamente as dependências do Maven. Isso pode levar algum tempo, dependendo da conexão com a internet.</br></br>
4. **Execute o projeto:**</br>
No projeto, navegue até o arquivo `src/main/java/br/com/guilchaves/dscommerce/DscommerceApplication.java`. Este arquivo contém 
a classe principal da aplicação Spring Boot.</br>
- _IntelliJ IDEA_: Clique com o botão direito do mouse no arquivo DscommerceApplication.java e escolha "Run DscommerceApplication".
- _Spring Tools Suite_: Clique com o botão direito do mouse no projeto no navegador de projetos e escolha "Run As" > "Spring Boot App".

5. **Verifique a Execução:**</br>
Após a execução bem-sucedida, abra um navegador da web e acesse `http://localhost:8080` (ou a porta configurada, se diferente) para verificar se a aplicação está em execução.</br>
Acesse `http://localhost:8080/h2-console` para utilizar o console do H2 database.</br>


## Para testar a API no postman:
Para importar e exportar dados no postman, consulte a documentação oficial [aqui](https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-data/).
</br>
Download da coleção e variáveis de ambiente:
- [Collection](https://drive.google.com/file/d/1TjBh5Nu5znqEB-umnf304MMHe8USVLdj/view?usp=sharing)
- [Environment](https://drive.google.com/file/d/1_L1r4OSXcIJVxGzq-vGHYYP8CpoD5fhD/view?usp=sharing)
 
## Endpoints da API:

```
POST /login - Autenticação na API.

GET /categories - Retorna lista de categorias dos produtos.

GET /orders/{id} - Retorna pedido do usuário por id - clientes não podem acessar pedidos de outros clientes (requer privilégio ADMIN ou OPERATOR).

POST /orders - Adiciona novo pedido para cliente logado.

GET /products - Retorna lista de produtos.

GET /products/{id} - Retorna produto por id.

POST /products - Adiciona novo produto (requer privilégio ADMIN).

PUT /products/{id} - Atualiza dados de produto já existente (requer privilégio ADMIN).

DELETE /products/{id} - Remove produto da base de dados (requer privilégio ADMIN).

GET /users/me - Retorna dados do usuário logado (requer privilégio ADMIN ou OPERATOR).
```

### EndPoints corpo:
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
## Autenticação
A API utiliza o Spring Security para controle de autenticação. Os seguintes papéis estão disponíveis:
```
OPERATOR -> Papel padrão para usuários autenticados.
ADMIN -> Papel de administrador para gerenciar produtos (adicionar, atualiza, remove produtos). 
```
Para acessar os endpoints protegidos como um usuário ADMIN, forneça as credenciais de autenticação adequadas no cabeçalho da requisição.


 Pode ser baixado o projeto e subir localmente após importar o projeto em uma IDE de sua preferência.
