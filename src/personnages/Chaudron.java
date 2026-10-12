package personnages;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion == 0;
	}

	public int prendreLouche() {
		if (quantitePotion < 1) {
			forcePotion = 0;
			return 0;
		} else {
			quantitePotion--;
			return forcePotion;
		}
	}
}
