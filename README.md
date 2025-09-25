# softgraph
Backend application to store software architecture metadata

## Quickstart
Run the following command from the project root:
```commandline
docker-compose -f docker/docker-compose.local.yml up --force-recreate -d
```

Check out the swagger [UI](http://localhost:8080/api/swagger-ui/index.html#/).
Check out the graphiql [UI](http://localhost:8080/api/graphiql).
Query the database [UI](http://localhost:8080/api/swagger-ui/index.html#/).

GraphQL calls are POST /api/graphql.

## todo-list
* Add endpoints to manage db connections and microservice calls, with polymorphic body (update add batch invocations too) 
* GraphQL
* Add java container, see [here](https://github.com/docker/awesome-compose/tree/master/spring-postgres)
* Auth (?)
* Documentation
* Tests
