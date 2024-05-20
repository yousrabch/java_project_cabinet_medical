create table user(
NomUser varchar(20) not null,
PrenomUser varchar(20) not null,
PhonNum varchar(15) not null,
Email varchar(30),
password varchar(30),
constraint PK_user primary key ()
);


create table Medecin(
LastName varchar(20) not null,
FirstName varchar(20) not null,
phonNum varchar(10) not null,
email varchar(30) not null,
speciality varchar(30) not null,
constraint PK_doc primary key (LastName)
);

create table secretaire (
Lastname varchar(20) not null, 
firstname varchar(20) not null, 
phoneNum varchar(20) not null, 
email varchar(20) not null, 

constraint PK_sec primary key (Lastname) 
);


create table patient(
patient_id int not null,
Lastname varchar(20) not null,
firstname varchar(20) not null,
date_n date not null,
Gender varchar(1) not null,
phone varchar(15) not null,
Email varchar(30) not null,
Adress varchar(30) not null,
constraint PK_patient primary key (patient_id)
);

CREATE TABLE FichePatient (
    fiche_id INT not null,
    patient_id INT not null,
    groupesanguin VARCHAR(5) not null,
    poids INT not null,
    tailles INT not null,
    etatCivil VARCHAR(30) not null,
    maladies_chroniques TEXT,
    allergies TEXT,
    vaccinations TEXT,
    antecedents TEXT,
    constraint FK_FP_patient FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    constraint PK_FP primary key (fiche_id)
);



create table consultation(
consultationDate date not null,
fiche_id int not null,
motif TEXT not null,
Num_dossier INT  NOT NULL,
CONSTRAINT FK_consult_FP FOREIGN KEY (fiche_id) REFERENCES FichePatient(fiche_id),
CONSTRAINT FK_consult_doss FOREIGN KEY (Num_dossier) REFERENCES Dossier_medical(Num_dossier),
constraint PK_consult primary key (consultationDate, fiche_id)

);

create table rdv(
rdvDate date not null,
patient_id int not null,
motif TEXT not null,
CONSTRAINT FK_rdv_patient FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
constraint PK_rdv primary key (rdvDate, patient_id)
);

CREATE TABLE Certificat (
    cert_date DATE NOT NULL,
    fiche_id INT NOT NULL,
    motif TEXT not null,
    certi TEXT not null,
    CONSTRAINT FK_cert_consult FOREIGN KEY (cert_date, fiche_id) REFERENCES Consultation(consultationDate, fiche_id),
    PRIMARY KEY (Fiche_id, cert_date)
);

CREATE TABLE Dossier_medical (
    Num_dossier INT  NOT NULL,
    fiche_id INT NOT NULL,
    examens TEXT  NOT NULL,
    notes TEXT  NOT NULL,
    traitement TEXT  NOT NULL,
    compterendu TEXT  NOT NULL,
    constraint PK_dossier primary key (Num_dossier),
    CONSTRAINT FK_doss_FP FOREIGN KEY (fiche_id) REFERENCES FichePatient(fiche_id),
);

CREATE TABLE Ordonnance (

    ord_date DATE not null,
    fiche_id INT not null,
    medicaments TEXT not null,
    Prescription TEXT not null,
     constraint PK_ordo primary key (ord_date, fiche_id),
     CONSTRAINT FK_ord_consult FOREIGN KEY (ord_date, fiche_id) REFERENCES Consultation(consultationDate, fiche_id)
    
);



