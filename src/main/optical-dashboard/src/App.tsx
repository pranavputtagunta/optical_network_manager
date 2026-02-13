import React, { useState, useEffect } from "react";
import { NetworkDevice } from "./types"; // Import your interface

function App() {
  // 1. Tell React this state is an Array of NetworkDevice objects
  const [devices, setDevices] = useState<NetworkDevice[]>([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/devices")
      .then((response) => response.json())
      .then((data) => setDevices(data)) // TS implicitly trusts this, or you can cast it
      .catch((error) => console.error("Error:", error));
  }, []);

  return (
    <div style={{ padding: "50px" }}>
      <h1>Optical Network Inventory</h1>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {devices.map((device) => (
            <tr key={device.id}>
              <td>{device.name}</td>
              <td>{device.type}</td>
              {/* TS ensures device.status exists! */}
              <td>{device.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default App;
