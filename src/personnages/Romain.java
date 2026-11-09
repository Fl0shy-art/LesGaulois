package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private String texte;
	private Equipement[] equipements;
	private int nbEquipements = 0;

	private boolean isInvarientVerfified(){
		return force >= 0;
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		assert force > 0;
		assert isInvarientVerfified();
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void sEquiper(Equipement objet){
		switch(nbEquipements){
			case 2:
				System.out.println("Le soldat " + nom +" est déjà bien équipé !");
				break;
			case 1:
				if (equipements[0] == objet){
					System.out.println("Le soldat " + nom + " possède déjà un " + objet);
					break;
				}
			default:
				equipements[nbEquipements] = objet;
				nbEquipements++;
				System.out.println("Le soldat " + nom + " s'équipe d'un " + objet);
		}
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		forceCoup = CalculResistanceEquipement(forceCoup);
		if (forceCoup > 0) {
			force = Math.max(0, force - forceCoup);
		}
		Equipement[] equipementEjecte = new Equipement[0];
		if (force == 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		} else {
			parler("Aïe");
		}
		assert isInvarientVerfified();
		return equipementEjecte;
	}
	

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipements == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipements;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] == null) {
			continue;
			} else {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
			}
		}
		assert isInvarientVerfified();
		return equipementEjecte;
	}
	/*public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0; // préconditions
		int force_avant_coup = this.force;
		this.force = this.force - forceCoup;
		if (force < 1) {
			this.parler("j'abandonne");
		} else {
			this.parler("Aie");
		}
		assert force_avant_coup > this.force;
	}*/
	public static void main(){
		Romain minus = new Romain("Minus",6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
}

}
