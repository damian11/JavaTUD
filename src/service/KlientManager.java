package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KlientManager {
	private Connection connection;
	private String url =  "jdbc:hsqldb:hsql://localhost/workdb";
	private String createTableKlient = "CREATE TABLE Klient(id_klient bigint GENERATED BY DEFAULT AS IDENTITY, imie varchar(30), nazwisko varchar(50),telefon bigint)"; 
	
	
	private PreparedStatement DodajKlient;
	private PreparedStatement UsunKlienta;
	private PreparedStatement UsunKlientow;
	private PreparedStatement PobierzKlientow;
	private PreparedStatement EdytujKlienta;
	
	private Statement statement;
	
	
}