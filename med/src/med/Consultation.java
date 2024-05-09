package med;

import java.sql.Date;

public class Consultation {
    private int id_consultation;
    private String motif;
    private Date consultationDate;
    private Ordonnance ordonnance;
    private Certificat certificat;
    private Patient patient;

    public Consultation(int id_consultation, String motif, Date consultationDate, Ordonnance ordonnance,
            Certificat certificat, Patient patient) {
        this.id_consultation = id_consultation;
        this.motif = motif;
        this.consultationDate = consultationDate;
        this.ordonnance = ordonnance;
        this.certificat = certificat;
        this.patient = patient;
    }


    public Consultation() {
        //TODO Auto-generated constructor stub
    }


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

    public Date getDateconsult() {
        return consultationDate;
    }

    public void setId_consultation(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Ordonnance getOrd() {
        return ordonnance;
    }

    public void setOrd (Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    } 

    public Certificat getCertificat() {
        return certificat;
    }

    public void setCertificat(Certificat certificat) {
        this.certificat = certificat;
    } 

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}