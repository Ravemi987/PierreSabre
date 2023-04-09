package histoire;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, int argent) {
		super(nom, "shochu", argent);
	}

	public void gagnerHonneur(int gain) {
		if (gain >= 0) {
			this.honneur += gain;
		}
	}
	
	public void perdreHonneur(int perte) {
		if (perte >= 0) {
			this.honneur -= perte;
		}
	}
	
	public void donner(Commercant beneficiaire) {
		int argent = getArgent();
		double donation = 0.1 * getArgent();
		parler("Marco prends ces " + donation + " sous.");
		beneficiaire.recevoir((int)donation);
		perdreArgent((int)donation);
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre\n"
				+ "marchand!");
		int force = 2 * this.honneur;
		if (force >= adversaire.getReputation()) {
			gagnerArgent(adversaire.getArgent());
			gagnerHonneur(1);
			parler("Je t’ai eu petit yakusa!");
			adversaire.perdre();
		} else {
			perdreHonneur(1);
			int argent = getArgent();
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argent);
			perdreArgent(argent);
		}
	}
}
