package com;

import java.util.Date;

public class Certificat {
	
	private Date date;
	private FichePatient patient;
	private String motif;
	private String cert;
	

	public Certificat(Date date, FichePatient patient,  String motif, String cert) {
		this.patient = patient;
		this.date = date;
		this.motif = motif;
		this.cert = cert;
	}

	public Certificat() {
    }

    public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
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
	
 public void AfficheCertificat() {
	 
	 System.out.println("Certificat:"+cert); 
 }


public FichePatient getPatient() {
	return patient;
}


public void setPatient(FichePatient patient) {
	this.patient = patient;
}

@Override
public String toString() {
	return "Certificat [date=" + date + ", patient_id=" + patient + ", motif=" + motif + ", cert=" + cert + "]";
}


	
	
}
