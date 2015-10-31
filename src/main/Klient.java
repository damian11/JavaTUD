package main;

public class Klient {

	private String imie = "brak";
	private String nazwisko = "brak";
	private String telefon = "brak";
	
	public Klient() {
		super();
		
	}
	 public Klient(String imie, String nazwisko, String telefon) {
		 super();
		 this.imie = imie;
		 this.nazwisko = nazwisko;
		 this.telefon = telefon;
	 }
	 
	 public String getImie() {
		 return imie;
	 }
	 
	 public void setImie(String imie) {
		 this.imie =imie;
	
	}
	 public String getNazwisko() {
	 return nazwisko;
	 }
	 
	 public void setNazwisko(String nazwisko) {
	 this.nazwisko = nazwisko;	 
	 }
	 
	 public String getTelefon() {
		 return telefon;
	 
	 }
	 public void setTelefon(String telefon){
	 this.telefon = telefon;
	 }
	 
	 }

