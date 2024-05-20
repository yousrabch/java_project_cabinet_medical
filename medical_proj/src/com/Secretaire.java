package com;

public class Secretaire extends User {
	
	
	//constructeur par default
	void secretaire(){}



	public Secretaire(String nom, String prenom, String phone, String email){
	   super(nom, prenom, phone, email);
	}

	   public void afficher() {

	       System.out.println("Nom : " + super.getNom());
	       System.out.println("Prénom : " + super.getPrenom());
	       System.out.println("Téléphone : " + super.getPhone());
	       System.out.println("Email: " + super.getEmail());
	       System.out.println("Email: " + super.getPassword());
	   }
	   
	   
}
