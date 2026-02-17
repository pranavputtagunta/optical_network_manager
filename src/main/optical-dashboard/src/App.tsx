import React, { useState, useEffect } from "react";
import { NetworkDevice } from "./types"; // Import your interface

function App() {
  // 1. Tell React this state is an Array of NetworkDevice objects
  const [devices, setDevices] = useState<NetworkDevice[]>([]);

  const [name, setName] = useState("");
  const [type, setType] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/devices")
      .then((response) => response.json())
      .then((data) => setDevices(data)) // TS implicitly trusts this, or you can cast it
      .catch((error) => console.error("Error:", error));
  }, []);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // Prevent form from refreshing the page
    const newDevice = { name, type }; // Create a new device object
    fetch("http://localhost:8080/api/devices", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newDevice), // Send the new device as JSON
    }).then(() => {
      window.location.reload();
    });
  };

  return (
    <div style={{ padding: "50px" }}>
      <form onSubmit={handleSubmit}>
        <input
          placeholder="Name"
          value={name}
          // Typed Change Handler
          onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
            setName(e.target.value)
          }
        />
        <input
          placeholder="Type"
          value={type}
          onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
            setType(e.target.value)
          }
        />
        <button type="submit">Add Node</button>
      </form>
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
