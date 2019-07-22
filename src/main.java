package MorelloBello2.src;

import MorelloBello2.src.data_package.Libri;
import MorelloBello2.src.data_package.Utenti;
import MorelloBello2.src.gui_package.main_page;
import java.sql.SQLException;


public class main {

	public static void main(String[] args) throws SQLException {
			//Interfaccia principale
			// Classifica al centro 
			// In alto a destra login
			// In alto in centro barra di ricerca
			// Alla Amazon
                        main_page mai=new main_page();
                        mai.setVisible(true);
                        String title="prova1";
                        String author="Luca,Marco,Giovanni";
                        String editor="prova 1";
                        String ISBN="1849388482938444";
                        String genre="fantasia,comico,fantascienza";
                        String description="viv vi vi ";
                        String email="cibermatteo98@gmail.com";
                        String password="cibermatteo98";
                        String name="matteo";
                        String surname="gennari";
                        String address="mantegna";
                        String city="povegliano";
                        
                        Utenti utente=new Utenti(email,password);
                        System.out.print("risultato 1");
                        Libri.new_book(utente, title, author, editor, 4, ISBN, genre, 55, description, 6, 34);
                        System.out.print("prova 2");
	}

}
