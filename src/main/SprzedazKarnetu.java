package main;

public class SprzedazKarnetu {

	private long id_sprzedazKarnetu;
	private long id_klient;
	private long id_karnet;
	
	
	
	
	public SprzedazKarnetu(){
	
	}


	public  long getId_klient(){
		return id_klient;
	}
	
	public void setId_klient(long id_klient){
		this.id_klient = id_klient;
		
	}
	
	public  long getId_karnet(){
		return id_karnet;
	}
	
	public void setId_karnet(long id_karnet){
		this.id_karnet = id_karnet;
	}
	

	

	public long getId_sprzedazKarnetu() {
		return id_sprzedazKarnetu;
	}
	
	public void setId_sprzedazKarnetu(Long id_sprzedazKarnetu) {
		this.id_sprzedazKarnetu = id_sprzedazKarnetu;
	}
	
	
}


