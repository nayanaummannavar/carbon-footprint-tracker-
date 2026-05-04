import { useEffect, useState } from "react";

function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/all")
      .then(res => res.json())
      .then(result => setData(result))
      .catch(err => console.log(err));
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>🌍 Carbon Footprint Tracker</h1>

      {data.length === 0 ? (
        <p>No Data Found</p>
      ) : (
        data.map((item) => (
          <div
            key={item.id}
            style={{
              border: "1px solid #000",
              margin: "10px",
              padding: "10px",
              borderRadius: "8px"
            }}
          >
            <h3>{item.activity}</h3>
            <p>Category: {item.category}</p>
            <p>Carbon: {item.carbonKg} kg</p>
            <p>Date: {item.date}</p>
            <p>Status: {item.status}</p>
          </div>
        ))
      )}
    </div>
  );
}

export default App;