package main;

public class Klient {
	private long id_klient;
	private String imie = "brak";
	private String nazwisko = "brak";
	private long telefon;
	

		
	
	 public Klient(long id_klient, String imie, String nazwisko, long telefon) {
		 super();
		 this.id_klient = id_klient;
		 this.imie = imie;
		 this.nazwisko = nazwisko;
		 this.telefon = telefon;
	 }
	 
	 public Klient() {
		// TODO Auto-generated constructor stub
	}

	public long getId_klient(){
		 
		 return id_klient;
		
	 }
	 
	 
	 public void setId_klient(long id_klient){
		 this.id_klient = id_klient;
	 }
	 
	 public String getImie() {
		 return imie;
	 }
	 
	 public void setImie(String imie) {
		 this.imie = imie;
	
	}
	 public String getNazwisko() {
	 return nazwisko;
	 }
	 
	 public void setNazwisko(String nazwisko) {
	 this.nazwisko = nazwisko;	 
	 }
	 
	 public long getTelefon() {
		 return telefon;
	 
	 }
	 public void setTelefon(long telefon){
	 this.telefon = telefon;
	 }

	 }

