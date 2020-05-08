import React, { Component } from "react";
import Card from "react-bootstrap/Card";

class Tarjeta extends Component {
  render() {
    if (this.props.costoEnvio === "G") {
      return (
        <React.Fragment>
          <Card className="tarjeta">
            <Card.Body className="body">
              <a href={`detalleProducto/${this.props.id}`}>
                <img
                  className="imagen"
                  src={require(`../assets/images/${this.props.imagen}`)}
                  alt="Imagen del Producto"
                  align="left"
                />
              </a>
              <Card.Title>{this.props.nombre}</Card.Title>
              <Card.Text>${this.props.precio}</Card.Text>
              <Card.Text className="envioG">
                <img src={require(`../assets/images/camion.png`)}></img>Envio
                Gratis a todo el pais
              </Card.Text>
              <Card.Text>{this.props.cantidadVendida} Vendidos</Card.Text>
            </Card.Body>
          </Card>
        </React.Fragment>
      );
    } else {
      return (
        <React.Fragment>
          <Card className="tarjeta">
            <Card.Body className="body">
              <a href={`detalleProducto/${this.props.id}`}>
                <img
                  className="imagen"
                  src={require(`../assets/images/${this.props.imagen}`)}
                  alt="Imagen del Producto"
                  align="left"
                />
              </a>
              <Card.Title>{this.props.nombre}</Card.Title>
              <Card.Text>${this.props.precio}</Card.Text>
              <Card.Text className="envio">
                Costo de Envio Interior de Argentina: ${this.props.costoEnvio}
              </Card.Text>
              <Card.Text>{this.props.cantidadVendida} Vendidos</Card.Text>
            </Card.Body>
          </Card>
        </React.Fragment>
      );
    }
  }
}
export default Tarjeta;
