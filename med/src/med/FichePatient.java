package med;

import java.util.Date;


public class FichePatient {
    private int id;
    private String nom;
    private String prenom;
    private Date datenaiss;
    private String gender;
    private String adresse;
    private String email;
    private String phone;


    public FichePatient (int id, String nom, String prenom,Date datenaiss, String gender, String adresse , String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.gender = gender;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;

    }



    public FichePatient() {
    }



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



    public Date getDateNaiss() {
        return datenaiss;
    }
    public void setDateNaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public int getId() {
        return id;
    }
    public void setNump(int id) {
        this.id = id;
    }



    public String getAdressep() {
        return adresse;
    }
    public void setAdressep(String adresse) {
        this.adresse = adresse;
    }



    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
	


	



