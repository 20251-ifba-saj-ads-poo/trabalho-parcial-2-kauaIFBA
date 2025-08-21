package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Book;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dados {
    public static ObservableList<Book> listaBooks = FXCollections.observableArrayList();
    public static ObservableList<Member> listaMembers = FXCollections.observableArrayList();
    public static ObservableList<Meeting> listaMeetings = FXCollections.observableArrayList();
    
    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }
}
