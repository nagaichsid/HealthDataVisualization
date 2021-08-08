import React from "react";
import { HashRouter as Router, Route } from "react-router-dom";
import EventStatistics from "./EventStatistics";
import MyComponent from "./MyComponent";
import NavBar from "./NavBar";
import TimeSeries from "./TimeSeries";

function App() {
  return (
    <div>
      <Router>
        <NavBar />
        <div>
          <Route exact path="/" component={MyComponent}/>
          <Route path="/statistics" component={EventStatistics} />
          <Route path="/timeseries" component={TimeSeries} /> 
        </div>
      </Router>
    </div>
  );
}

export default App;
