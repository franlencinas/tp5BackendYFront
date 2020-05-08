import React, { Component } from "react";
import Navigation from "./Navigation";
import { instrumentos } from "../datos/instrumentos.json";

class ABM extends Component {
  constructor() {
    super();
    this.state = {
      instrumentos,
    };
  }
  render() {
    const instrumentos = this.state.instrumentos.map((instrumento, i) => {
      return (
        <tr key={instrumento.id}>
          <td>{instrumento.id}</td>
          <td>
            <img
              className="imagenABM"
              src={require(`../assets/images/${instrumento.imagen}`)}
            />
          </td>
          <td>{instrumento.instrumento}</td>
          <td>{instrumento.marca}</td>
          <td>{instrumento.modelo}</td>
          <td>{instrumento.descripcion.substring(0, 30).concat("...")}</td>
          <td>{instrumento.cantidadVendida}</td>
          <td>{instrumento.precio}</td>
          <td>{instrumento.costoEnvio}</td>
          <td>
            <button type="button" className="btn btn-warning">
              Editar
            </button>
            <button type="button" className="btn btn-danger">
              Eliminar
            </button>
          </td>
        </tr>
      );
    });
    return (
      <React.Fragment>
        <Navigation></Navigation>
        <div className="abmTabla">
          <h1>ABM Instrumento</h1>
          <div className="tabla">
            <button className="btn btn-primary btn-block" type="button">
              Agregar un Instrumento
            </button>
            <table className="table">
              <thead className="thead-dark">
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Imagen</th>
                  <th scope="col">Instrumento</th>
                  <th scope="col">Marca</th>
                  <th scope="col">Modelo</th>
                  <th scope="col">Descripcion</th>
                  <th scope="col">Cantidad Vendida</th>
                  <th scope="col">Precio</th>
                  <th scope="col">Costo de Envio</th>
                  <th scope="col">Acciones</th>
                </tr>
              </thead>
              <tbody>{instrumentos}</tbody>
            </table>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default ABM;
