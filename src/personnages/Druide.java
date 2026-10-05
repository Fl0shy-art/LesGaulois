package personnages;

public class Druide {
	private String nom;
	private int force;
	Chaudron chaudron = new Chaudron(0, 0);

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite,forcePotion);
		parler("J'ai concocté" + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
		
	}

	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion() == true) {
			
		}
	}

}
