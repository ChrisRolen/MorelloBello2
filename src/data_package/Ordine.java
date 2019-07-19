package data_package;

import java.sql.Date;
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

public class Ordine {
	private int codice;
	private Date data_ordine;
	private int libro_card;
	private String nome;
	private String cognome;
	private String indirizzo;
	private int CAP;
	private String telefono;
	private String email;
	private int costo_totale;
	private String tipo_pagamento;
	private int punti_libro;
	private boolean status;
	private ResultSet rs;
    private PreparedStatement pstmt;
    private Connection conn=database.connection();
    private Statement stmt=conn.createStatement();
	
	
	public Ordine(int codice) throws SQLException {
		rs = stmt.executeQuery("SELECT * from ordine WHERE codice=" + codice);
		
		while(rs.next()){
			this.codice = codice;
			this.data_ordine = rs.getDate("data_ordine");
			this.libro_card = rs.getInt("utente");
			CAP = rs.getInt("CAP");
			this.nome = rs.getString("nome");
			this.cognome = rs.getString("cognome");
			this.email = rs.getString("email");
			this.indirizzo = rs.getString("indirizzo");
			this.telefono= rs.getString("telefono");
			this.costo_totale = rs.getInt("costo_totale");
			this.tipo_pagamento = rs.getString("tipo_pagamento");
			this.punti_libro = rs.getInt("punti_libro");
			this.status = rs.getBoolean("status");
			}
			
		}


	public int getCodice() {
		return codice;
	}



	public void setCodice(int codice) {
		this.codice = codice;
	}



	public Date getData_ordine() {
		return data_ordine;
	}



	public void setData_ordine(Date data_ordine) {
		this.data_ordine = data_ordine;
	}



	public int getLibro_card() {
		return libro_card;
	}



	public void setLibro_card(int libro_card) {
		this.libro_card = libro_card;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getIndirizzo() {
		return indirizzo;
	}



	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}



	public int getCAP() {
		return CAP;
	}



	public void setCAP(int cAP) {
		CAP = cAP;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getCosto_totale() {
		return costo_totale;
	}



	public void setCosto_totale(int costo_totale) {
		this.costo_totale = costo_totale;
	}



	public String getTipo_pagamento() {
		return tipo_pagamento;
	}



	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}



	public int getPunti_libro() {
		return punti_libro;
	}



	public void setPunti_libro(int punti_libro) {
		this.punti_libro = punti_libro;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(Utenti utente, boolean status) throws SQLException {
		if(utente.isheanadmin(getEmail(), utente.getPassword())){
			this.status = status;
		}
	}
	
	
	
}


