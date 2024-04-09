package med;

import java.util.ArrayList;
import java.util.List;

public class Dossier_medical {

	
	    private int Num_dossier;
	    private patient patient;
	    private List<String> antecedents;
	    private List<String> examens;
	    private List<String> notes;
	    private List<String> traitement;


	    // Constructeur
	    public void DossierMedicale(int Num_dossier, patient patient) {
	       
	        this.antecedents = new ArrayList<>();
	        this.examens = new ArrayList<>();
	        this.notes = new ArrayList<>();
	        this.traitement = new ArrayList<>();
	    }

	    // Méthodes pour ajouter des informations au dossier médical
	    public void ajouterAntecedent(String antecedent) {
	        this.antecedents.add(antecedent);
	    }
	    
	    public void ajouterTraitement(String traitement) {
	        this.traitement.add(traitement);
	    }

	    public void ajouterExamen(String examen) {
	        this.examens.add(examen);
	    }

	    public void ajouterNote(String note) {
	        this.notes.add(note);
	    }
	    
	    // getters and setters
	    public int getNum_dossier() {
			return Num_dossier;
		}
		public void setNum_dossier(int num_dossier) {
			Num_dossier = num_dossier;
		}
		
		public patient getPatient() {
			return patient;
		}
		public void setPatient(patient patient) {
			this.patient = patient;
		}

		public List<String> getAntecedents() {
			return antecedents;
		}
		public void setAntecedents(List<String> antecedents) {
			this.antecedents = antecedents;
		}

		public List<String> getExamens() {
			return examens;
		}
		public void setExamens(List<String> examens) {
			this.examens = examens;
		}

		public List<String> getNotes() {
			return notes;
		}
		public void setNotes(List<String> notes) {
			this.notes = notes;
		}

		public List<String> getTraitement() {
			return traitement;
		}
		public void setTraitement(List<String> traitement) {
			this.traitement = traitement;
		}


	}
	
	

