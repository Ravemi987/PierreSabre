package histoire;

import java.util.Random;

public class GrandMere extends Humain {
	protected Humain[] memoire;
	protected int nbConnaissance = 0;
	private static final int MAX_CONNAISSANCE = 5;
	private TypeHumain[] types = TypeHumain.values();
	
	
	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
		memoire = new Humain[MAX_CONNAISSANCE];
	}
	
	@Override
	protected void memoriser(Humain homme) {
		if (nbConnaissance < MAX_CONNAISSANCE) {
			memoire[nbConnaissance] = homme;
			nbConnaissance++;
		} else {
			super.parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	private enum TypeHumain {
		COMMERCANT("commercant"), SAMOURAI("samourai"), TRAITRE("traitre"), RONIN("ronin"), YAKUZA("yakuza"), HUMAIN("habitant"), GRANDMERE("grand-mere");
		
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom = nom;
		}
			
		@Override
		public String toString() {
			return nom;
		}
	}
	
	private String humainHasard() {
		Random r = new Random();
		int n = r.nextInt(types.length);
		return types[n].toString();
	}
	
	public void ragoter() {
		for(int i = 0; i < nbConnaissance; i++) {
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que " + memoire[i].getNom() + " est un " + TypeHumain.TRAITRE + ". Petit chenapan! ");
			} else {
				parler("Je crois que " + memoire[i].getNom() + " est un " + humainHasard() + ".");
			}
		}
	}
}
