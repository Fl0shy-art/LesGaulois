package personnages;

public class Druide {
	private String nom;
	private int force;
	Chaudron chaudron = new Chaudron(0, 0);

	public Druide(String nom, int force) {
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
		return "Le druide " + nom + " : ";
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté" + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");

	}

	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if (gaulois.getNom() != null && gaulois.getNom().equals("Obélix")) {
				parler("Non, Obélix Non ! Et tu le sais très bien");
			}
			int forcePotion = chaudron.prendreLouche();
			gaulois.boirePotion(forcePotion);
			parler("Tiens" + gaulois.getNom() + " un peu de potion magique.");

		} else {
			parler("Désoler " + gaulois.getNom() + " il n'y a plus de potion magique");
		}
	}

}
