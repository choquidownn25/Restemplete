package com.afc.democertificados.models;

import java.util.List;

public class Empresa {
	 private String codigo;
	    private String estatus;
	    private List<InfoEmpresa> infoEmpresas;
	    private String comentario;
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getEstatus() {
			return estatus;
		}
		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}
		public List<InfoEmpresa> getInfoEmpresas() {
			return infoEmpresas;
		}
		public void setInfoEmpresas(List<InfoEmpresa> infoEmpresas) {
			this.infoEmpresas = infoEmpresas;
		}
		public String getComentario() {
			return comentario;
		}
		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

	    // Agrega los getters y setters para los campos
	    
	    
}
