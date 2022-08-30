package com.example.demo.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Tarea")

public class ModeloTarea {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id_t;
	private String descripcion;
	private char estado;
	public ModeloTarea() {
		
	}
	
	public ModeloTarea(int id_t, String descripcion, char estado) {
		
		this.id_t = id_t;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getId_t() {
		return id_t;
	}

	public void setId_t(int id_t) {
		this.id_t = id_t;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ModeloTarea [id_t=" + id_t + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
	
	
	
}
