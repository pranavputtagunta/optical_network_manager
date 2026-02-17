package com.example.optical_network_manager;

import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Controller to handle API requests related to Network Devices
 * Like FastAPI/Express router, but with more annotations and boilerplate
 */

@RestController // Tells Spring this class will handle HTTP requests and return JSON responses
@RequestMapping("/api") // Base path for all endpoints in this controller (e.g., /api/devices)
@CrossOrigin(origins = "http://localhost:3000") // Allow React to access this (Handles CORS issues)
public class DeviceController {

    private final DeviceRepository deviceRepository; // Repository to interact with the database

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository; // Spring will automatically inject the repository instance
    }

    @GetMapping("/devices") // Maps GET requests to /api/devices to this method
    public List<NetworkDevice> getDevices() {
        return deviceRepository.findAll(); // List of devices will be automatically converted to JSON by Spring Boot (thanks to @RestController)
    }

    @PostMapping("/devices") // Maps POST requests to /api/devices to this method
    public NetworkDevice addDevice(@RequestBody NetworkDevice device) {
        return deviceRepository.save(device); // Save the new device to the database and return the saved entity (with ID)
    }
}