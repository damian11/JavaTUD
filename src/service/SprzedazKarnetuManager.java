


package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import main.SprzedazKarnetu;

public class SprzedazKarnetuManager {
	private Connection connection;
	private String url =  "jdbc:hsqldb:hsql://localhost/";
	private String createTableSprzedazKarnetu = "CREATE TABLE SprzedazKarnetu(id_klient int foreign key references Klient(id_klient), id_karnet int foreign key references Karnet(id_karnet))"; 
	
	
	private PreparedStatement DodajSprzedazKarnetu;
	private PreparedStatement UsunSprzedazKarnetu;
	private PreparedStatement UsunSprzedazeKarnetu;
	private PreparedStatement PobierzSprzedazeKarnetu;
	private PreparedStatement EdytujSprzedazKarnetu;
	
	private Statement statement;
	
	public SprzedazKarnetuManager(){
		try{
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			
			ResultSet rs =	connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while(rs.next()){
				if("SprzedazKarnetu".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
					tableExists = true;
					break;
				}
			}
			
			if(!tableExists)
				statement.executeUpdate(createTableSprzedazKarnetu);
			
			DodajSprzedazKarnetu = connection.prepareStatement("INSERT INTO SprzedazKarnetu(id_klient, id_karnet) VALUES (?, ?)");
			UsunSprzedazKarnetu = connection.prepareStatement("DELETE FROM SprzedazKarnetu WHERE id_klient = ? and id_karnet = ?");
			UsunSprzedazeKarnetu = connection.prepareStatement("DELETE FROM SprzedazKarnetu");
			PobierzSprzedazeKarnetu = connection.prepareStatement("SELECT id_klient, id_karnet FROM SprzedazKarnetu");
			EdytujSprzedazKarnetu = connection.prepareStatement("UPDATE SprzedazKarnetu SET id_karnet = ? WHERE id_klient = ?");
			
				
			
	}catch(SQLException e){
		e.printStackTrace();
	}
}

public Connection getConnection(){
	return connection;
}
	public void wyczyscSprzedazeKarnetu(){
	try{
		UsunSprzedazeKarnetu.executeUpdate();
		}catch (SQLException e){ 
			e.printStackTrace();
		}
}

	public int dodajSprzedazKarnetu(SprzedazKarnetu sprzedaz){
		int count = 0;
		try{
			DodajSprzedazKarnetu.setInt(1, sprzedaz.getId_klient());
			DodajSprzedazKarnetu.setInt(2, sprzedaz.getId_karnet());

			
			
			
			count = DodajSprzedazKarnetu.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int edytujSprzedazKarnetu(SprzedazKarnetu sprzedaz){
		int count = 0;
		try{
		
			
			EdytujSprzedazKarnetu.setInt(1, sprzedaz.getId_karnet());
		
			EdytujSprzedazKarnetu.setInt(3, sprzedaz.getId_klient());
			
			
			count = EdytujSprzedazKarnetu.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	public int usunSprzedazKarnetu(SprzedazKarnetu sprzedazKarnetu){
		int count = 0;
		try{
			UsunSprzedazKarnetu.setInt(1, sprzedazKarnetu.getId_klient());
			UsunSprzedazKarnetu.setInt(2, sprzedazKarnetu.getId_karnet());

			
			
			
			count = UsunSprzedazKarnetu.executeUpdate();
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	
	public List<SprzedazKarnetu> SprzedazKarnetu(){
		List<SprzedazKarnetu> sprzedazeKarnetu = new ArrayList<SprzedazKarnetu>();
		
		try{
			ResultSet rs = PobierzSprzedazeKarnetu.executeQuery();
			
			while (rs.next()){
				SprzedazKarnetu s = new SprzedazKarnetu();
				s.setId_klient(rs.getInt("id_klient"));
				s.setId_karnet(rs.getInt("id_karnet"));
			
				
				sprzedazeKarnetu.add(s);
			}}catch(SQLException e) {
				e.printStackTrace();
			}
			return sprzedazeKarnetu;
		}
	}