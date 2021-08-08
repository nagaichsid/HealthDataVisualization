import React from 'react';
import { Line } from 'react-chartjs-2';
import ajax from './ajax';

var Width = document.documentElement.clientWidth;
export default class TimeSeries extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            date: [],
            calorie: [],
            step: [],
            distance: [],
            duration: []
        };
    }

    async componentDidMount() {
        const data = await ajax("/dailyEvents/walking");
        let date = [];
        let calorie = [];
        let step = [];
        let distance = [];
        let duration = [];
        data.reverse();
        data.forEach(d => {
            date.push(d.date);
            calorie.push(d.calorie);
            step.push(d.step);
            distance.push(d.distance);
            duration.push(d.duration);
        });
        this.setState({date, calorie, step, distance, duration});
    }

    render() {
        const {date, calorie, step, distance, duration} = this.state;
        if(this.state.date.length === 0) {
            return <div>Loading ...</div>;
        }
        const data = {
            labels: date,
            datasets: [
              {
                label: "calories",
                data: calorie,
                fill: false,
                backgroundColor: 'rgb(154, 205, 50)',
                borderColor: 'rgba(154, 205, 50, 0.6)',
              },
              {
                label: 'steps',
                data: step,
                fill: false,
                backgroundColor: 'rgb(99, 184, 255)',
                borderColor: 'rgba(99, 184, 255, 0.6)',
              },
              {
                label: 'distance',
                data: distance,
                fill: false,
                backgroundColor: 'rgb(255, 165, 0)',
                borderColor: 'rgba(255, 165, 0, 0.6)',
              },
              {
                label: 'duration',
                data: duration,
                fill: false,
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgba(255, 99, 132, 0.6)',
              },
            ],
          };
        return (
            <div>
                <h3 style={{textAlign: 'center', color: 'gray'}}>Most recent 100 activities</h3>
                <div style={{ height: '40%', width: {Width}}}>
                    <Line data={data}/>
                </div>
            </div>
        );
    }
}