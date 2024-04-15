CREATE TABLE IF NOT EXISTS public.produto
(
    id SERIAL PRIMARY KEY,
    categoria character varying(255) COLLATE pg_catalog."default",
    descricao character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    preco numeric(19,2),
    quantidade integer
    );