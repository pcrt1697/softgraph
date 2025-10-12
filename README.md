# softgraph
Backend application to store software architecture metadata

#### Table of content
* [Overview](#overview)
  * [Concepts](#concepts)
  * [Backend design](#backend-design)
* [Quickstart](#quickstart)
* [Next steps](#next-steps)

## Overview
The application aim to provide a backend application to map a software architecture.

Technology stack:
* PostgreSQL database;
* Spring backend application with both REST and GraphQL APIs (secured by api key authentication).

### Concepts
There are two main entities: components and connections. Each kind of entity belongs to a certain type.

Adding new component types is quite straightforward since everything is managed using polymorphic types. 

#### Components
A component is an atomic piece of software, there are three types of component:
* **batch**: a batch application that is typically executed by a scheduler;
* **database**: a database instance;
* **microservice**: a web service that exposes APIs.

Components are stored in the `components` table.

#### Connections
A connection is a relationship between components, there are three types of connections:
* **batch-invocation**: used when a batch component invokes another batch program;
* **database-connection**: used to describe a connection from an application to a database;
* **microservice-call**: used when an application calls a microservice.

Connections are stored in the `connections` table.

## Quickstart
Run the following command from the project root to start the project with some demo data:
```commandline
SOFTGRAPH_API_KEY=default SOFTGRAPH_PG_PWD=softgraph docker-compose -f docker/docker-compose.local.yml up --force-recreate -d
```
Where:
* SOFTGRAPH_API_KEY: is the api key used to authenticate to the service;
* SOFTGRAPH_PG_PWD: password of the user `softgraph` (used by the backed application).

Use the [docker-compose.local.yml](docker/docker-compose.local.yml) to start an empty project.

* Checkout the [swagger UI](http://localhost:8080/api/swagger-ui/index.html#/). Note that requests must be authenticated with the provided API key.
* Check out the [graphiql UI](http://localhost:8080/api/graphiql). To fetch the schema add the header key `x-api-key` and hit the refresh button.

## Next steps
To-do list:
* Improve search using exist statements
* Add patch endpoints
* Add GraphQL mutations
* Add a batch to dump data to a Neo4j replica
