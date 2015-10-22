package com.john;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */
public class App {
    
    Cluster cluster;
    Session session;
    
    
    public static void main( String[] args ) {
        
        System.out.println("START");
        App app = new App();
        app.initialize();
        app.doIt();
        app.cleanup();
        System.out.println("DONE");
    }
    
    public void initialize() {
        // Connect to the cluster and keyspace "demo"
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("people");
        
    }
    
    public void doIt() {
        
        int i = 0;
        while (true) {
            
            session.execute("INSERT INTO employees (id, name, email) VALUES (now(), 'David Gilmore4', 'bob@example.com')");
            session.execute("INSERT INTO employees (id, name, email) VALUES (now(), 'David Gilmorezz3', 'bob3@example.com')");
            
            //ResultSet results = session.execute("SELECT * FROM employees WHERE email='bob@example.com'");
            //for (Row row : results) {
            //    System.out.println("name:" + row.getString("name") + " email:" + row.getString("email"));
           // }
            
            i += 1;
            if ((i % 1000) == 0) {
                System.out.println(i);
            }
            
        }
    }
    
    public void cleanup() {
        
        cluster.close();
        
    }
}
