# Lembree — Backend

Backend do **Lembree**, app de captura rápida de pendências e compromissos
("o que eu não posso esquecer"), com foco em fricção mínima: captura por
texto/voz, o app avisa sozinho no momento certo, resolução em 1 toque.

## Stack

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA (Hibernate)
- Spring Security + JWT
- PostgreSQL
- Flyway (versionamento de schema)
- Maven

## Arquitetura

Clean Architecture / DDD, separada em três camadas:

- `domain` — modelo de domínio puro (regras de negócio, sem depender de framework)
- `application` — casos de uso, DTOs de aplicação, portas (interfaces)
- `infrastructure` — implementações concretas: persistência (JPA), web (controllers), segurança, parser

## Status

Projeto em desenvolvimento inicial.