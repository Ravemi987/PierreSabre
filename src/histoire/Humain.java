package histoire;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
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
	
	public void gagnerArgent(int gain) {
		if (gain >= 0) {
			argent += gain;			
		}
	}
	
	public void perdreArgent(int perte) {
		if (perte >= 0) {
			argent -= perte;
		}
	}
}
