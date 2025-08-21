package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

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
        Meeting novoMeeting = new Meeting(dpDateAndTime.getValue(),
            //book
            //host
        new Alert(Alert.AlertType.INFORMATION,
                "Criando novo Encontro").showAndWait();
        Dados.listaMeetings.add(novoMeeting);
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        //todo escrever isso aqui
    }
}