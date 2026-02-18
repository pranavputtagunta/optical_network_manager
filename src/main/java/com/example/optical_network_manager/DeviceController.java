package com.example.optical_network_manager;

import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Controller to handle API requests related to Network Devices
 * Like FastAPI/Express router, but with more annotations and boilerplate
 */

@RestController // Tells Spring this class will handle HTTP requests and return JSON responses
@RequestMapping("/api") // Base path for all endpoints in this controller (e.g., /api/devices)
// @CrossOrigin(origins = "http://localhost:3000") // Allow React to access this (Handles CORS issues)
public class DeviceController {

    private final DeviceService deviceService; // Service to handle business logic

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService; // Spring will automatically inject the service instance
    }

    @GetMapping("/devices") // Maps GET requests to /api/devices to this method
    public List<NetworkDevice> getDevices() {
        return deviceService.getAllDevices(); // Call the service method to fetch all devices
    }

    @PostMapping("/devices") // Maps POST requests to /api/devices to this method
    public NetworkDevice addDevice(@RequestBody NetworkDevice device) {
        return deviceService.addDevice(device); // Call the service method to add a new device
    }

    @DeleteMapping("/devices/{id}") // Maps DELETE requests to /api/devices/{id} to this method
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id); // Call the service method to delete a device by ID
    }
}