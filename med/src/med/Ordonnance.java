package med;


import java.util.Date;
import java.util.List;

public class Ordonnance {
	
	private List<String> médicaments;
	private Date date; 
	private String Prescription;
	// private Patient patient;
	
	public Ordonnance(List<String> médicaments, Date date, String prescription) {
		this.médicaments = médicaments;
		this.date = date;
		Prescription = prescription;
	}
	
	
	public List<String> getMédicaments() {
		return médicaments;
	}
	public void setMédicaments(List<String> médicaments) {
		this.médicaments = médicaments;
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
	
	

}
