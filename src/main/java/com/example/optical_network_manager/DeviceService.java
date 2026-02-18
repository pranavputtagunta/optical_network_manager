package com.example.optical_network_manager;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService {
    
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository; // Spring will automatically inject the repository instance
    }

    public List<NetworkDevice> getAllDevices() {
        return deviceRepository.findAll(); // Fetches all devices from the database
    }

    public NetworkDevice addDevice(NetworkDevice device) {
        if (device.getName() == null || device.getName().isEmpty()) {
            throw new IllegalArgumentException("Device name can't be empty");
        }
        return deviceRepository.save(device); // Saves a new device to the database
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id); // Deletes a device by its ID
    }

}
