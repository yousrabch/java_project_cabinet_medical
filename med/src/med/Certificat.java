package med;

import java.util.Date;

public class Certificat {

	private Patient patient;
	private Medecin medecin_name;
	private Medecin medecin_pre;
	private Medecin medecin_num;
	private Date date;
	private String motif;
	private int nbr_jour;
	
	
	public Certificat(med.patient patient, med.Medecin medecin_name, med.Medecin medecin_pre, med.Medecin medecin_num, Date date, String motif, int nbr_jour) {
		this.patient = patient;
		this.medecin_name.getNom();
		this.medecin_pre.getPrenom();
		this.medecin_num.getNum();
		this.date = date;
		this.motif = motif;
		this.nbr_jour = nbr_jour;
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


	public int getNbr_jour() {
		return nbr_jour;
	}
	public void setNbr_jour(int nbr_jour) {
		this.nbr_jour = nbr_jour;
	}
	
 public void AfficheCertificat() {
	 
	 System.out.println("Je soussigne,"+medecin_name+medecin_pre+"docteur en medecine, certifie avoir\n"
	 		+ " examine le"+ date+"Monsieur(ou Madame)"+ patient+".\n Je declare que son etat de sante necessite un arret de travail de"
	 		+ nbr_jour +"; A compter du :"+ date+
	 		"\n Certificat etabli a la demande de l'interesse et rmis en main propre pour servir et faire valoir ce que de droit."); 
 }
	
	
	
	
}
