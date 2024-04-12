import java.util.Date;

public class FichePatient extends Patient {
	private String nom;
	private String prenom;
	private Date date_n;
	private char sex;
	private String num;
	private String adresse;
	private String mail;
	private String tel;

	
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
	
	public Date getDate_n() {
		return date_n;
	}
	public void setDate_n(Date date_n) {
		this.date_n = date_n;
	}
	
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public long getNum() {
		return num;
	}
	public void setNump(long num) {
		this.num = num;
	}
	
	public String getAdressep() {
		return adresse;
	}
	public void setAdressep(String adresse) {
		this.adresse = adresse;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

	}

	


	



