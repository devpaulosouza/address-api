# Address-API
## API em Spring Boot para CRUD de dados de endereço

### Requisitos:
- Java 8+
- Postgres

## Recursos

[GET] `http://localhost:8080/addresses?page=0&size=10`
Faz uma consulta paginada dos registros salvos no banco

[GET] `http://localhost:8080/addresses/{addressId}`
Faz uma consulta de um registro único de endereço por id (Long)

[POST] `http://localhost:8080/addresses`
Cria um novo registro de endereço. Aceita como body um json com os dados no seguinte formato:

Os campos latitude e longitude são opcionais. Caso não sejam informados, será feito uma consulta na API de geolocalização do Google tentando buscar as coordenadas.
```json
{
    "streetName": "Av. Amazonas",
    "number": "478",
    "neighbourhood": "Centro",
    "city": "Belo Horizonte",
    "state": "Minas Gerais",
    "country": "Brasil",
    "zipCode": "30180-001",
    "latitude": 0.0,
    "longitude": 0.0
}
```

[PUT] `http://localhost:8080/addresses/{addressId}`
Atualiza o registro com os novos dados informados. O corpo da requisição válido é o mesmo do `POST`


[DELETE] `http://localhost:8080/addresses/{addressId}`
Exclui um registro por id (Long)


## Configuração
Caso queira executar no ambiente local, deverá informar as informações necessárias para acessar o banco de dados Postgres, e a chave de acesso da API de Geolocalização do Google.

As variáveis de ambientes necessárias são:
- DB_USERNAME
- DB_PASSWORD
- DB_HOST
- DB_PORT
- GEO_LOCATION_API_KEY

Estes valores podem ser alterados diretamente no arquivo de configuração `application.yml` ou configuradas nas variáveis de ambiente.

Para a execução no `Docker`, basta utilizar o `docker-compose` alterando as informações dos arquivos `docker-componse.yml` e `application-docker.yml` caso necessário.

