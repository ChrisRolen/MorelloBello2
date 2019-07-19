package data_package;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;


public class Utenti {
	private String name;
	private String surname;
	private String address;
	private int CAP;
	private String city;
	private String phone_number;
	private static String email;
	private String password;
	private int LibroCard;
	private int numberofpoints;
        private ResultSet rs;
        private PreparedStatement pstmt;
        private Connection conn=database.connection();
        private Statement stmt=conn.createStatement();
        
	public Utenti(String email, String password) throws SQLException {
		rs = stmt.executeQuery("SELECT * from utenti WHERE email =" + email+ "AND pasword =" +password);
		
	if(rs.next()){
		
		while(rs.next()){
		this.name = rs.getString("nome");
		this.surname = rs.getString("cognome");
		this.address = rs.getString("indirizzo");
		CAP = rs.getInt("CAP");
		this.city = rs.getString("citta");
		this.phone_number = rs.getString("telefono");
		this.email = email;
		this.password = password;
		this.LibroCard = rs.getInt("libro_card");
		this.numberofpoints = rs.getInt("numero_punti");
		
		}
		
	}else{
		throw new NoUserFoundException("L'utente non � presente nel database!");
	}
	}

	
	
	public void setName(String name) {
		this.name = name;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setCAP(int cAP) {
		CAP = cAP;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}



	public static void setEmail(String email) {
		Utenti.email = email;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setLibroCard(int libroCard) {
		LibroCard = libroCard;
	}



	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getAddress() {
		return address;
	}

	public int getCAP() {
		return CAP;
	}

	public String getCity() {
		return city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public static String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getLibroCard() {
		return LibroCard;
	}
	
	public int getNumberofpoints() {
		return numberofpoints;
	}

	public void setNumberofpoints(int numberofpoints) {
		this.numberofpoints = numberofpoints;
	}

	public boolean isheanadmin(String email, String password) throws SQLException{
		rs = stmt.executeQuery("SELECT * from responsabili WHERE email =" + email + "AND password =" + password);
		return rs.next();
	}
	
	public void make_an_order(String name, String surname, String address, int CAP, String phone_number, String email, String tipodipag) throws SQLException{
		//Libri.carrello;
		String query = " insert into ordine (data_ordine, nome, cognome, "
					+ "indirizzo, CAP, telefono, email, costo_totale, tipo_pagamento)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setDate(1,  new Date(System.currentTimeMillis()));
		pstmt.setString(2, name);
		pstmt.setString(3, surname);
		pstmt.setString(4, address);
		pstmt.setInt(5, CAP);
		pstmt.setString(6, phone_number);
		pstmt.setString(7, email);
		
		int costototale = 0;
		for(Libri a:Libri.carrello){
			costototale += a.getPrice(); 
		}
		
		pstmt.setInt(8, costototale);
		pstmt.setString(9, tipodipag);
		pstmt.execute();
			
	}
	
	public void make_an_order(Utenti utente, String tipodipag) throws SQLException{
		//Libri.carrello;
		String query = " insert into ordine (data_ordine, utente, costo_totale, tipo_pagamento, punti_libro)"
			        + " values (?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setDate(1,  new Date(System.currentTimeMillis()));
		pstmt.setInt(2, utente.getLibroCard());
		
		
		int costototale = 0;
		int puntitotali = 0;
		for(Libri a:Libri.carrello){
			costototale += a.getPrice();
			puntitotali += a.getNumberofpoints();
		}
		
		pstmt.setInt(3, costototale);
		pstmt.setString(4, tipodipag);
		pstmt.setInt(5, puntitotali);
		pstmt.execute();
		utente.setNumberofpoints((utente.getNumberofpoints() + puntitotali));
			
	}
	
	public void listoforders(String email) throws SQLException{
		rs = stmt.executeQuery("SELECT * from ordine WHERE email=" + email);
		
		while(rs.next()){
			
		}
		
	}

	public void new_User(String email, String password, String name, String surname, String address, int CAP, String city, int phone_number) throws SQLException{
		String query = " insert into ordine (data_ordine, nome, cognome, "
				+ "email, pasword, nome, cognome, indirizzo, CAP, citta, telefono, libro_card, data_emissione, numero_punti)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setString(4, surname);
		pstmt.setString(5,  address);
		pstmt.setInt(6, CAP);
		pstmt.setString(7, city);
		pstmt.setInt(8, phone_number);
		
		Random rand = new Random();
		pstmt.setInt(9, rand.nextInt());
		pstmt.setDate(10, new Date(System.currentTimeMillis()));
		pstmt.setInt(11, 0);
		pstmt.execute();
	}
}
