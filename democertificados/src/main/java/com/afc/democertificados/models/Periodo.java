/**
 * 
 */
package com.afc.democertificados.models;

/**
 * @author Madre Hermosa
 *
 */
public class Periodo {

	 public String fecha_sol;
	    public String n_sol;
	    public String nombre_emp;
	    public String tipo_sol;
	    public String fecha_finiquito;
	    public String fecha_ult_giro;
	    public String giros_pagados;
	    //@JsonProperty("CIC") 
	    public String cIC;
	    //@JsonProperty("FCS") 
	    public String fCS;
	    public String totales_pagados;
		public String getFecha_sol() {
			return fecha_sol;
		}
		public void setFecha_sol(String fecha_sol) {
			this.fecha_sol = fecha_sol;
		}
		public String getN_sol() {
			return n_sol;
		}
		public void setN_sol(String n_sol) {
			this.n_sol = n_sol;
		}
		public String getNombre_emp() {
			return nombre_emp;
		}
		public void setNombre_emp(String nombre_emp) {
			this.nombre_emp = nombre_emp;
		}
		public String getTipo_sol() {
			return tipo_sol;
		}
		public void setTipo_sol(String tipo_sol) {
			this.tipo_sol = tipo_sol;
		}
		public String getFecha_finiquito() {
			return fecha_finiquito;
		}
		public void setFecha_finiquito(String fecha_finiquito) {
			this.fecha_finiquito = fecha_finiquito;
		}
		public String getFecha_ult_giro() {
			return fecha_ult_giro;
		}
		public void setFecha_ult_giro(String fecha_ult_giro) {
			this.fecha_ult_giro = fecha_ult_giro;
		}
		public String getGiros_pagados() {
			return giros_pagados;
		}
		public void setGiros_pagados(String giros_pagados) {
			this.giros_pagados = giros_pagados;
		}
		public String getcIC() {
			return cIC;
		}
		public void setcIC(String cIC) {
			this.cIC = cIC;
		}
		public String getfCS() {
			return fCS;
		}
		public void setfCS(String fCS) {
			this.fCS = fCS;
		}
		public String getTotales_pagados() {
			return totales_pagados;
		}
		public void setTotales_pagados(String totales_pagados) {
			this.totales_pagados = totales_pagados;
		}
	    
	    
}
