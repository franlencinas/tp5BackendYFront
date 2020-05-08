package com.utn.main.entidades;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Instrumentos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String instrumento;
	private String marca;
	private String modelo;
	private String imagen;
	private String precio;
	private String costoEnvio;
	private String cantidadVendida;
	private String descripcion;
	
	public Instrumentos () {
		
	}
	
	

	public Instrumentos(String instrumento, String marca, String modelo, String imagen, String precio,
			String costoEnvio, String cantidadVendida, String descripcion) {
		this.instrumento = instrumento;
		this.marca = marca;
		this.modelo = modelo;
		this.imagen = imagen;
		this.precio = precio;
		this.costoEnvio = costoEnvio;
		this.cantidadVendida = cantidadVendida;
		this.descripcion = descripcion;
	}



	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(String costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public String getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(String cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
