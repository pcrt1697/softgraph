package com.pcrt.softgraph.model.model.connection;

public enum ConnectionType {
    BATCH_INVOCATION, DATABASE_CONNECTION, MICROSERVICE_CALL;

    public static class Types {
        public static final String BATCH_INVOCATION = "BATCH_INVOCATION";
        public static final String DATABASE_CONNECTION = "DATABASE_CONNECTION";
        public static final String MICROSERVICE_CALL = "MICROSERVICE_CALL";
    }

}
