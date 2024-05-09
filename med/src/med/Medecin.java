package med;

public class Medecin extends User {

	private String  specialite;

	public Medecin(String nom, String prenom, String phone, String specialite, String email, String password) {
		super(nom, prenom, phone, email, password);
		this.specialite = specialite;
	}
	

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
}
