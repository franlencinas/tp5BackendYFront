import React, { Component } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";

class Navigation extends Component {
  render() {
    return (
      <React.Fragment>
        <Navbar bg="primary" variant="dark">
          <Navbar.Brand href="/">Home</Navbar.Brand>
          <Nav className="mr-auto">
            <Nav.Link href="/productos">Productos</Nav.Link>
            <Nav.Link href="/direccion">Donde Estamos</Nav.Link>
            <Nav.Link href="/abm">ABM</Nav.Link>
          </Nav>
        </Navbar>
      </React.Fragment>
    );
  }
}

export default Navigation;
