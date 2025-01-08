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
src/main/java/com/example/usermanagement
├── controller   # Controladores REST
├── model        # Entidades (User, Role)
├── repository   # Repositórios JPA
├── service      # Lógica de negócios
├── security     # Configuração de Spring Security e JWT
└── Application.java # Ponto de entrada principal
```
---
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
