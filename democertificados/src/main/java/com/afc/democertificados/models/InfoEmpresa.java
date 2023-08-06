package com.afc.democertificados.models;

public class InfoEmpresa {
	private int id;
    private String dni;
    private String razonSocial;
    private String fechaCreacion;
    private String estado;
    private Object usuarios; // Puedes cambiar el tipo a la clase correspondiente si está definida
    private Object sistemas; // Puedes cambiar el tipo a la clase correspondiente si está definida
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Object getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Object usuarios) {
		this.usuarios = usuarios;
	}
	public Object getSistemas() {
		return sistemas;
	}
	public void setSistemas(Object sistemas) {
		this.sistemas = sistemas;
	}
	
    // Agrega los getters y setters para los campos
    
    
}
