package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.Book;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dados {
    public static ObservableList<Book> booksList = FXCollections.observableArrayList();
    public static ObservableList<Member> membersList = FXCollections.observableArrayList();
    public static ObservableList<Meeting> meetingsList = FXCollections.observableArrayList();

    // Conceito de usuário atual, logado no sistema
    private static Member currentUser;

    public static void setCurrentUser(Member user) {
        currentUser = user;
    }

    public static Member getCurrentUser() {
        return currentUser;
    }

    static{
        //listaAutores.add(new Autor("Jose","jose@seila.com","123.456.789.-11"));
    }
}
