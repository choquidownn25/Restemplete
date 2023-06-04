/**
 * 
 */
package com.afc.democertificados.models;

import java.util.ArrayList;

/**
 * @author Madre Hermosa
 *
 */
public class Datum {
	public String rut_employer;
    public String company_name;
    public String status;
    public String start_date;
    public String end_date;
    public String contract_type;
    public String total_contribution;
    public ArrayList<ByMonth> by_month;
	public String getRut_employer() {
		return rut_employer;
	}
	public void setRut_employer(String rut_employer) {
		this.rut_employer = rut_employer;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getContract_type() {
		return contract_type;
	}
	public void setContract_type(String contract_type) {
		this.contract_type = contract_type;
	}
	public String getTotal_contribution() {
		return total_contribution;
	}
	public void setTotal_contribution(String total_contribution) {
		this.total_contribution = total_contribution;
	}
	public ArrayList<ByMonth> getBy_month() {
		return by_month;
	}
	public void setBy_month(ArrayList<ByMonth> by_month) {
		this.by_month = by_month;
	}
    
    
}
