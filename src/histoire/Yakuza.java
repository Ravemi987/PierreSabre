package histoire;

public class Yakuza extends Humain {
	private int reputation = 0;
	private String clan;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, "whisky", argent);
		this.clan = clan;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}
	
	public void gagnerReputation(int points) {
		if (points >= 0) {
			this.reputation += points;
		}
	}
	
	public void perdreReputation(int points) {
		if (points >= 0) {
			this.reputation -= points;
		}
	}
	
	public int getReputation() {
		return this.reputation;
	}
	
	void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchant qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens a la vie donne moi ta bourse !");
		int sous = victime.seFaireExtorquer();
		gagnerArgent(sous);
		gagnerReputation(1);
		parler("J'ai pique les " + sous + " sous de " + victime.getNom() +
				", ce qui me fait " + getArgent() + " dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int argent = getArgent();
		perdreArgent(argent);
		perdreReputation(1);
		parler("J'ai perdu mon duel et mes " + argent + " sous, snif..."
				+ " J'ai deshonore le clan de " + clan + ".");
		return argent;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		gagnerReputation(1);
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ?" +
		"\n Je l'ai depouille de ses " + gain + " sous.");
	}	
}
