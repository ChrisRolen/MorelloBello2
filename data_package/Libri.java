package data_package;
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
	private String author;
	private String editor;
	private int year;
	private int ISBN;
	private String genre;
	private float price;
	private String description;
	private int numberofsoldcopies;
	private int numberofpoints;
	private Statement stmt;
        private ResultSet rs;
        
	public static ArrayList<Libri> carrello = new ArrayList<Libri>();
	
	public Libri(int ISBN) throws SQLException{
		rs = stmt.executeQuery("SELECT * from libri WHERE ISBN =" + ISBN);
		
		while(rs.next()){
			
		this.title = rs.getString("titolo");	
		this.author = rs.getString("autori");
		this.editor = rs.getString("casa_editrice");
		this.year = rs.getInt("anno_pubblicazione");
		this.ISBN = ISBN;
		this.genre = rs.getString("genere");
		this.price = rs.getFloat("prezzo");
		this.description = rs.getString("descrizione");
		this.numberofsoldcopies = rs.getInt("copie_vendute");
		this.numberofpoints = rs.getInt("punti_card");
		
		}
		
	}
	public String getAuthor(){
		return this.author;
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
	
	public String getGenre(){
		return this.genre;
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
	
	public void modify(Utenti admin, int choice, Object modif) throws SQLException{
	
	if(admin.isheanadmin(admin.getEmail(), admin.getPassword())){
		switch(choice){
		case 1:
			
			if(modif instanceof String[])
				this.author = (String) modif;
			break;
			
		case 2:
			if(modif instanceof String)
				this.editor = (String) modif;
			break;
			
		case 3:
			if(modif instanceof Integer)
				this.year = (int) modif;
			break;
			
		case 4:
			if(modif instanceof Integer)
				this.ISBN= (int) modif;
			break;
			
		case 5:
			if(modif instanceof String)
				this.genre = (String) modif;
			break;
			
		case 6:
			if(modif instanceof Integer)
				this.price = (int) modif;
			break;
			
		case 7:
			if(modif instanceof String)
				this.description = (String) modif;
			break;
		
		default:
			throw new NoMemberToModifyException("Il membro selezionato non esiste! Selezionare un numero da 1 a 7");
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
	
	public static void  new_book(Utenti utente,String title, String author, String editor,int year, int ISBN,String genre,float price, String description,int numberofsoldcopies, int numberofpoints) throws SQLException{
		//Libri.carrello;
		
		if(utente.isheanadmin(utente.getEmail(), utente.getPassword())){
                    Connection conn =database.connection();
                    PreparedStatement pstmt;
                    Statement stmt2=conn.createStatement();
                    ResultSet rs2;
		String query = " insert into ordine (titolo, autore, casa_editrice, anno_pubblicazione, ISBN, genere, prezzo, descrizione, punti_card, copie_vendute)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, title);
		pstmt.setString(2, author);
		pstmt.setString(3, editor);
		pstmt.setInt(5, year);
		pstmt.setInt(6, ISBN);
		pstmt.setString(7, genre);
		pstmt.setFloat(8, price);
		pstmt.setString(9,description);
		pstmt.setInt(10, numberofpoints);
		pstmt.setInt(11, numberofsoldcopies);
		pstmt.execute();
                
                
                String autori[]=author.split(",");
                
                for(int i=0;i<autori.length;i++){
                    rs2=stmt2.executeQuery("SELECT codice FROM autori WHERE nome="+autori[i]);
                    if(rs2.next()==true){
                        add_author(ISBN,rs2.getInt("codice"),conn);
                    }
                    else{
                        Autori.new_author(autori[i]);
                        rs2=stmt2.executeQuery("SELECT codice FROM autori WHERE nome="+autori[i]);
                        add_author(ISBN,rs2.getInt("codice"),conn);
                    }
                }
            
		}
		
	}
        
        public static void add_author(int ISBN,int codice,Connection conn) throws SQLException{
            String query2="insert into autori_libri(ISBN,codice) values (?,?)";
            PreparedStatement pstmt;
            pstmt=conn.prepareStatement(query2);
            pstmt.setInt(1, ISBN);
            pstmt.setInt(2,codice);
            pstmt.execute();
        }

	
}

