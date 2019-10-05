# Grupo-C2A-022019-Back-End

## Table of contents

- [Development](#Development)
  - [Database](#Database)
  - [Api](#Api)
- [References](#References)

## Development

### Requirements

- Docker

### Database

```bash
docker run \
-v ~/postgres:/var/lib/postgresql/data \
--restart unless-stopped \
--name c2a-postgres \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_USER=user \
-e POSTGRES_DB=viandasya \
-p 5432:5432 \
-d postgres:12-alpine
```

### Api

```bash
JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/viandasya \
JDBC_DATABASE_USERNAME=user \
JDBC_DATABASE_PASSWORD=password \
mvn spring-boot:run
```

## References

- [ORM Entity Mapping](https://docs.jboss.org/hibernate/orm/5.4/quickstart/html_single/#tutorial_annotations)
- [Hibernate Configuration](http://www.cursohibernate.es/doku.php?id=unidades:02_hibernate:03_configurando)
- [Spring-Boot Maven-Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html)
