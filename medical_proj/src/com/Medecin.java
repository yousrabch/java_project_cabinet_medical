package com;

public class Medecin extends User {
	private String  specialite;

	public Medecin(String nom, String prenom, String phone,String email, String specialite) {
		super(nom, prenom, phone, email);
		this.specialite = specialite;
	}
	

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	@Override
	public String toString() {
		return "Medecin [specialite=" + specialite + "]";
	}
	
	
}
