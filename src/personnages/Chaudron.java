package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public Chaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion == 0;
	}

	public int prendreLouche() {
		if (this.quantitePotion <= 0) {
			this.forcePotion = 0;
			return 0;
		} else {
			this.quantitePotion -= 1;
			return this.forcePotion;
		}
	}
}
