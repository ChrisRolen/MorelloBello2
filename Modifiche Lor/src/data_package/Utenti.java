package data_package;
import data_package.Ordine;
import data_package.database;
import static java.lang.Math.random;
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
        private boolean admin;
        private Date data_emissione;
        public static Utenti utente;
        public boolean corretto = false;

    private ResultSet rs;
    private PreparedStatement pstmt;
    private Connection conn=database.connection();
    private Statement stmt=conn.createStatement();
        
	public Utenti(String email, String password) throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM database_progetto.utenti where email='"+email+"' and pasword='"+password+"';");
		System.out.println("SELECT * from utenti WHERE email='" + email+ "' AND pasword='" +password+"';");
		
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
                this.admin=rs.getBoolean("admin");
                this.data_emissione=rs.getDate("data_emissione");
                System.out.print("yeeee");
                corretto = true;
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

	public boolean isAdmin() {
            return admin;
        }
	public static void make_an_order(String name, String surname, String address, int CAP, String phone_number, String email, String tipodipag, int copie) throws SQLException{
		//Libri.carrello;
                PreparedStatement pstm;
                Connection con = database.connection();
		String query = " insert into ordine (data_ordine, nome, cognome, "
					+ "indirizzo, CAP, telefono, email, costo_totale, tipo_pagamento, codice)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstm = con.prepareStatement(query);
		pstm.setDate(1,  new Date(System.currentTimeMillis()));
		pstm.setString(2, name);
		pstm.setString(3, surname);
		pstm.setString(4, address);
		pstm.setInt(5, CAP);
		pstm.setString(6, phone_number);
		pstm.setString(7, email);
		
		int costototale = 0;
                int pos = 0;
		for(Libri a:Libri.carrello){
			costototale += a.getPrice();
		}
		
		pstm.setInt(8, costototale);
		pstm.setString(9, tipodipag);
                
                int cod = (int) random();
                pstm.setInt(10, cod);
		pstm.execute();
                
                
                String quer = "insert into libri_ordine (ISBN, copie, codice_ordine)" + " values (?, ?, ?)";
                pstm = con.prepareStatement(quer);
                int i=0;
                
             for(Libri a:Libri.carrello){
                pstm.setString(1, a.getISBN());
                pstm.setInt(2, a.numerodicopie.get(i));
                pstm.setInt(3, cod);
                }
             
                pstm.execute();
	}
	
	public void make_an_order(Utenti utente, String indirizzi[], String tipodipag) throws SQLException{
		//Libri.carrello;
		String query = " insert into ordine (data_ordine, utente, costo_totale, tipo_pagamento, punti_libro, email, indirizzo, codice)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
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
		pstmt.setString(6, utente.getEmail());
		
		String indirizzitot= "";
		indirizzitot.concat(utente.getAddress());
		indirizzitot.concat(" ");
		
		for(String a:indirizzi){
			indirizzitot.concat(a);
			indirizzitot.concat(" ");
		}
		
		pstmt.setString(7, indirizzitot);
		 int cod = (int) random();
                pstmt.setInt(8, cod);
		pstmt.execute();
		utente.setNumberofpoints((utente.getNumberofpoints() + puntitotali));
                
               
                
                
                String quer = "insert into libri_ordine (ISBN, copie, codice_ordine)" + " values (?, ?, ?)";
                pstmt = conn.prepareStatement(quer);
                int i=0;
                
             for(Libri a:Libri.carrello){
                pstmt.setString(1, a.getISBN());
                pstmt.setInt(2, a.numerodicopie.get(i));
                pstmt.setInt(3, cod);
                }
             
                pstmt.execute();
                
                
			
	}
	
	public ArrayList<Ordine> listoforders(String email) throws SQLException{
		rs = stmt.executeQuery("SELECT * from ordine WHERE email='" + email + "'");
		ArrayList<Ordine> lista = new ArrayList<Ordine>();
		
		while(rs.next()){
			Ordine ord = new Ordine(rs.getInt("codice"));
			lista.add(ord);
		}
		
		return lista;
		
	}
	
	public ArrayList<Ordine> listoforders(int codice) throws SQLException{
		rs = stmt.executeQuery("SELECT * from ordine WHERE codice=" + codice);
		ArrayList<Ordine> lista = new ArrayList<Ordine>();
		
		while(rs.next()){
			Ordine ord = new Ordine(rs.getInt("codice"));
			lista.add(ord);
		}
		return lista;
		
	}

	public static void new_User(String email, String password, String name, String surname, String address, int CAP, String city, String phone_number) throws SQLException{
		String query = " insert into utenti ( nome, cognome, "
				+ "email, pasword, indirizzo, CAP, citta, telefono, libro_card, data_emissione, numero_punti)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt;
                Connection conn=database.connection();
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setString(2, surname);
                pstmt.setString(3, email);
		pstmt.setString(4, password);
		pstmt.setString(5,  address);
		pstmt.setInt(6, CAP);
		pstmt.setString(7, city);
		pstmt.setString(8, phone_number);
		
		Random rand = new Random();
		pstmt.setInt(9, rand.nextInt());
		pstmt.setDate(10, new Date(System.currentTimeMillis()));
		pstmt.setInt(11, 0);
		pstmt.execute();
                pstmt.close();
	}

    public Date getData_emissione() {
        return data_emissione;
    }

    public void modify(String email, String password, String nome, String cognome, String indirizzo, int cap, String citta, String telefono) throws SQLException {
        String query="update utenti set nome=?, cognome=?, indirizzo=?, CAP=?,citta=?,telefono=?,email=?,pasword=? where libro_card="+LibroCard;
        pstmt=conn.prepareStatement(query);
        pstmt.setString(1, nome);
        pstmt.setString(2, cognome);
        pstmt.setString(3, indirizzo);
        pstmt.setInt(4, cap);
        pstmt.setString(5, citta);
        pstmt.setString(6, telefono);
        pstmt.setString(7, email);
        pstmt.setString(8, password);
        pstmt.execute();
        name=nome;
        surname=cognome;
        address=indirizzo;
        CAP=cap;
        city=citta;
        phone_number=telefono;
        this.email=email;
        this.password=password;
    }
}
