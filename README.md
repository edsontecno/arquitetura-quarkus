# Arquitetura padrão quakus

Essa é uma arquitetura padrão utilizando Quarkus.

## Rodando a aplicação em desenvolvimento

Você pode rodar de duas formas:

- Utilizando o maven
```shell script
./mvnw compile quarkus:dev
```

- Utilizando a linha de comando, para isso é necessário realizar a instalação de forma global:

```shell scritp
curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/
curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio


```
Depois execute o comando:
```shell scritp
quarkus dev
```
- Utilizando docker
```shell scritp
docker-compose up
```

> **_NOTE:_**  Uma vez funcionando a aplicação estará disponível em http://localhost:8080.

## Recursos implementados

### Handle exception

Toda exceção será tratada no arquivo `ExceptionsFilter`

### Annotation para autorização
Já está implemtado a annotation para tratar de autorizações, sua utilização se dá seguinte forma:

No método escolhido adicionar a annotation `@Authorization(value="nome da regra")` e seu tratamento é realizado pela classe `AuthorizationService`

### Annotation para autorização
Filtro para todas as requisições implemetado pela classe `LogFilter`

### Metrics
No endereço /metrics já está disponível as métricas de acessos no padrão B5

### Swagger

No endereço /api-docs está disponível a documentação dos endpoints mapeados via swagger.

### Erros
Todas as mensagens de erro devem ficar centralizadas no arquivo `messageEnum`. Elas são acessíveis pelo endpoint /errors

