INSERT INTO softgraph_app.components
    ("type","name",description,documentation_url,database_technology,cron_expression,programming_language,repository_url,service_url,ts_create,ts_update)
VALUES
    ('BATCH','batch-1','description of batch 1','doc/url/of/batch/1',NULL,'0 0 12 * * ?','BASH','repo/url/of/batch/1',NULL,'2025-10-04 12:22:51.195066','2025-10-04 12:22:51.195066'),
	('BATCH','batch-2','description of batch 2','doc/url/of/batch/2',NULL,NULL,'PYTHON','repo/url/of/batch/2',NULL,'2025-10-04 12:22:59.671297','2025-10-04 12:22:59.671297'),
	('BATCH','batch-3','description of batch 3','doc/url/of/batch/3',NULL,NULL,'JAVA','repo/url/of/batch/3',NULL,'2025-10-04 12:23:07.388669','2025-10-04 12:23:07.388669'),
	('BATCH','batch-4','description of batch 4','doc/url/of/batch/4',NULL,'0 0 11 * * ?','BASH','repo/url/of/batch/4',NULL,'2025-10-04 12:23:14.555867','2025-10-04 12:23:14.555867'),
	('DATABASE','database-1','description of database 1','doc/url/of/database/1','MONGODB',NULL,NULL,NULL,'service/url/of/database/1','2025-10-04 12:23:20.963469','2025-10-04 12:23:20.963469'),
	('DATABASE','database-2','description of database 2','doc/url/of/database/2','POSTGRESQL',NULL,NULL,NULL,'service/url/of/database/2','2025-10-04 12:23:28.076322','2025-10-04 12:23:28.076322'),
	('MICROSERVICE','microservice-1','description of microservice 1','doc/url/of/microservice/1',NULL,NULL,'JAVA','repo/url/of/microservice/1','service/url/of/microservice/1','2025-10-04 12:23:36.948797','2025-10-04 12:23:36.948797'),
	('MICROSERVICE','microservice-2','description of microservice 2','doc/url/of/microservice/2',NULL,NULL,'PYTHON','repo/url/of/microservice/2','service/url/of/microservice/2','2025-10-04 12:23:42.658237','2025-10-04 12:23:42.658237');

INSERT INTO softgraph_app.connections
	("type",description,id_source,id_target,batch_order,database_entity,database_operation,microservice_endpoint,ts_create,ts_update)
VALUES
	('BATCH_INVOCATION','First batch invoked',1,2,1,NULL,NULL,NULL,'2025-10-04 13:28:53.335381','2025-10-04 13:28:53.335381'),
	('BATCH_INVOCATION','Second batch invoked',1,3,2,NULL,NULL,NULL,'2025-10-04 13:30:05.668979','2025-10-04 13:30:05.668979'),
	('DATABASE_CONNECTION','a description',2,5,NULL,'schema1.collection1','READ',NULL,'2025-10-04 13:31:54.855144','2025-10-04 13:31:54.855144'),
	('DATABASE_CONNECTION',NULL,2,5,NULL,'schema1.collection1','WRITE',NULL,'2025-10-04 13:32:18.699559','2025-10-04 13:32:18.699559'),
	('DATABASE_CONNECTION',NULL,2,5,NULL,'schema1.collection2','READ',NULL,'2025-10-04 13:32:37.411525','2025-10-04 13:32:37.411525'),
	('DATABASE_CONNECTION',NULL,3,6,NULL,'schema2.table1','READ',NULL,'2025-10-04 13:32:46.651749','2025-10-04 13:32:46.651749'),
	('DATABASE_CONNECTION',NULL,3,6,NULL,'schema2.table2','WRITE',NULL,'2025-10-04 13:32:55.195329','2025-10-04 13:32:55.195329'),
	('DATABASE_CONNECTION',NULL,7,6,NULL,'schema2.table3','READ',NULL,'2025-10-04 13:33:07.093083','2025-10-04 13:33:07.093083'),
	('DATABASE_CONNECTION',NULL,7,6,NULL,'schema2.table3','WRITE',NULL,'2025-10-04 13:33:15.377107','2025-10-04 13:33:15.377107'),
	('DATABASE_CONNECTION',NULL,7,6,NULL,'schema2.table3','DELETE',NULL,'2025-10-04 13:33:23.905671','2025-10-04 13:33:23.905671'),
	('DATABASE_CONNECTION',NULL,8,5,NULL,'schema1.collection3','READ',NULL,'2025-10-04 13:33:36.660664','2025-10-04 13:33:36.660664'),
	('DATABASE_CONNECTION',NULL,8,5,NULL,'schema1.collection3','WRITE',NULL,'2025-10-04 13:33:42.880172','2025-10-04 13:33:42.880172'),
	('DATABASE_CONNECTION',NULL,8,5,NULL,'schema1.collection3','DELETE',NULL,'2025-10-04 13:33:50.943806','2025-10-04 13:33:50.943806'),
	('MICROSERVICE_CALL','a description',7,8,NULL,NULL,NULL,'POST endpoint/subpath/1','2025-10-04 13:33:56.022998','2025-10-04 13:33:56.022998'),
	('MICROSERVICE_CALL',NULL,2,8,NULL,NULL,NULL,'GET endpoint/subpath/2','2025-10-04 13:33:59.784577','2025-10-04 13:33:59.784577');
