package org.example;

import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import java.util.Map;

public class DataIngestion {

    public static void ingestData() {
        try (Session session = Neo4jConnection.getSession()) {
            try (Transaction tx = session.beginTransaction()) {
                for (int i = 1; i <= 100; i++) {
                    tx.run("CREATE (p:Person {name: $name, age: $age})",
                            Map.of("name", "Person " + i, "age", i % 50 + 20)); // Creates 100 nodes
                }
                tx.commit();
            }
        }
    }
}

