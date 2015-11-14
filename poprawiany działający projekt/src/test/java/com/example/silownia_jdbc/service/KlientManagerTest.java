package test.java.com.example.silownia_jdbc.service;


import static org.junit.Assert.*;

import java.util.List;


import org.junit.Test;

import main.java.com.example.silownia_jdbc.domain.*;
import main.java.com.example.silownia_jdbc.service.*;



public class KlientManagerTest {
KlientManager klientManager = new KlientManager();
	

     private final static String IMIE_1 = "Jurand";
     private final static String NAZWISKO_1 = "Spychowski";
     private final static int TELEFON_1 = 600100100;
     

     private final static String IMIE_2 = "Ja";
     private final static String NAZWISKO_2 = "Nusz";
     private final static int TELEFON_2 = 555222111;
     
@Test
	public void sprawdzPolaczenie() {
		assertNotNull(klientManager.getConnection());
	}
@Test
	public void sprawdzDodajKlienta() {
	
	Klient klient = new Klient (IMIE_1, NAZWISKO_1, TELEFON_1);
	
	klientManager.wyczyscKlientow();
	assertEquals(1,klientManager.dodajKlienta(klient));
	
	List<Klient> klienci = klientManager.PobierzKlientow();
	Klient pobieranieKlienta = klienci.get(0);
	
	assertEquals(IMIE_1, pobieranieKlienta.getImie());
	assertEquals(NAZWISKO_1, pobieranieKlienta.getNazwisko());
	assertEquals(TELEFON_1, pobieranieKlienta.getTelefon());
	}

@Test
	public void sprawdzUsunKlienta() {
	
	Klient klient = new Klient (IMIE_1, NAZWISKO_1, TELEFON_1);
	
	klientManager.wyczyscKlientow();
	assertEquals(1,klientManager.dodajKlienta(klient));
	
	List<Klient> k = klientManager.PobierzKlientow();
	Klient pobieranieKlienta = k.get(0);
	
	
	assertEquals(1, klientManager.usunKlienta(pobieranieKlienta));
	

}


@Test
public void sprawdzEdytujKlienta() {

Klient klient = new Klient (IMIE_1, NAZWISKO_1, TELEFON_1);

klientManager.wyczyscKlientow();
assertEquals(1,klientManager.dodajKlienta(klient));

List<Klient> k = klientManager.PobierzKlientow();
Klient pobieranieKlienta = k.get(0);


pobieranieKlienta.setImie(IMIE_2);
pobieranieKlienta.setNazwisko(NAZWISKO_2);
pobieranieKlienta.setTelefon(TELEFON_2);


assertEquals(1, klientManager.edytujKlienta(pobieranieKlienta));

List<Klient> k2 = klientManager.PobierzKlientow();
Klient pobieranieKlienta2 = k2.get(0);


assertEquals(IMIE_2, pobieranieKlienta2.getImie());
assertEquals(NAZWISKO_2, pobieranieKlienta2.getNazwisko());
assertEquals(TELEFON_2, pobieranieKlienta2.getTelefon());
assertEquals(pobieranieKlienta2.getId_klient(), pobieranieKlienta2.getId_klient());

}



}
