import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import cliente.Cliente;
import piatto.Piatto;

public class gestioneRistorante {
	
	private Vector<Cliente> listaClienti;
	private Vector<Piatto> menu;
	
	public gestioneRistorante() {
		this.listaClienti = new Vector<Cliente>();
		this.setMenu(new Vector<Piatto>());
	}


	public Vector<Cliente> getListaClienti() {
		return listaClienti;
	}


	public void setListaClienti(Vector<Cliente> listaClienti) {
		this.listaClienti = listaClienti;
	}

	
	private void aggiungiCliente(Cliente cliente) {
		cliente.setRegistrazioneCliente(new Date());
		listaClienti.add(cliente);
	}
	
	private Cliente ricercaCliente(int id) {
		for (int i = 0; i < listaClienti.size(); i++) {
			if(listaClienti.get(i).getId() == id) {
				return listaClienti.get(i);
			}
		}
		return null;
	}
	
	private void rimuoviCliente(Cliente cliente) {
		if(cliente != null) {
				listaClienti.remove(cliente);
		}
			
		}
		
	
	private Piatto ricercaMenu(String name) {
		for (int i = 0; i < menu.size(); i++) {
			if(menu.get(i).getNomePiatto().equals(name)) {
				return menu.get(i);
			}
		}
		return null;
	}
	
	
	
	private int calcoloNumeroOrdinazioni() {
		int totale = 0;
		for(int i = 0; i < this.getListaClienti().size(); i++) {
			totale += getListaClienti().get(i).getListaOrdinazioni().size();
		}
		return totale;
	}
	
	
	
	
	private double getIncassoTotale() {
		double totale = 0;
		for(int i = 0; i < this.getListaClienti().size(); i++) {
			totale += getListaClienti().get(i).getFattura();
		}
		return totale;
	}
	
	private int numeroClientiDiOggi() {
		return listaClienti.size();
	}
	
	
	public Vector<Piatto> getMenu() {
		return menu;
	}


	public void setMenu(Vector<Piatto> menu) {
		this.menu = menu;
	}

	
	public int detectInputMismatch(int id, Scanner scanner) {
		do {
		    try {
		        id = scanner.nextInt();
		    } catch (InputMismatchException e){
		        System.err.println("Customer IDs are numbers only. Try again.");
		        scanner.next();
		    }
		} while (id<1);
		return id;
	}

