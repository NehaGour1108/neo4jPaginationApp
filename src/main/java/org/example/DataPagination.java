package org.example;

import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataPagination {

    public static List<Map<String, Object>> paginate(int page, int pageSize) {
        List<Map<String, Object>> results = new ArrayList<>();
        int skip = (page - 1) * pageSize;

        try (Session session = Neo4jConnection.getSession()) {
            String query = "MATCH (p:Person) RETURN p.name AS name, p.age AS age SKIP $skip LIMIT $limit";
            Result result = session.run(query, Map.of("skip", skip, "limit", pageSize));

            for (Record record : result.list()) {
                results.add(record.asMap());
            }
        }

        return results;
    }
}

