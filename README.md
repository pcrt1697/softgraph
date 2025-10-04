# softgraph
Backend application to store software architecture metadata

## Quickstart
Run the following command from the project root:
```commandline
docker-compose -f docker/docker-compose.local.yml up --force-recreate -d
```

Check out the swagger [UI](http://localhost:8080/api/swagger-ui/index.html#/).
Check out the graphiql [UI](http://localhost:8080/api/graphiql).

GraphQL calls are POST /api/graphql.

## todo-list
* Add links to rest service
* GraphQL
* Auth (?)
* Add java container, see [here](https://github.com/docker/awesome-compose/tree/master/spring-postgres)
* Documentation
* Tests
