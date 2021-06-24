import React from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import 'leaflet/dist/leaflet.css';
import 'leaflet-defaulticon-compatibility/dist/leaflet-defaulticon-compatibility.webpack.css'; // Re-uses images from ~leaflet package
import 'leaflet-defaulticon-compatibility';

const MyComponent = () => {
    const defaultPosition = [48.864716, 2.349]; // Paris position
    const position = [51.505, -0.09];

    return (
        <div className="map__container">
            <MapContainer
                center={position}
                zoom={13}
                style={{ height: '100vh', width: '100wh' }}
            >
                <TileLayer
                    attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                />
                <Marker position={position}>
                    <Popup>
                        calories, steps, time spent in this location...
                    </Popup>
                </Marker>
            </MapContainer>
        </div>
    );
};

export default MyComponent;

