package com.example.optical_network_manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Database schema defintion
 * (Like Pydantic model in FastAPI + ORM (Object-Relational Mapping))
 */

@Entity // 1. Tells Java this class maps to a SQL table
@Data // 2. Lombok generates Getters/Setters automatically
@NoArgsConstructor
@AllArgsConstructor // Creates a constructor with all args (for testing purposes)
public class NetworkDevice { // SQL table will be called "network_device" by default (lowercase + underscores)
    @Id @GeneratedValue // Marks primary key and tells DB to auto-increment it
    private Long id;
    private String name;        // e.g., "Nokia 1830 PSS"
    private String type;        // e.g., "ROADM", "Amplifier"
    private String status;      // e.g., "Active", "Alarm"
}