package com;

import java.util.Date;

public class Ordonnance {
	
	private Date date;
	private FichePatient patient;
	private String medicaments;
	private String Prescription;
	

	
	public Ordonnance(Date date, FichePatient patient, String medicaments,  String prescription) {
		this.medicaments = medicaments;
		this.date = date;
		this.Prescription = prescription;
		this.patient = patient;
	}
	
	
	public Ordonnance() {
    }


    public String getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(String medicaments) {
		this.medicaments = medicaments;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPrescription() {
		return Prescription;
	}
	public void setPrescription(String prescription) {
		Prescription = prescription;
	}
	

	public FichePatient getFichePatient()
	{
		return patient;
	}

	public void setFichePatient(FichePatient patient){
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "Ordonnance [date=" + date + ", patient_id=" + patient + ", medicaments=" + medicaments
				+ ", Prescription=" + Prescription + "]";
	}
	
	
}
