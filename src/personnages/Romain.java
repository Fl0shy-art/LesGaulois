package personnages;

public class Romain {
	private String nom;
	private int force;
	private String texte;

	public Romain(String nom, int force) {
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
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		
		forceCoup = CalculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		switch (force) {
		case 0:
			parler("Aïe");
			break;
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		return equipementEjecte;
	}
	/*public void recevoirCoup(int forceCoup) {
		this.force = this.force - forceCoup;
		if (force < 1) {
			this.parler("j'abandonne");
		} else {
			this.parler("Aie");
		}
	}*/
}
