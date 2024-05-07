package med;


public class secretaire extends User {
   
	
   
   //constructeur par default
   //secretaire(){}
  
   super(nom,prenom,phone,email);
   
   
   public void update () {
	  String nom = super.setNom();
	  String prenom = super.setPrenom();
	  String phone = super.setPhone();
	  String mail = super.setEmail();
       
   }
   
   public void afficher() {

       System.out.println("Nom : " + super.getNom());
       System.out.println("Prénom : " + super.getPrenom());
       System.out.println("Téléphone : " + super.getPhone());
       System.out.println("Email: " + super.getEmail());
   }
}
