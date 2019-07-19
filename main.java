
import gui_package.insert_book;
import gui_package.main_page;


public class main {

	public static void main(String[] args){
			//Interfaccia principale
			// Classifica al centro 
			// In alto a destra login
			// In alto in centro barra di ricerca
			// Alla Amazon
                        main_page prova=new main_page();
                        prova.setVisible(true);
                        insert_book book=new insert_book();
                        prova.getContentPane().removeAll();
                        prova.getContentPane().add(book);
                        prova.validate();
                        book.setVisible(true);
        
        }

}
