package histoire;

public class Commercant extends Humain{

	public Commercant(String nom, int argent) {
		super(nom, "the", argent);
	}
	
	public int seFaireExtorquer() {
		int argent = getArgent();
		perdreArgent(argent);
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return argent;
	}
	
	void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie genereux donateur!");
		gagnerArgent(argent);
	}
}
