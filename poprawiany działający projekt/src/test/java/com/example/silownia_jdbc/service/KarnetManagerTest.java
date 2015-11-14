package test.java.com.example.silownia_jdbc.service;


import static org.junit.Assert.*;

import java.util.List;



import org.junit.Test;

import main.java.com.example.silownia_jdbc.domain.*;
import main.java.com.example.silownia_jdbc.service.*;

public class KarnetManagerTest {
KarnetManager KarnetManager = new KarnetManager();
	

     private final static String RODZAJ_1 = "aaaaaaaaaaaaaaa";
     private final static String OPIS_1 = "ccccccccccccc";
     private final static double CENA_1 = 25;
     

     private final static String RODZAJ_2 = "vvvvvvvvvv";
     private final static String OPIS_2 = "xxxxxxxx";
     private final static double CENA_2 = 200;
     private final static double DELTA = 1e-15;
     
@Test
	public void sprawdzPolaczenie() {
		assertNotNull(KarnetManager.getConnection());
	}

@Test
	public void sprawdzDodajKarnet() {
	
	Karnet karnet = new Karnet (RODZAJ_1, OPIS_1, CENA_1);
	
	KarnetManager.wyczyscKarnety();
	assertEquals(1, KarnetManager.dodajKarnet(karnet));
	
	List<Karnet> karnety = KarnetManager.PobierzKarnety();
	Karnet pobieranieKarnetu = karnety.get(0);
	
	assertEquals(RODZAJ_1, pobieranieKarnetu.getRodzaj());
	assertEquals(OPIS_1, pobieranieKarnetu.getOpis());
	assertEquals(CENA_1, pobieranieKarnetu.getCena(),DELTA);
	 
	}

@Test
	public void sprawdzUsunKarnet() {
	
	Karnet karnet = new Karnet (RODZAJ_1, OPIS_1, CENA_1);
	
	KarnetManager.wyczyscKarnety();
	assertEquals(1,KarnetManager.dodajKarnet(karnet));
	
	List<Karnet> k = KarnetManager.PobierzKarnety();
	Karnet pobieranieKarnetu = k.get(0);
	
	
	assertEquals(1, KarnetManager.usunKarnet(pobieranieKarnetu));
	

}


@Test
public void sprawdzEdytujKarnet() {

Karnet karnet = new Karnet (RODZAJ_1, OPIS_1, CENA_1);

KarnetManager.wyczyscKarnety();
assertEquals(1,KarnetManager.dodajKarnet(karnet));

List<Karnet> k = KarnetManager.PobierzKarnety();
Karnet pobieranieKarnetu = k.get(0);


pobieranieKarnetu.setRodzaj(RODZAJ_2);
pobieranieKarnetu.setOpis(OPIS_2);
pobieranieKarnetu.setCena(CENA_2);


assertEquals(1, KarnetManager.edytujKarnet(pobieranieKarnetu));

List<Karnet> k2 = KarnetManager.PobierzKarnety();
Karnet pobieranieKarnetu2 = k2.get(0);


assertEquals(RODZAJ_2, pobieranieKarnetu2.getRodzaj());
assertEquals(OPIS_2, pobieranieKarnetu2.getOpis());
assertEquals(CENA_2, pobieranieKarnetu2.getCena(),DELTA);
assertEquals(pobieranieKarnetu2.getId_karnet(), pobieranieKarnetu2.getId_karnet());

}



}
