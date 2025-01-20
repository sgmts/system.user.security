# Sistema de Gestão de Usuários com Autenticação Segura
Uma API REST robusta construída com Spring Boot para gerenciar usuários, com autenticação segura utilizando Spring Security e JWT.

## Funcionalidades
- 🔒 Autenticação Segura:
  - Hash de senhas utilizando BCrypt. 
  - Autenticação stateless utilizando JWT. 
- 👥 Gestão de Usuários:
  - Operações CRUD para usuários. 
  - Controle de acesso baseado em papéis (ADMIN, USER). 
- 📄 Paginação e Ordenação:
  - Listagem eficiente de usuários. 
- ✅ Validação de Dados:
  - Validação de entrada para criação e atualização de usuários. 
- 📬 Endpoint "Esqueci minha senha" (Melhoria futura).
---

## Tecnologias Utilizadas
- Java 17+
  - Spring Boot:
  - Spring Security
  - Spring Data JPA
- Spring Web
- Banco de Dados: H2 (para desenvolvimento) ou PostgreSQL (produção).
- JWT: Autenticação baseada em JSON Web Tokens.
- Maven: Gerenciamento de dependências.
- Lombok: Redução de código boilerplate.
- JUnit: Framework de testes.
---
## Endpoints da API

### Endpoints Públicos
| Método | Endpoint         | Descrição                       |
|--------|------------------|---------------------------------|
| POST   | /api/auth/login  | Autenticação de usuários (JWT). |

### Endpoints Protegidos (JWT necessário)
| Método | Endpoint        | Descrição                        | Acessos |
|--------|-----------------|----------------------------------|---------|
| GET    | /api/users      | Listar todos os usuários         | ADMIN   |
| POST   | /api/users      | Criar novo usuário               | ADMIN   |
| PUT    | /api/users/{id} | Atualizar informações do usuário | ADMIN   |
| DELETE | /api/users/{id} | Excluir usuário                  | ADMIN   |
---
## Estrutura do Projeto
```
src/main/java/br/com/sgsa/system/user/security
├── controller   # Controladores REST
├── dto          # Classes DTO (LoginRequestDTO, JwtResponseDTO)
├── filter       # Filtros JWT para autenticação
├── model        # Entidades (User, Role)
├── repository   # Repositórios JPA
├── service      # Lógica de negócios
│   └── impl     # Implementações dos serviços
├── security     # Configuração de Spring Security e JWT
├── util         # Classes utilitárias (JwtUtil)
└── Application.java # Ponto de entrada principal
```
---
## 🔑Configuração de Autenticação
### Gerar Token (Login)
Envie uma requisição POST para /api/auth/login com as credenciais de um usuário:
```
{
    "email": "admin@email.com",
    "password": "senha123"
}
```
- Resposta
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9...",
    "type": "Bearer"
}

```

### Uso do Token nos Endpoints Protegidos
Adicione o cabeçalho **Authorization** em cada requisição:

``
Authorization: Bearer <seu-token-jwt>
``

## Padrão de Commits
Adotamos o [padrão Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/) para organizar o histórico do projeto. Use os seguintes prefixos para seus commits:
- `feat`: Adiciona uma nova funcionalidade. 
- `fix`: Corrige um bug. 
- `refactor`: Alterações no código que não adicionam novas funcionalidades ou corrigem bugs. 
- `docs`: Atualizações na documentação. 
- `style`: Alterações no estilo do código (formatação, espaçamento, etc.). 
- `test`: Adiciona ou atualiza testes. 
- `chore`: Manutenção ou alterações não relacionadas ao código de produção.

## Melhorias Futuras
- Adicionar endpoint "**Esqueci minha senha**" com envio de e-mails.
- Documentar a API com Swagger.
- Implementar cache de tokens JWT com Redis.
- Aumentar a cobertura de testes com testes de integração.
---
