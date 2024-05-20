package com;

public class FichePatient {
	
	    private int fiche_id;
	    private Patient patient;
	    private String groupesanguin;
	    private int poids;
	    private int tailles;
	    private String etatCivil;
	    private String maladies_chroniques;
	    private String allergies;
	    private String vaccinations;
	    private String antecedents;
	    
	    
		public FichePatient(int fiche_id, Patient patient, String groupesanguin, int poids, int tailles, String etatCivil,
				String maladies_chroniques, String allergies, String vaccinations, String antecedents) {
			this.fiche_id = fiche_id;
			this.patient = patient;
			this.groupesanguin = groupesanguin;
			this.poids = poids;
			this.tailles = tailles;
			this.etatCivil = etatCivil;
			this.maladies_chroniques = maladies_chroniques;
			this.allergies = allergies;
			this.vaccinations = vaccinations;
			this.antecedents = antecedents;
		}
		
		


		public FichePatient(int fiche_id, Patient patient, int poids, int tailles) {
			this.fiche_id = fiche_id;
			this.patient = patient;
			this.poids = poids;
			this.tailles = tailles;
		}
 
		
		
		public FichePatient(int fiche_id, Patient patient) {
			this.fiche_id = fiche_id;
			this.patient = patient;
		}	




		public Patient getPatient() {
			return patient;
		}


		public void setPatient(Patient patient) {
			this.patient = patient;
		}


		public String getGroupesanguin() {
			return groupesanguin;
		}


		public void setGroupesanguin(String groupesanguin) {
			this.groupesanguin = groupesanguin;
		}


		public int getPoids() {
			return poids;
		}


		public void setPoids(int poids) {
			this.poids = poids;
		}


		public int getTailles() {
			return tailles;
		}


		public void setTailles(int tailles) {
			this.tailles = tailles;
		}


		public String getEtatCivil() {
			return etatCivil;
		}


		public void setEtatCivil(String etatCivil) {
			this.etatCivil = etatCivil;
		}


		public String getMaladies_chroniques() {
			return maladies_chroniques;
		}


		public void setMaladies_chroniques(String maladies_chroniques) {
			this.maladies_chroniques = maladies_chroniques;
		}


		public String getAllergies() {
			return allergies;
		}


		public void setAllergies(String allergies) {
			this.allergies = allergies;
		}


		public String getVaccinations() {
			return vaccinations;
		}


		public void setVaccinations(String vaccinations) {
			this.vaccinations = vaccinations;
		}


		public String getAntecedents() {
			return antecedents;
		}


		public void setAntecedents(String antecedents) {
			this.antecedents = antecedents;
		}


		public int getFiche_id() {
			return fiche_id;
		}


		public void setFiche_id(int patient_id) {
			this.fiche_id = patient_id;
		}


		@Override
		public String toString() {
			return "FichePatient [Fiche_id=" + fiche_id + " ," + patient + ", groupesanguin="
					+ groupesanguin + ", poids=" + poids + ", tailles=" + tailles + ", etatCivil=" + etatCivil
					+ ", maladies_chroniques=" + maladies_chroniques + ", allergies=" + allergies + ", vaccinations="
					+ vaccinations + ", antecedents=" + antecedents + "]";
		}


		

	   


		
}
