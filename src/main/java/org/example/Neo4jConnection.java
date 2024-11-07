package org.example;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

public class Neo4jConnection {
    private static final String NEO4J_URI = "bolt://localhost:7687"; // Use appropriate URI
    private static final String USERNAME = "neo4j";
    private static final String PASSWORD = "Neha11@S";

    private static Driver driver;

    public static void connect() {
        driver = GraphDatabase.driver(NEO4J_URI, AuthTokens.basic(USERNAME, PASSWORD));
    }

    public static Session getSession() {
        if (driver == null) {
            connect();
        }
        return driver.session();
    }

    public static void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
