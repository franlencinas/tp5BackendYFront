import React, { Component } from "react";
import GoogleMapReact from "google-map-react";
import Navigation from "./Navigation";

const AnyReactComponent = ({ text }) => (
  <div className="marker">
    <div className="texto">{text}</div>
    <br />
    <img
      className="marcador"
      src="https://img2.freepng.es/20180404/clw/kisspng-computer-icons-google-map-maker-marker-pen-cartodb-map-marker-5ac4f16f538be1.8585288315228563033422.jpg"
      alt="Marcador"
    />
  </div>
);

class Direccion extends Component {
  static defaultProps = {
    center: {
      lat: -32.8863308,
      lng: -68.8383064,
    },
    zoom: 18,
  };
  render() {
    return (
      <React.Fragment>
        <Navigation></Navigation>
        <section className="container">
          <h3>Donde Estamos</h3>
          <div className="mapa">
            <GoogleMapReact
              bootstrapURLKeys={{
                key: "AIzaSyABiI9Iv4h4xuO6p8EqZXSaZaPbZhTY5rY",
              }}
              defaultCenter={{ lat: -32.886182, lng: -68.838399 }}
              defaultZoom={18}
            >
              <AnyReactComponent
                lat={-32.88582}
                lng={-68.83859}
                text="Musical Hendrix"
              />
            </GoogleMapReact>
          </div>
        </section>
      </React.Fragment>
    );
  }
}

export default Direccion;
