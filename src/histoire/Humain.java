package histoire;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance = 0;
	protected Humain[] memoire;
	private static final int MAX_CONNAISSANCE = 30;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.memoire = new Humain[MAX_CONNAISSANCE];
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getArgent() {
		return this.argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ")" + " - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom +
				" et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		 parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " +
					bien + " a " + prix + " sous.");
			argent -= prix;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux meme pas "
					+ "m'offir " + bien + " a " + prix + " sous.");
		}
	}
	
	protected void gagnerArgent(int gain) {
		if (gain >= 0) {
			argent += gain;			
		}
	}
	
	protected void perdreArgent(int perte) {
		if (perte >= 0) {
			argent -= perte;
		}
	}
	
	void repondre(Humain autreHumain) {
		autreHumain.direBonjour();
	}
	
	void memoriser(Humain homme) {
		if (nbConnaissance < MAX_CONNAISSANCE) {
			memoire[nbConnaissance] = homme;
			nbConnaissance++;
		} else {
			System.out.println("Nombre de connaissances maximum atteint !");
		}
	}
	
	void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		repondre(autreHumain);
		autreHumain.memoriser(this);
		memoriser(autreHumain);
	}
	
	void listerConnaissance() {
		String listeNoms = "";
		for (int i = 0; i < nbConnaissance; i++) {
			listeNoms += memoire[i].getNom();
			if (i != nbConnaissance - 1) {
				listeNoms += ", ";
			}
		}
		parler("Je connais beaucoup de monde dont : " + listeNoms);
	}
}
