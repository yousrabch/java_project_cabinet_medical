package med;
import java.time.LocalDateTime;

public class RDV {
	private int id_rdv;
	private LocalDateTime date;
	private String motif;
	private Patient patient;
	
	public RDV(int id_rdv, LocalDateTime date, String motif, Patient patient) {
        this.id_rdv = id_rdv;
        this.date = date;
        this.motif = motif;
        this.patient = patient;
    }

	public int getId_rdv() {
		return id_rdv;
	}

	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
