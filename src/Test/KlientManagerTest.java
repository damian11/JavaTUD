package Test;

import static org.junit.Assert.*;

import java.util.List;

import main.Klient;

import org.junit.Test;

import service.KlientManager;

public class KlientManagerTest {
service.KlientManager klientManager = new KlientManager();
	
	 private final static long ID_KLIENT_1 = 1;
     private final static String IMIE_1 = "Jurand";
     private final static String NAZWISKO_1 = "Spychowski";
     private final static long TELEFON_1 = 600100100;
@Test
	public void sprawdzPolaczenie() {
		assertNotNull(klientManager.getConnection());
	}
@Test
	public void sprawdzDodajKlienta() {
	
	Klient klient = new Klient (ID_KLIENT_1, IMIE_1, NAZWISKO_1, TELEFON_1);
	
	klientManager.wyczyscKlientow();
	assertEquals(1,klientManager.dodajKlienta(klient));
	
	List<Klient> klienci = klientManager.PobierzKlientow();
	Klient wyszukajKlient = klienci.get(0);
	
	assertEquals(IMIE_1, wyszukajKlient.getImie());
	assertEquals(NAZWISKO_1, wyszukajKlient.getNazwisko());
	assertEquals(TELEFON_1, wyszukajKlient.getTelefon());
	}

}

