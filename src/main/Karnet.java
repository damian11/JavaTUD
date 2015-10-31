package main;

public class Karnet {
	
	private String rodzaj = "brak";
	private String opis = "brak";
	private int cena;
	
	
	public Karnet() {
		super();
		}
	
	
	public Karnet(String rodzaj, String opis, int cena) {
		super();
		this.rodzaj = rodzaj;
		this.opis = opis;
		this.cena = cena;
		
	}
	public String getRodzaj(){
		return rodzaj;
	}
	public void setRodzaj(String rodzaj){
		this.rodzaj = rodzaj;
		
	}
	
	public String getOpis(){
		return opis;
	}
	
	public void setOpis(String opis){
		this.opis = opis;
	}
	
	public int getCena(){
		return cena;
	}
	
	public void setCena(int cena){
		this.cena = cena;
	
	}
	
}
