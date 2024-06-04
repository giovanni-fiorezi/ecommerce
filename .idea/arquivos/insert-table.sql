-- Definição da tabela permission com chave primária na coluna id
CREATE TABLE IF NOT EXISTS permission (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) DEFAULT NULL
);

-- Definição da tabela users
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE,
    full_name VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    account_non_expired BOOLEAN DEFAULT NULL,
    account_non_locked BOOLEAN DEFAULT NULL,
    credentials_non_expired BOOLEAN DEFAULT NULL,
    enabled BOOLEAN DEFAULT NULL
);

-- Definição da tabela user_permission com chaves estrangeiras corretamente referenciando as tabelas users e permission
CREATE TABLE IF NOT EXISTS user_permission (
    id_users BIGINT NOT NULL,
    id_permission BIGINT NOT NULL,
    PRIMARY KEY (id_users, id_permission),
    CONSTRAINT fk_user_permission FOREIGN KEY (id_users) REFERENCES users (id),
    CONSTRAINT fk_user_permission_permission FOREIGN KEY (id_permission) REFERENCES permission (id)
);