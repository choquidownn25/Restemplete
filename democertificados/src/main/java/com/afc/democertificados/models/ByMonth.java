/**
 * 
 */
package com.afc.democertificados.models;

/**
 * @author Madre Hermosa
 *
 */
public class ByMonth {
	 	public String period;
	    public String taxable_amount;
	    public String quoted;
	    public String payment_date;
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		public String getTaxable_amount() {
			return taxable_amount;
		}
		public void setTaxable_amount(String taxable_amount) {
			this.taxable_amount = taxable_amount;
		}
		public String getQuoted() {
			return quoted;
		}
		public void setQuoted(String quoted) {
			this.quoted = quoted;
		}
		public String getPayment_date() {
			return payment_date;
		}
		public void setPayment_date(String payment_date) {
			this.payment_date = payment_date;
		}
	    
	    
}
