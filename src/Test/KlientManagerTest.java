package Test;

import static org.junit.Assert.*;

import java.util.List

import org.junit.Test;

import com.service.KlientManager;

public class KlientManagerTest {
service.KlientManager klientManager = new KlientManager();
	

     private final static String IMIE_1 = "Jurand";
     private final static String NAZWISKO_1 = "Spychowski";
     private final static long TELEFON_1 = 600100100;
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
	Klient wyszukajklienta = klient.getKlient(0);
	
	assertEquals(IMIE_1, wyszukajKlient.getImie());
	assertEquals(NAZWISKO_1, wyszukajKlient.getNazwisko);
	assertEquals(TELEFON_1, wyszukajKlient.getTelefon);
	}

}















