import React from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import ajax from './ajax';
import { Grid, Form, FormGroup, FormControl, ControlLabel, Button, ButtonToolbar } from 'react-bootstrap';

var Width = document.documentElement.clientWidth;
export default class EventStatistics extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            calorie: [],
            step: [],
            distance: [],
            duration: [],
            activity: []
        }
    }

    async queryData(startDate, endDate) {
        const data = await ajax(`dailyEvents?startDate=${startDate}&endDate=${endDate}`);
        let calorie = [];
        let step = [];
        let distance = [];
        let duration = [];
        let activity = [];
        data.forEach(element => {
            calorie.push(element.calorie);
            step.push(element.step);
            distance.push(element.distance);
            duration.push(element.duration);
            activity.push(element.activity);
        });
        this.setState({ activity, calorie, step, distance, duration });
    }

    handleSubmit(e) {
        const form = document.forms.date;
        e.preventDefault();
        this.queryData(form.startDate.value, form.endDate.value);
    }

    generateData(name) {
        const colors = ['#B0C4DE', '#ADD8E6', '#B0E0E6', '#AFEEEE', '#B3EE3A', '#9ACD32', "#84bf96", "#45b97c", "#367459", "#abc88b"];
        const backgroundColor = colors.slice(0, this.state.activity.length);
        const data = {
            labels: this.state.activity,
            datasets: [
                {
                    label: `${name}`,
                    backgroundColor,
                    borderColor: '#458B00',
                    borderWidth: 1,
                    hoverBackgroundColor: '#E0FFFF',
                    hoverBorderColor: '#4682B4',
                    data: this.state[name],
                    fill: 'red'
                },
            ],
        };
        return data;
    }

    populateData() {
        const types = ["calorie", "step", "distance", "duration"];
        return types.map(type => this.generateData(type));
    }

    getCharts() {
        if (this.state.activity.length === 0) {
            return <div></div>;
        }
        const dataSet = this.populateData();
        const pieChart = dataSet.filter(data => data.datasets[0].label === 'calorie' || data.datasets[0].label === 'step').map(data => {
            return (
                <>
                    <div style={{textAlign:"center", font: "arial", color: '#4682B4'}}>{data.datasets[0].label}</div>
                    <Pie data={data} width={Width} height="1000" />
                </>
            );
        });

        const barChart = dataSet.filter(data => data.datasets[0].label === 'distance' || data.datasets[0].label === 'duration').map(data => {
            return <Bar data={data} width={Width} height="1000" />;
        });
        return (
            <div>
                <div style={{ height: '40%', width: '40%', display: "flex" }}>
                    {barChart}
                </div>
                <div style={{ height: '40%', width: '40%', display: "flex" }}>
                    {pieChart}
                </div>
            </div>
        );
    }

    render() {
        const charts = this.getCharts();
        return (
            <div style={{margin: "10px"}}>
                <Grid>
                    <Form name="date">
                        <FormGroup>
                            <ControlLabel>Enter the start date: </ControlLabel>
                            <FormControl name="startDate" autoFocus />
                        </FormGroup>
                        <FormGroup>
                            <ControlLabel>Enter the end date: </ControlLabel>
                            <FormControl name="endDate" />
                        </FormGroup>
                    </Form>
                    <ButtonToolbar style={{ marginTop: "10px" }}>
                        <Button type="button" bsStyle="primary" onClick={(e) => { this.handleSubmit(e) }}>Query!</Button>
                    </ButtonToolbar>
                </Grid>
                {charts}
            </div>

        );
    }
}