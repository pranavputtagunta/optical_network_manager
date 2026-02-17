package com.example.optical_network_manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<NetworkDevice, Long> {
    // This interface will allow us to perform CRUD operations on NetworkDevice entities
    // Spring Data JPA will automatically generate the implementation based on the method signatures we define here
    // Creates .save(), .findById(), .findAll(), .deleteById(), etc. for NetworkDevice entities
}
