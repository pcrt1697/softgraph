drop schema if exists softgraph_app cascade;
create schema softgraph_app authorization softgraph;

create table softgraph_app.components (

	id bigint not null generated always as identity,
	type varchar(200) not null,
	name varchar(500) not null,
	description varchar(2000),
    documentation_url varchar(2000),

    database_technology varchar(200),
    cron_expression varchar(200),
    programming_language varchar(200),
    repository_url varchar(2000),
	service_url varchar(2000),

    ts_create timestamp without time zone not null,
    ts_update timestamp without time zone not null,

    constraint components_pk primary key (id)
);

create table softgraph_app.connections (
	id bigint not null generated always as identity,
	type varchar(200) not null,
    description varchar(2000),
    id_source bigint,
    id_target bigint,

	batch_order integer,
    database_entity varchar(1000),
    database_operation varchar(50),
    microservice_endpoint varchar(1000),

	ts_create timestamp without time zone not null,
    ts_update timestamp without time zone not null,

	constraint connections_pk primary key (id),
	constraint connections_source_fk foreign key (id_source) references softgraph_app.components (id),
	constraint connections_target_fk foreign key (id_target) references softgraph_app.components (id)
);
