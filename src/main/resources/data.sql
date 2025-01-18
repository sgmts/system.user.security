CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO users (name, email, password, role)
VALUES
('Samuel Martins', 'samuel@email.com', '$2a$10$cHQ.26eP121N2FUq9G9TMOS0a83cG3k62g95KlO4JZUsMHsxoBJpy', 'ADMIN'),
('João Silva', 'joao@email.com', '$2a$10$cHQ.26eP121N2FUq9G9TMOS0a83cG3k62g95KlO4JZUsMHsxoBJpy', 'USER'),
('Maria Souza', 'maria@email.com', '$2a$10$cHQ.26eP121N2FUq9G9TMOS0a83cG3k62g95KlO4JZUsMHsxoBJpy', 'USER');
