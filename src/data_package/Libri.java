package MorelloBello2.src.data_package;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Libri {
	private String title;

 
	private ArrayList<String> author=new ArrayList<String>();
	private String editor;
	private int year;
	private int ISBN;
	private ArrayList<String> genre=new ArrayList<String>();
	private float price;
	private String description;
	private int numberofsoldcopies;
	private int numberofpoints;
        private boolean disponibile;
        private Connection conn =database.connection();
        private static PreparedStatement pstmt;
	private Statement stmt;
        private ResultSet rs;
        
        
	public static ArrayList<Libri> carrello = new ArrayList<Libri>();
	
	public Libri(int ISBN) throws SQLException{
		rs = stmt.executeQuery("SELECT * from libri WHERE ISBN =" + ISBN);
		
		while(rs.next()){
			
		this.title = rs.getString("titolo");	
		
		this.editor = rs.getString("casa_editrice");
		this.year = rs.getInt("anno_pubblicazione");
		this.ISBN = ISBN;
		
		this.price = rs.getFloat("prezzo");
		this.description = rs.getString("descrizione");
		this.numberofsoldcopies = rs.getInt("copie_vendute");
		this.numberofpoints = rs.getInt("punti_card");
		this.disponibile=rs.getBoolean("disponibile");
		}
                rs=stmt.executeQuery("select nome from autori_libri,autori where autori.codice=autori_libri.codice and ISBN="+ISBN);
                
                while(rs.next()){
                    author.add(rs.getString("nome"));
                }
                
                rs=stmt.executeQuery("select nome from generi,genere_libro where codice=id and ISBN="+ISBN);
                while(rs.next()){
                    genre.add(rs.getString("nome"));
                }
                
		
	}

    public boolean isDisponibile() {
        return disponibile;
    }
        
        
        
        public String getTitle() {
            return title;
        }

	
	public String getEditor(){
		return this.editor;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getISBN(){
		return this.ISBN;
	}
	

	
	public float getPrice(){
		return this.price;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getNumberofpoints() {
		return numberofpoints;
	}
	
        
            public ArrayList<String> getAuthor() {
        return author;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }
    
	public void modify(String ISBN,String titolo,String editore,String anno,String prezzo,String descrizione,String punti,String copie_vendute,String autori,String generi,boolean disponibile) throws SQLException{
            String query="update libri set titolo=?, casa_editrice=?,anno_pubblicazione=?,prezzo=?,descrizione=?,punti_card=?,copie_venndute=?,disponibile=? where ISBN="+ISBN;
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1, titolo);
            pstmt.setString(2, editore);
            pstmt.setInt(3, Integer.getInteger(anno));
            pstmt.setInt(4, Integer.getInteger(prezzo));
            pstmt.setString(5, descrizione);
            pstmt.setInt(6, Integer.getInteger(punti));
            pstmt.setInt(7,Integer.getInteger(copie_vendute));
            pstmt.setBoolean(8, disponibile);
            pstmt.execute();
            
            query="delete from autori_libri where ISBN="+ISBN;
            pstmt=conn.prepareStatement(query);
            pstmt.execute();
            
            String autorilist[]=autori.split(",");
            String generilist[]=generi.split(",");
            for(int i=0;i<autorilist.length;i++){
                query="select codice from autori where nome="+autorilist[i];
                rs=stmt.executeQuery(query);
                if(rs.next()){
                    add_author(ISBN,rs.getInt("codice"),conn);
                }
                else{
                    Autori.new_author(autorilist[i], conn);
                    rs=stmt.executeQuery(query);
                    add_author(ISBN,rs.getInt("codice"),conn);
                }
            }
            for(int i=0;i<generilist.length;i++){
                query="select id from generi where nome="+generilist[i];
                rs=stmt.executeQuery(query);
                if(rs.next()){
                    add_genre(ISBN,rs.getInt("id"),conn);
                }
                else{
                    Genere.new_genre(generilist[i], conn);
                    rs=stmt.executeQuery(query);
                    add_genre(ISBN,rs.getInt("id"),conn);
                }
            }
            
            
            
        }


	
	public int getNumberofsoldcopies() {
		return numberofsoldcopies;
	}

	public ArrayList<Libri> classify(Libri... libris){
		ArrayList<Libri> classifica = new ArrayList<Libri>();
		
		for(Libri a:libris){
			classifica.add(a);
		}
		
		classifica.sort(new Comparator<Libri>(){

			@Override
			public int compare(Libri arg0, Libri arg1) {
				return arg0.getNumberofsoldcopies()- arg1.getNumberofsoldcopies();
			}
			
		});
		
		return classifica;
	}
	
	public ArrayList<Libri> classify() throws SQLException{
		ArrayList<Libri> classifica = new ArrayList<Libri>();
		rs = stmt.executeQuery("SELECT * from libri");
		
		while(rs.next()){
			Libri book = new Libri(rs.getInt("IBSN"));
			classifica.add(book);
		}
		
		classifica.sort(new Comparator<Libri>(){

			@Override
			public int compare(Libri arg0, Libri arg1) {
				return arg0.getNumberofsoldcopies()- arg1.getNumberofsoldcopies();
			}
			
		});
		
		return classifica;
	}
	
	public static void  new_book(Utenti utente,String title, String author, String editor,int year, String ISBN,String genre,float price, String description,int numberofsoldcopies, int numberofpoints) throws SQLException{
		//Libri.carrello;
		
		if(utente.isAdmin()){
                    Connection conn =database.connection();
		String query = " insert into libri (titolo, casa_editrice, anno_pubblicazione, ISBN, prezzo, descrizione, punti_card, copie_vendute)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, title);
		
		pstmt.setString(2, editor);
		pstmt.setInt(3, year);
		pstmt.setString(4, ISBN);
		
		pstmt.setFloat(5, price);
		pstmt.setString(6,description);
		pstmt.setInt(7, numberofpoints);
		pstmt.setInt(8, numberofsoldcopies);
		pstmt.execute();
                System.out.print("prova libro");
                String autori[]=author.split(",");
                ResultSet rs2;
                Statement stmt2=conn.createStatement();
                
                for(int i=0;i<autori.length;i++){
                    String query2="SELECT codice from autori where nome='"+autori[i]+"'";
                    rs2=stmt2.executeQuery(query2);
                    if(rs2.next()){
                        add_author(ISBN,rs2.getInt("codice"),conn);
                    }
                    else{
                        Autori.new_author(autori[i], conn);
                        rs2=stmt2.executeQuery(query2);
                        rs2.next();
                        add_author(ISBN,rs2.getInt("codice"),conn);
                    }
                }
                
                String genere[]=genre.split(",");
                for(int i=0;i<genere.length;i++){
                    String query2="SELECT id from generi where nome='"+genere[i]+"'";
                    rs2=stmt2.executeQuery(query2);
                    if(rs2.next()){
                        add_genre(ISBN,rs2.getInt("id"),conn);
                    }
                    else{
                        Genere.new_genre(genere[i], conn);
                        rs2=stmt2.executeQuery(query2);
                        rs2.next();
                        add_genre(ISBN,rs2.getInt("id"),conn);
                    }
                }
		}
		
	}
        
    public static void add_author(String ISBN,int codice,Connection conn) throws SQLException{
        String query="insert into autori_libri(ISBN,codice) values (?,?)";
        PreparedStatement pstmt2=conn.prepareStatement(query);
        pstmt2.setString(1,ISBN);
        pstmt2.setInt(2, codice);
        pstmt2.execute();
    }
        public static void add_genre(String ISBN,int codice,Connection conn) throws SQLException{
        String query="insert into genere_libro(ISBN,genere) values (?,?)";
        PreparedStatement pstmt2=conn.prepareStatement(query);
        pstmt2.setString(1,ISBN);
        pstmt2.setInt(2, codice);
        pstmt2.execute();
    }
        public void change_author(int codice) throws SQLException{
            String query="update autori_libri set codice=? where ISBN="+ISBN;
            pstmt=conn.prepareStatement(query);
            pstmt.setInt(1, codice);
            pstmt.execute();
        }
	
}

