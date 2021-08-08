import React from "react";
import { MapContainer, TileLayer, Marker, Popup, Circle } from "react-leaflet";
import 'leaflet/dist/leaflet.css';
import 'leaflet-defaulticon-compatibility/dist/leaflet-defaulticon-compatibility.webpack.css'; // Re-uses images from ~leaflet package
import 'leaflet-defaulticon-compatibility';
import ajax from "./ajax";
import { Grid, Form, FormGroup, FormControl, ControlLabel, Button, ButtonToolbar } from 'react-bootstrap';

class MyComponent extends React.Component {

    static async fetchData(date) {
        const data = await ajax(`/activities/${date}`);
        return data;
    }

    constructor(props) {
        super(props);
        this.state = {
            activities: [],
            date: "20130209"
        }
    }
    
    async componentDidUpdate(_, prevState) {
        if(prevState.date !== this.state.date){
            const data = await MyComponent.fetchData(this.state.date);
            this.setState({activities: data});
        }
    }

    async componentDidMount() {
        const data = await MyComponent.fetchData(this.state.date);
        this.setState({activities: data});
    }

    handleSubmit(e) {
        const form = document.forms.date;
        e.preventDefault();
        this.setState({date: form.date.value});
    }

    render(){
        let center = [47, -122];
        if(this.state.activities.length) {
            const {longitude, latitude} = this.state.activities[0].placeLog;
            center = [latitude, longitude];
        }
        const popUps = this.state.activities.map(activity => { 
            const {id, placeLog, walkingActivity} = activity;
            const {longitude, latitude, placeName, timeSpent} = placeLog;
            const {distance, calorie, step} = walkingActivity;
            const position = [latitude, longitude];
            return (<Marker key={id} position={position}>
                <Popup>
                    {`Place Name: ${placeName}, Distance: ${distance}, Calorie: ${calorie}, Step: ${step}, Time Spent: ${timeSpent/60} mins`}
                </Popup>
                <Circle 
                  center={{lat:latitude, lng: longitude}}
                  fillColor="blue" 
                  radius={timeSpent/10}/>
            </Marker>);
        });
        return (
            <div>
                <Grid>
                    <Form name="date">
                        <FormGroup>
                            <ControlLabel>Track your activities for a given date: </ControlLabel>
                            <FormControl name="date" autoFocus />
                        </FormGroup>
                    </Form>
                    <ButtonToolbar style={{marginTop: "10px"}}>
                        <Button type="button" bsStyle="primary" onClick={(e)=>{this.handleSubmit(e)}}>Query!</Button>
                    </ButtonToolbar>
                </Grid>

                
                <div className="map__container" style={{marginTop: "10px"}}>
                    <MapContainer
                        center={center}
                        zoom={8}
                        style={{ height: '80vh', width: '80wh' }}
                    >
                        <TileLayer
                            attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                        />
                        {popUps}
                    </MapContainer>
                </div>
            </div>

        );
    }
};

export default MyComponent;

