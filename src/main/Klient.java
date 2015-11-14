package main;

public class Klient {
	private int id_klient;
	private String imie = "brak";
	private String nazwisko = "brak";
	private int telefon;
	
	public Klient() {
		super();
		
	}
	 public Klient(String imie, String nazwisko, int telefon) {
		 super();
		
		 this.imie = imie;
		 this.nazwisko = nazwisko;
		 this.telefon = telefon;
	 }
	 
	 public int getId_klient(){
		 
		 return id_klient;
		
	 }
	 
	 
	 public void setId_klient(int id_klient){
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
	 
	 public int getTelefon() {
		 return telefon;
	 
	 }
	 public void setTelefon(int telefon){
	 this.telefon = telefon;
	 }
	 
	 }

