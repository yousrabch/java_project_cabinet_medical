package med;

import java.sql.Date;


public class Patient extends User{
    
    private int id;
    private Date dateNaiss;
    private String adresse;
    private String gender;

    public Patient(int id, String nom, String prenom, Date dateNaiss, String gender, String adresse, String phone, String email, String password) {
    	super(nom,prenom,phone,email,password);
    	this.id = id;
        this.dateNaiss = dateNaiss;
        this.adresse=adresse;
        this.gender = gender;
    }

    public Patient(){}

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    public Date getDateNaiss() {
        return dateNaiss;
    }
    
    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
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
