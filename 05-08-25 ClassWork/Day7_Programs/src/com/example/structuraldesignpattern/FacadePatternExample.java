package com.example.structuraldesignpattern;


/* When a system is too complex and needs a simple interface for clients
 * When multiple subsystems interact and you want to manage them centrally
 * 
 * For eg:  you are deploying an application to a cloud platform like AWS which requires setting of network , databases and some security policies .
 * Instead of dealing with each component separately we can use a CloudFacade
 * Hide subsystem details and promoting loose coupling
 * 
 * */


class ComputeService {
    void startServer() {
        System.out.println("Compute server started");
    }
}

class DatabaseService {
    void configureDatabase() {
        System.out.println("Database Configured");
    }
}

class SecurityService {
    void setSecurityRules() {
        System.out.println("Security Rules Applied");
    }
}

class AWSCloudFacade {
    private ComputeService compute;
    private DatabaseService database;
    private SecurityService security;

    AWSCloudFacade() {
        this.compute = new ComputeService();       // Correct assignment to instance
        this.database = new DatabaseService();     // Correct assignment to instance
        this.security = new SecurityService();     // Correct assignment to instance
    }

    public void deployApplication() {
        System.out.println("Starting Cloud Deployment...");
        compute.startServer();
        database.configureDatabase();
        security.setSecurityRules();
    }
}

public class FacadePatternExample {
    public static void main(String[] args) {
        AWSCloudFacade clf = new AWSCloudFacade();
        clf.deployApplication();  // Single simplified interface
    }
}
