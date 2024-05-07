package med;

import java.util.Date;




public class Certificat {

	private int patient_id;
	private Date date;
	private String motif;
	private String cert;
	

	public Certificat(int patient_id, Date date, String motif, String cert) {
		this.patient_id = patient_id;
		this.date = date;
		this.motif = motif;
		this.cert = cert;
	}
	public Certificat(int patient_id2, int i, String motif2, String cert2) {
		// TODO Auto-generated constructor stub
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


public int getPatient_id() {
	return patient_id;
}


public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}
	
	
	
	
}
