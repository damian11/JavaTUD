package main.java.com.example.silownia_jdbc.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.example.silownia_jdbc.domain.*;;

public class KlientManager {
	private Connection connection;
	private String url =  "jdbc:hsqldb:hsql://localhost/";
	private String createTableKlient = "CREATE TABLE Klient(id_klient bigint GENERATED BY DEFAULT AS IDENTITY, imie varchar(30), nazwisko varchar(50),telefon bigint)"; 
	
	
	private PreparedStatement DodajKlienta;
	private PreparedStatement UsunKlienta;
	private PreparedStatement UsunKlientow;
	private PreparedStatement PobierzKlientow;
	private PreparedStatement EdytujKlienta;
	
	private Statement statement;
	
	public KlientManager(){
		try{
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			
			ResultSet rs =	connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while(rs.next()){
				if("Klient".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
					tableExists = true;
					break;
				}
			}
			
			if(!tableExists)
				statement.executeUpdate(createTableKlient);
			
			DodajKlienta = connection.prepareStatement("INSERT INTO Klient(imie, nazwisko, telefon) VALUES (?, ?, ?)");
			UsunKlienta = connection.prepareStatement("DELETE FROM Klient WHERE id_klient = ?");
			UsunKlientow = connection.prepareStatement("DELETE FROM Klient");
			PobierzKlientow = connection.prepareStatement("SELECT id_klient, imie, nazwisko, telefon FROM Klient");
			EdytujKlienta = connection.prepareStatement("UPDATE Klient SET imie = ?, nazwisko = ?, telefon = ? WHERE id_klient = ?");
			
				
			
	}catch(SQLException e){
		e.printStackTrace();
	}
}

public Connection getConnection(){
	return connection;
}
	public void wyczyscKlientow(){
	try{
		UsunKlientow.executeUpdate();
		}catch (SQLException e){ 
			e.printStackTrace();
		}
}

	public int dodajKlienta(Klient klient){
		int count = 0;
		try{
			DodajKlienta.setString(1, klient.getImie());
			DodajKlienta.setString(2, klient.getNazwisko());
			DodajKlienta.setInt(3, klient.getTelefon());
			
			
			
			count = DodajKlienta.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int edytujKlienta(Klient klient){
		int count = 0;
		try{
		
			EdytujKlienta.setString(1, klient.getImie());
			EdytujKlienta.setString(2, klient.getNazwisko());
			EdytujKlienta.setInt(3, klient.getTelefon());
			EdytujKlienta.setInt(4, klient.getId_klient());
			
			
			count = EdytujKlienta.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	public int usunKlienta(Klient klient){
		int count = 0;
		try{
			UsunKlienta.setInt(1, klient.getId_klient());

			
			
			
			count = UsunKlienta.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	
	public List<Klient> PobierzKlientow(){
		List<Klient> klienci = new ArrayList<Klient>();
		
		try{
			ResultSet rs = PobierzKlientow.executeQuery();
			
			while (rs.next()){
				Klient k = new Klient();
				k.setId_klient(rs.getInt("id_klient"));
				k.setImie(rs.getString("imie"));
				k.setNazwisko(rs.getString("nazwisko"));
				k.setTelefon(rs.getInt("telefon"));
				klienci.add(k);
			}}catch(SQLException e) {
				e.printStackTrace();
			}
			return klienci;
		}
	}