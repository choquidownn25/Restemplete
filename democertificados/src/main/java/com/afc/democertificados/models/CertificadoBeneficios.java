/**
 * 
 */
package com.afc.democertificados.models;

import java.util.ArrayList;

/**
 * @author Madre Hermosa
 *
 */
public class CertificadoBeneficios {
	 	public String code;
	    public String caseid;
	    public String msg;
	    public ArrayList<Periodo> data;
	    public String pdf_boleta;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getCaseid() {
			return caseid;
		}
		public void setCaseid(String caseid) {
			this.caseid = caseid;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public ArrayList<Periodo> getData() {
			return data;
		}
		public void setData(ArrayList<Periodo> data) {
			this.data = data;
		}
		public String getPdf_boleta() {
			return pdf_boleta;
		}
		public void setPdf_boleta(String pdf_boleta) {
			this.pdf_boleta = pdf_boleta;
		}
	    
	    
}
