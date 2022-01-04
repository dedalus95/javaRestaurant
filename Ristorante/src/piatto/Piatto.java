package piatto;

public class Piatto {

	private String nomePiatto;
	private double prezzo;
	
	public Piatto(String nomePiatto, double prezzo) {
		this.nomePiatto = nomePiatto;
		this.prezzo = prezzo;
	}

	public String getNomePiatto() {
		return nomePiatto;
	}

	public void setNomePiatto(String nomePiatto) {
		this.nomePiatto = nomePiatto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
