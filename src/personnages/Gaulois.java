package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " Envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(effetPotion * force / 3);
		if (force > 1 ) {
			effetPotion -= 1;
		}else {
			effetPotion = 1; //sécurité au cas ou la force est négative ou nul (Pas impossible car aucune précondition pour le moment)
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public static void main() {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.toString());
	}

	public int getEffetPotion() {
		return effetPotion;
	}
}
