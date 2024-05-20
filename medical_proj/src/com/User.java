package com;

public class User {
	private String nom;
    private String prenom;
    private String phone;
    private String email;
	private String password;
    
	public User(String nom, String prenom, String phone, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	
	
	
	public User(String nom, String prenom, String phone, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		this.email = email;
	}



	public User(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		
	}
	public User() {}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telephone) {
		this.phone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword(){
		return password;
	}
	
   public void setPassword(String password){

	this.password = password;
   } 
}
