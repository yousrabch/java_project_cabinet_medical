package com;

import java.util.Date;

public class Consultation {

    private String motif;
    private Date consultationDate;
    private FichePatient patient;
    private Dossier_medical Numdossier;

    public Consultation( String motif, Date consultationDate,  FichePatient patient) {
        
        this.motif = motif;
        this.consultationDate = consultationDate;
        this.patient = patient;
    }
    
    


    public Consultation(Date consultationDate, FichePatient patient, String motif , Dossier_medical Numdossier) {
    	this.consultationDate = consultationDate;
    	 this.patient = patient;
    	 this.motif = motif;
    	 this.Numdossier = Numdossier;
    }
    
    
    public Consultation() {
    	
    }

    
    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateconsult() {
        return consultationDate;
    }

    public void setId_consultation(Date consultationDate) {
        this.consultationDate = consultationDate;
    }


    public FichePatient getPatient() {
        return patient;
    }

    public void setPatient(FichePatient patient) {
        this.patient = patient;
    }




	public Dossier_medical getNumdossier() {
		return Numdossier;
	}

	public void setNumdossier(Dossier_medical numdossier) {
		Numdossier = numdossier;
	}




	@Override
	public String toString() {
		return "Consultation [motif=" + motif + ", consultationDate=" + consultationDate + ", patient=" + patient
				+ ", Numdossier=" + Numdossier + "]";
	}

    

}
