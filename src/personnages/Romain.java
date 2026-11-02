package personnages;

public class Romain {
	private String nom;
	private int force;
	private String texte;
	private Equipement[] equipements;
	private int nbEquipements = 0;

	private isInvarientVerfified(){
		return force > O;
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipements[2];
		assert force > 0;
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

	public void sEquiper(Equipement objet){
		switch(nbEquipements){
			case 2:
				System.out.println("Le soldat " + nom +" est déjà bien équipé !");
				break;
			case 1:
				if (equipement[0] == objet){
					system.out.println("Le soldat " + nom + " possède déjà un " + objet);
				}
			default:
				equipement[nbEquipements] = objet;
				nbEquipements++;
				system.out.prinln("Le soldat " + nom + " s'équipe d'un " + objet);
		}
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
		assert force > 0;
	}
	

private int CalculResistanceEquipement(int forceCoup) {
	texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
	int resistanceEquipement = 0;
	if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
			if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
				resistanceEquipement += 8;
			} else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
			}
			i++;
		}
		texte =+ resistanceEquipement + "!";
	}
	parler(texte);
	forceCoup -= resistanceEquipement;
	return forceCoup;
}
private Equipement[] ejecterEquipement() {
	Equipement[] equipementEjecte = new Equipement[nbEquipement];
	System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
	//TODO
	int nbEquipementEjecte = 0;
	for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] == null) {
		continue;
		} else {
		equipementEjecte[nbEquipementEjecte] = equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
	}
	assert force > 0;
	return equipementEjecte;
}
	/*public void recevoirCoup(int forceCoup) {
		this.force = this.force - forceCoup;
		if (force < 1) {
			this.parler("j'abandonne");
		} else {
			this.parler("Aie");
		}
		assert force > 0;
	}*/
}
