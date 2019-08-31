# Grupo-C2A-022019-Back-End

## Table of contents

- [Development](#Development)
- [References](#References)

## Development

### Requirements

- Docker

### Database

```bash
docker run \
--restart unless-stopped \
--name c2a-mysql \
-v ~/mysql:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=viandasya \
-e MYSQL_USER=user \
-e MYSQL_PASSWORD=password \
-p 3306:3306 \
-p 33060:33060 \
-d mysql:8
```

## References

- [ORM Entity Mapping](https://docs.jboss.org/hibernate/orm/5.4/quickstart/html_single/#tutorial_annotations)
