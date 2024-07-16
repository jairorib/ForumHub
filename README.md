# ForumHub
![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=Tipo&message=Desafio&color=GREEN&style=for-the-badge)
## Descrição

Este projeto é uma API REST de Fórum de perguntas desenvolvida utilizando Spring Boot. Ele oferece operações CRUD básicas.

## Tecnologias Utilizadas

- ``Java JDK 17 ou superior``
- ``Maven 4.x``
- ``MySQL 8.x``

## Requisições Suportadas

A API suporta as seguintes requisições:

### Listar todos os tópicos

- **Método:** GET
- **Endpoint:** `/topicos`
- **Descrição:** Retorna todos os recursos cadastrados.

**Exemplo de Resposta (200 OK):**

```json
{
  "totalPages": 1,
  "totalElements": 1,
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "size": 10,
  "content": [
    {
      "id": 1,
      "titulo": "me ajuda nessa dúvida",
      "mensagem": "tenho um dúvida",
      "dataCriacao": "1970-01-01T00:00:00",
      "status": "ABERTA",
      "autor": "anonimo",
      "curso": "java"
    },
    {
      "id": 2,
      "titulo": "me ajuda nessa outra dúvida",
      "mensagem": "tenho um dúvida também",
      "dataCriacao": "1970-01-01T00:00:00",
      "status": "ABERTA",
      "autor": "Alice",
      "curso": "java"
    }
  ],
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "first": true,
  "last": true,
  "numberOfElements": 2,
  "empty": false
}

```

### Detalhar tópico

- **Método:** GET
- **Endpoint:** `/topicos/{id do tópico}`
- **Headers Requeridos:** Authorization: \<token JWT do tipo Bearer>

**Exemplo de Resposta (200 OK):**

```json
    {
      "id": 1,
      "titulo": "me ajuda nessa dúvida",
      "mensagem": "tenho um dúvida",
      "dataCriacao": "1970-01-01T00:00:00",
      "status": "ABERTA",
      "autor": "anonimo",
      "curso": "java"
    }
```

### Autenticação

- **Método:** POST
- **Endpoint:** `/login`
- **Headers Requeridos:** Content-Type: application/json

- **Corpo da Requisição:**

```json
{
    "login": "Bob",
    "senha": "<senha do usuário>"
}
```

**Exemplo de Resposta (200 OK):**

```json
{
  "token": "<token JWT>"
}
```

### Registrar tópico

- **Método:** POST
- **Endpoint:** `/topicos`
- **Headers Requeridos:** Content-Type: application/json,
- **Headers Requeridos:** Authorization: \<token JWT do tipo Bearer>
- **Corpo da Requisição:**

```json
{
    "titulo": "me ajuda nessa dúvida",
    "mensagem": "tenho uma dúvida",
    "autor": "Bob",
    "curso": "java"
}
```

**Exemplo de Resposta (201):**

```json
{
    "id": 1,
    "título":"me ajuda nessa dúvida",
    "mensagem":"tenho uma dúvida",
    "dataCriacao":"1970-01-01T00:00:00""
    "status":"ABERTA"
    "autor":"Bob",
    "curso":"java"
}
```

### Atualizar tópico

- **Método:** PUT
- **Endpoint:** `/topicos`
- **Headers Requeridos:** Content-Type: application/json,
- **Headers Requeridos:** Authorization: \<token JWT do tipo Bearer>
- **Corpo da Requisição:**

```json
{
    "id": 1,
    "status": "RESPONDIDA"
}
```

**Exemplo de Resposta (200 OK):**

```json
{
    "id": 1,
    "título":"me ajuda nessa dúvida",
    "mensagem":"tenho uma dúvida",
    "dataCriacao":"1970-01-01T00:00:00""
    "status":"RESPONDIDA"
    "autor":"Bob",
    "curso":"java"
}
```

### Deletar tópico

- **Método:** DELETE
- **Endpoint:** `/topicos/{id do tópico}`
- **Headers Requeridos:** Authorization: \<token JWT do tipo Bearer>

**Resposta (204):**

## Como Executar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/jairorib/ForumHub.git
   
2. Configure o banco de dados MySQL

3. Atualize as credenciais do banco de dados no arquivo `application.properties`.

4. Compile e acesse a rota http://localhost:8080/login para obter um token JWT válido.
