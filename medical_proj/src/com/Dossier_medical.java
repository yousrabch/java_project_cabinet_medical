package com;

public class Dossier_medical {
	   
	    private int Num_dossier;
	    private FichePatient patient;
	    private String examens;
	    private String notes;
	    private String traitement;
	    private String compterendu; 
		 

	   

	    public Dossier_medical(int num_dossier, FichePatient patient, String examens, String notes,
				String traitement, String compterendu) {
			Num_dossier = num_dossier;
			this.patient = patient;
			
			this.examens = examens;
			this.notes = notes;
			this.traitement = traitement;
			this.compterendu = compterendu;
			
		}
	    
	    


		public Dossier_medical(int num_dossier) {
			
			Num_dossier = num_dossier;
		}




		public int getNum_dossier() {
			return Num_dossier;
		}

		public void setNum_dossier(int num_dossier) {
			Num_dossier = num_dossier;
		}

		public FichePatient getPatient() {
			return patient;
		}

		public void setPatient(FichePatient patient) {
			this.patient = patient;
		}

		

		public String getExamens() {
			return examens;
		}

		public void setExamens(String examens) {
			this.examens = examens;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}

		public String getTraitement() {
			return traitement;
		}

		public void setTraitement(String traitement) {
			this.traitement = traitement;
		}

		public String getCompterendu() {
			return compterendu;
		}

		public void setCompterendu(String compterendu) {
			this.compterendu = compterendu;
		}


		@Override
		public String toString() {
			return "Dossier_medical [Num_dossier=" + Num_dossier + ", patient=" + patient + ", examens=" + examens
					+ ", notes=" + notes + ", traitement=" + traitement + ", compterendu=" + compterendu + "]";
		}
		
		

}