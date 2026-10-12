package village_gaulois;

import personnages.Gaulois;

public class Village {
	private int NB_VILLAGEOIS_MAX;
	private String nom;
	private int nbVillageois;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMax, Gaulois chef) {
		this.nom = nom;
		this.chef = chef;
		this.chef.setVillage(this);
		this.nbVillageois = 0;
		this.villageois = new Gaulois[nbVillageoisMax];
		this.NB_VILLAGEOIS_MAX = nbVillageoisMax;
	}

	public String getNom() {
		return nom;
	}

	public int getNbVillageois() {
		return nbVillageois;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (gaulois != null && nbVillageois + 1 < NB_VILLAGEOIS_MAX) {
			gaulois.setVillage(this);
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > 0 && numVillageois <= nbVillageois) {
			return villageois[numVillageois - 1];
		}
		System.out.println("Il n'y a pas autant d'habitants dans notre village !");
		return null;
	}

	public void afficherVillage() {
		System.out.println(
				"Dans le village " + getNom() + " du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 30, abraracourcix);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillage();
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
		village.afficherVillage();
	}
}
