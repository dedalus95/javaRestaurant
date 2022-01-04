package cliente;
import java.util.Date;
import java.util.Vector;
import piatto.Piatto;

public class Cliente {
	private Vector<Piatto> listaOrdinazioni;
	private String nome;
	private Date registrazioneCliente;
	private int id = 0;
	
	public Cliente (String nome) {
		this.nome = nome;
		this.listaOrdinazioni = new Vector<Piatto>();
		this.id = generateId();
	}


	public Vector<Piatto> getListaOrdinazioni() {
		return listaOrdinazioni;
	}

	public void setListaOrdinazioni(Vector<Piatto> listaOrdinazioni) {
		this.listaOrdinazioni = listaOrdinazioni;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public void aggiungiOrdinazione (Piatto ordinazione) {
		listaOrdinazioni.add(ordinazione);
	}


	public Date getRegistrazioneCliente() {
		return registrazioneCliente;
	}


	public void setRegistrazioneCliente(Date registrazioneCliente) {
		this.registrazioneCliente = registrazioneCliente;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	public Piatto ricercaPiatto(String name) {
		for (int i = 0; i < listaOrdinazioni.size(); i++) {
			if(listaOrdinazioni.get(i).getNomePiatto().equals(name)) {
				return listaOrdinazioni.get(i);
			}
		}
		return null;
	}
	
	
	public void rimuoviPiatto(int i) {
		if (i != -1) {
			listaOrdinazioni.remove(i);
		}
	}
	
	
	
	
	public double getFattura() {
		double totale = 0;
		for(int i = 0; i < this.getListaOrdinazioni().size(); i++) {
			totale += getListaOrdinazioni().get(i).getPrezzo();
		}
		return totale;
	}
	
	public int generateId() {
	int id = (int) Math.ceil(Math.random() * 1_00_000);
	return id;
	}

}
