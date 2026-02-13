package com.example.optical_network_manager;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Controller to handle API requests related to Network Devices
 * Like FastAPI/Express router, but with more annotations and boilerplate
 */

@RestController // Tells Spring this class will handle HTTP requests and return JSON responses
@RequestMapping("/api") // Base path for all endpoints in this controller (e.g., /api/devices)
@CrossOrigin(origins = "http://localhost:3000") // Allow React to access this (Handles CORS issues)
public class DeviceController {

    @GetMapping("/devices") // Maps GET requests to /api/devices to this method
    public List<NetworkDevice> getDevices() {
        // Return a dummy list for today to test the server
        List<NetworkDevice> devices = new ArrayList<>(); 
        devices.add(new NetworkDevice(1L, "Switch-01", "Optical Switch", "Active"));// works because lombok @AllArgsConstructor creates a constructor with all args
        return devices; // List of devices will be automatically converted to JSON by Spring Boot (thanks to @RestController)
    }
}