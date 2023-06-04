/**
 * 
 */
package com.afc.democertificados.models;

import java.util.ArrayList;

/**
 * @author Madre Hermosa
 *
 */
public class DetalleAportantes {

	 private String code;
	 private String msg;
	 private String caseid;
	 public ArrayList<Datum> data;


	 // Getter Methods 
	 

	 public ArrayList<Datum> getData() {
		return data;
	}

	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

	public String getCode() {
	  return code;
	 }

	 public String getMsg() {
	  return msg;
	 }

	 public String getCaseid() {
	  return caseid;
	 }

	 // Setter Methods 

	 public void setCode(String code) {
	  this.code = code;
	 }

	 public void setMsg(String msg) {
	  this.msg = msg;
	 }

	 public void setCaseid(String caseid) {
	  this.caseid = caseid;
	 }

}
