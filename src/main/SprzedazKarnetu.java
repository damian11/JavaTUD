package main;

public class SprzedazKarnetu {

	private long id_sprzedazKarnetu;
	private long id_klient;
	private long id_karnet;
	private String notatka = "brak";
	
	
	
	public SprzedazKarnetu(){
		super();
	}

	public SprzedazKarnetu(long id_klient, long id_karnet, String notatka){
		super();
		this.id_karnet = id_karnet;
		this.id_klient = id_klient;
		this.notatka = notatka;
	}
	public static long getId_klient(){
		return id_klient;
	}
	
	public void setId_klient(long id_klient){
		this.id_klient = id_klient;
		
	}
	
	public static long getId_karnet(){
		return id_karnet;
	}
	
	public void setId_karnet(long id_karnet){
		this.id_karnet = id_karnet;
	}
	
	public static String getNotatka(){
		return notatka;
	}
	
	public void setNotatka(String notatka){
		this.notatka = notatka;
	}

	public long getId_sprzedazKarnetu() {
		return id_sprzedazKarnetu;
	}
	
	public void setId_sprzedazKarnetu(Long id_sprzedazKarnetu) {
		this.id_sprzedazKarnetu = id_sprzedazKarnetu;
	}
	
	
}


