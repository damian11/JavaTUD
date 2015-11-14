package test.java.com.example.silownia_jdbc.service;

import main.java.com.example.silownia_jdbc.domain.*;
import main.java.com.example.silownia_jdbc.service.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



	public class SprzedazKarnetuManagerTest {
	SprzedazKarnetuManager SprzedazKarnetuManager = new SprzedazKarnetuManager();
	KlientManager KlientManager = new KlientManager();
	KarnetManager KarnetManager = new KarnetManager();
	
	
		
	private final static int ID_KLIENT_1 = 1;
    private final static String IMIE_1 = "Jurand";
    private final static String NAZWISKO_1 = "Spychowski";
    private final static int TELEFON_1 = 600100100;
    
    private final static int ID_KARNET_1 = 1;
    private final static String RODZAJ_1 = "OPEN";
    private final static String OPIS_1 = "Karnet pozwala na: korzystanie z wszystkich stref fitnnes, uczestniczenie we wszystkich zajeciach, oraz gwarantuje 2 treningi personalne miesiêcznie";
    private final static double CENA_1 = 250;
    private final static double DELTA = 1e-15;

  
	     
	@Test
		public void sprawdzPolaczenie() {
			assertNotNull(SprzedazKarnetuManager.getConnection());
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
	public void sprawdzDodajKlienta() {
	
	Klient klient = new Klient (IMIE_1, NAZWISKO_1, TELEFON_1);
	
	KlientManager.wyczyscKlientow();
	assertEquals(1,KlientManager.dodajKlienta(klient));
	
	List<Klient> klienci = KlientManager.PobierzKlientow();
	Klient pobieranieKlienta = klienci.get(0);
	
	assertEquals(IMIE_1, pobieranieKlienta.getImie());
	assertEquals(NAZWISKO_1, pobieranieKlienta.getNazwisko());
	assertEquals(TELEFON_1, pobieranieKlienta.getTelefon());
	}
	
	@Test
	public void sprawdzSprzedazKarnetu(){
		SprzedazKarnetu sprzedazKarnetu = new SprzedazKarnetu(ID_KLIENT_1 , ID_KARNET_1 );
		
		
		Klient klient = new Klient (IMIE_1, NAZWISKO_1, TELEFON_1);
		KlientManager.wyczyscKlientow();
		assertEquals(1,KlientManager.dodajKlienta(klient));
		
		Karnet karnet = new Karnet (RODZAJ_1, OPIS_1, CENA_1);
		KarnetManager.wyczyscKarnety();
		assertEquals(1, KarnetManager.dodajKarnet(karnet));
		
		
		SprzedazKarnetuManager.wyczyscSprzedazeKarnetu();
		assertEquals(1, SprzedazKarnetuManager.dodajSprzedazKarnetu(klient, karnet ));
	}
	

	

	}
	

