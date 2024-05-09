package med;


import java.util.Date;


public class Ordonnance {
	
	private String medicaments;
	private Date date; 
	private String Prescription;
	private FichePatient patient;
	private int ord_id;
	
	public Ordonnance(String medicaments,FichePatient patient, Date date, String prescription, int ord_id) {
		this.medicaments = medicaments;
		this.date = date;
		this.Prescription = prescription;
		this.ord_id = ord_id;
		this.patient = patient;
	}
	
	
	public Ordonnance() {
    }


    public String getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(String medicaments) {
		this.medicaments = medicaments;
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
	
	public int getOrd_id(){
		return ord_id;
	}

	public void setOrd_id(int ord_id){
     this.ord_id = ord_id;

	}

	public FichePatient getFichePatient()
	{
		return patient;
	}

	public void setFichePatient(FichePatient patient){
		this.patient = patient;
	}

}
