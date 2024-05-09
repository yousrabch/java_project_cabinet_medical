package med;
import java.sql.Date;


public class RDV {
	private int id_rdv;
	private Date date;
	private String motif;
	private Patient patient;
	
	public RDV(int id_rdv, Date date, String motif, Patient patient) {
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
