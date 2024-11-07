package org.example;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Neo4jConnection.connect();

        // Ingest data
        System.out.println("Ingesting data...");
        DataIngestion.ingestData();

        // Paginate data
        System.out.println("Paginated results:");
        int page = 1;
        int pageSize = 10;
        List<Map<String, Object>> pageData;

        while (!(pageData = DataPagination.paginate(page, pageSize)).isEmpty()) {
            System.out.println("Page " + page + ": " + pageData);
            page++;
        }

        // Close the connection
        Neo4jConnection.close();
    }
}
