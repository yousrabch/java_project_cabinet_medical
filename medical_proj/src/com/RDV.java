package com;

import java.util.Date;

public class RDV {

	private Date date;
	private String motif;
	private Patient patient;
	
	public RDV( Date date, Patient patient, String motif ) {
       
        this.date = date;
        this.motif = motif;
        this.patient = patient;
    }


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "RDV [date=" + date + ", motif=" + motif + ", patient=" + patient + "]";
	}
	
	
}