	public static void main(String[] args) {
		
		
		Scanner tastiera = new Scanner(System.in);
		int key;
		gestioneRistorante nuovoRistorante = new gestioneRistorante();

		
		Piatto carbonara = new Piatto("CARBONARA", 10);
		Piatto amatriciana = new Piatto("AMATRICIANA", 10);
		Piatto cacioEPepe = new Piatto("CACIOEPEPE", 9);
		Piatto pizzaMargherita = new Piatto("PIZZAMARGHERITA", 6.50);
		Piatto pizzaCapricciosa = new Piatto("PIZZACAPRICCIOSA", 8);
		Piatto supplì = new Piatto("SUPPLI", 1.50);
		Piatto cocaCola = new Piatto("COCACOLA", 3);
		Piatto fanta = new Piatto("FANTA", 3);
		Piatto sprite = new Piatto("SPRITE", 3);
		
		
		nuovoRistorante.menu.add(carbonara);
		nuovoRistorante.menu.add(amatriciana);
		nuovoRistorante.menu.add(cacioEPepe);
		nuovoRistorante.menu.add(pizzaMargherita);
		nuovoRistorante.menu.add(pizzaCapricciosa);
		nuovoRistorante.menu.add(supplì);
		nuovoRistorante.menu.add(cocaCola);
		nuovoRistorante.menu.add(fanta);
		nuovoRistorante.menu.add(sprite);



		
		
		do {
			System.out.println("PREMI 0 PER USCIRE") ;
			System.out.println("PREMI 1 PER REGISTRARE CLIENTE");
			System.out.println("PREMI 2 PER RIMUOVERE CLIENTE" );
			System.out.println("PREMI 3 PER AGGIUNGERE ORDINE");
			System.out.println("PREMI 4 PER RIMUOVERE ORDINE");
			System.out.println("PREMI 5 PER STAMPARE LE FATTURE DEI CLIENTI");
			System.out.println("PREMI 6 PER STAMPARE IL NUMERO DI CLIENTI GIORNALIERI");
			System.out.println("PREMI 7 PER STAMPARE IL NUMERO DI ORDINAZIONI GIORNALIERE");
			System.out.println("PREMI 8 PER STAMPARE IL FATTURATO GIORNALIERO");
			
			
			key = tastiera.nextInt();
			
			switch(key) {
			case 1 :
				System.out.println("INSERIRE IL NOME DEL CLIENTE");
				String nomeCliente = tastiera.next().toUpperCase();
				Cliente nuovoCliente = new Cliente(nomeCliente);
				nuovoRistorante.aggiungiCliente(nuovoCliente);
				System.out.println("ID CLIENTE: " + nuovoCliente.getId());
				System.out.println("Cliente registrato " + nuovoCliente.getRegistrazioneCliente());
				break;
				
			case 2 :
				System.out.println("INSERIRE L'ID DEL CLIENTE");
				int id3 = 0;

				id3 = nuovoRistorante.detectInputMismatch(id3, tastiera);
				
				if(nuovoRistorante.ricercaCliente(id3) != null) {
					nuovoRistorante.rimuoviCliente(nuovoRistorante.ricercaCliente(id3));
					System.out.println("Operazione riuscita.");
				} else {
					System.err.println("NOME CLIENTE NON TROVATO.");
				}
				
				break;
				
			case 3 :
				System.out.println("INSERIRE L'ID DEL CLIENTE.");
				int id = 0;
				id = nuovoRistorante.detectInputMismatch(id, tastiera);
				
			
				System.out.println("INSERIRE PIATTO");
				String nomePiatto = tastiera.next().toUpperCase();
				
				if(nuovoRistorante.ricercaMenu(nomePiatto) == null) {
					System.err.println("NOME PIATTO NON TROVATO.");
				} 
				else if (nuovoRistorante.ricercaCliente(id) == null) {
					System.err.println("NOME CLIENTE NON TROVATO.");
				} 
				else {
					nuovoRistorante.ricercaCliente(id).aggiungiOrdinazione(nuovoRistorante.ricercaMenu(nomePiatto));
					System.out.println("Ordinazione effettuata.");
				}
				
				
				break;
				
			case 4 :
				System.out.println("INSERIRE L'ID DEL CLIENTE.");
				int id1 = 0;
				id1 = nuovoRistorante.detectInputMismatch(id1, tastiera);

				System.out.println("INSERIRE PIATTO");
				String nomePiatto1 = tastiera.next().toUpperCase();
				
				
				if(nuovoRistorante.ricercaCliente(id1) == null) {
					System.err.println("ID CLIENTE NON TROVATO.");
				} 
				else if (nuovoRistorante.ricercaCliente(id1).ricercaPiatto(nomePiatto1) == null) {
					System.err.println("ORDINAZIONE NON TROVATA.");

				}
				else {
						nuovoRistorante.ricercaCliente(id1).getListaOrdinazioni().remove(nuovoRistorante.ricercaCliente(id1).ricercaPiatto(nomePiatto1));
						System.out.println("Operazione riuscita.");
				}
				
				break;
				
			case 5 :
				for (int i = 0; i < nuovoRistorante.listaClienti.size(); i++) {
					System.out.println("ORDINAZIONI DI " + nuovoRistorante.listaClienti.get(i).getNome().toUpperCase() + "\n");
					for(int j = 0; j < nuovoRistorante.listaClienti.get(i).getListaOrdinazioni().size(); j++) {
						System.out.println(nuovoRistorante.listaClienti.get(i).getListaOrdinazioni().get(j).getNomePiatto() + " " +
								nuovoRistorante.listaClienti.get(i).getListaOrdinazioni().get(j).getPrezzo() + " €");
						} 
							System.out.println("\n");
							System.out.println("TOTALE: " + nuovoRistorante.listaClienti.get(i).getFattura() + " €");
							System.out.println("\n");
							System.out.println("---------------------");
							System.out.println("\n");
						}				
				break;
				
			case 6 :
				System.out.println("TOTALE CLIENTI DI OGGI: " + nuovoRistorante.numeroClientiDiOggi()); 
				break;
				
			case 7 :
				System.out.println("TOTALE ORDINAZIONI DI OGGI: " + nuovoRistorante.calcoloNumeroOrdinazioni());
				break;
				
			case 8:
				System.out.println("TOTALE FATTURATO DI OGGI: " + nuovoRistorante.getIncassoTotale() + " €");
				break;
				
			}
			
			
			
		} while (key != 0);
			
		tastiera.close();




	}




}
