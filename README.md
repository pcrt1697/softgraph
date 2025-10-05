# softgraph
Backend application to store software architecture metadata

## Quickstart
Run the following command from the project root:
```commandline
docker-compose -f docker/docker-compose.local.yml up --force-recreate -d
```

Check out the [swagger UI](http://localhost:8080/api/swagger-ui/index.html#/). Note that requests must be authenticated with API key.

Check out the [graphiql UI](http://localhost:8080/api/graphiql). To fetch the schema add the header key `x-api-key` and hit the refresh button.

## todo-list
* Improve search using exist statements
* Add patch endpoints
* Add java container, see [here](https://github.com/docker/awesome-compose/tree/master/spring-postgres) or [here](https://stackoverflow.com/questions/74549165/how-to-generate-a-jar-file-in-the-dockerfile)
