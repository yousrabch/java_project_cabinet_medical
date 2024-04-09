package med;

import java.time.LocalDateTime;

public class Consultation {
	private int id_consultation;
	private String motif;
	private LocalDateTime consultationDate;
	private Ordonnance ordonnance;
	private Patient patient;
	
    public Consultation(int id_consultation, String motif, LocalDateTime consultationDate, Patient patient) {
		super();
		this.id_consultation = id_consultation;
		this.motif = motif;
		this.consultationDate = consultationDate;
		this.patient = patient;
	}

	public Consultation(){}

	public int getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(int id_consultation) {
		this.id_consultation = id_consultation;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}


	public Ordonnance getOrd() {
		return ordonnance;
	}

	public void setOrd (Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	} 

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	 

}
