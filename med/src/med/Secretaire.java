package med;


public class Secretaire extends User {

//constructeur par default
void secretaire(){}



public Secretaire(String nom, String prenom, String phone, String email, String password){
   super(nom, prenom, phone, email, password);
}

   public void afficher() {

       System.out.println("Nom : " + super.getNom());
       System.out.println("Prénom : " + super.getPrenom());
       System.out.println("Téléphone : " + super.getPhone());
       System.out.println("Email: " + super.getEmail());
       System.out.println("Email: " + super.getPassword());
   }
}