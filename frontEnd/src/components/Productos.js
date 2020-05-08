import React, { Component } from "react";
import Navigation from "./Navigation";
import { instrumentos } from "../datos/instrumentos.json";
import Tarjeta from "./Tarjeta";
import Container from "react-bootstrap/Container";
import Col from "react-bootstrap/Col";

class Productos extends Component {
  constructor() {
    super();
    this.state = {
      instrumentos,
    };
  }
  render() {
    const instrumentos = this.state.instrumentos.map((instrumento, i) => {
      return (
        <Tarjeta
          id={instrumento.id}
          nombre={instrumento.instrumento}
          marca={instrumento.marca}
          modelo={instrumento.modelo}
          imagen={instrumento.imagen}
          precio={instrumento.precio}
          costoEnvio={instrumento.costoEnvio}
          cantidadVendida={instrumento.cantidadVendida}
          descripcion={instrumento.descripcion}
        ></Tarjeta>
      );
    });
    return (
      <React.Fragment>
        <Navigation></Navigation>
        <h2 className="titulo">Productos</h2>
        <Container fluid="md">
          <Col>{instrumentos}</Col>
        </Container>
      </React.Fragment>
    );
  }
}

export default Productos;
