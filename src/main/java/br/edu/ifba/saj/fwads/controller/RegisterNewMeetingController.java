package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

import java.awt.print.Book;

public class RegisterNewMeetingController {
    @FXML
    private DatePicker dpDateAndTime;
    // Talvez ao inves de escolher o livro, ele te joga pro formulário de cadastro de livro, ou deixa as duas opções

    @FXML
    void assignNewBook(ActionEvent event) {
        // limparBotoes(event.getSource());
        showFXMLFile("RegisterBook.fxml");
    }

    @FXML
    private void saveMeeting(ActionEvent event) {
        Meeting novoAutor = new Meeting(dpDateAndTime.getValue(),
            //book
            //host
        new Alert(Alert.AlertType.INFORMATION,
                "Criando novo Encontro").showAndWait();
        Biblioteca.listaAutores.add(novoAutor);
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        //todo escrever isso aqui
    }
}