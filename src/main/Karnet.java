package main;

public class Karnet {
	private long id_karnet;
	private String rodzaj = "brak";
	private String opis = "brak";
	private double cena;
	
	
	public Karnet() {
		super();
		}
	
	
	public Karnet(String rodzaj, String opis, double cena) {
		super();
		
		this.rodzaj = rodzaj;
		this.opis = opis;
		this.cena = cena;
		
	}
	
	public long getId_karnet(){
		return id_karnet;
	}
	
	public void setId_karnet(long id_karnet){
		this.id_karnet = id_karnet;
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
	
	public double getCena(){
		return cena;
	}
	
	public void setCena(double cena){
		this.cena = cena;
	
	}
}
