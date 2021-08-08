import React from 'react';
import { Navbar, Nav, NavItem } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

export default function NavBar(props) {

    return(
        <Navbar>
            <Navbar.Header>
                <Navbar.Brand>Fitness App</Navbar.Brand>
            </Navbar.Header>
            <Nav>
                <LinkContainer to="/">
                    <NavItem>Home</NavItem>
                </LinkContainer>
                <LinkContainer to="/timeseries">
                    <NavItem>Time Series</NavItem>
                </LinkContainer>
                <LinkContainer to="/statistics">
                    <NavItem>Statistics</NavItem>
                </LinkContainer>
            </Nav>
        </Navbar>
    );
}