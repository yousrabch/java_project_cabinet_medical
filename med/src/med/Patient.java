package med;

import java.time.LocalDateTime;

public class Patient extends User{
    private int id;
    private LocalDateTime dateNaiss;
    private String adresse;
    private char gender;
    

    public Patient(int id, String nom, String prenom, LocalDateTime dateNaiss, char gender, String adresse, String phone, String email) {
    	super(nom,prenom,phone,email);
    	this.id = id;
        this.dateNaiss = dateNaiss;
        this.adresse=adresse;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    public LocalDateTime getDateNaiss() {
        return dateNaiss;
    }
    
    public void setDateNaiss(LocalDateTime dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

    public void afficher() {

        System.out.println("Nom : " + super.getNom());
        System.out.println("Prénom : " + super.getPrenom());
        System.out.println("Téléphone : " + super.getPhone());
        System.out.println("Email: " + super.getEmail());
    }

	
    
}
