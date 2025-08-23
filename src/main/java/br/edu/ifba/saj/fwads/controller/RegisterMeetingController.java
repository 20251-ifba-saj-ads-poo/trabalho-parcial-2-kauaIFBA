package br.edu.ifba.saj.fwads.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class RegisterMeetingController {
    @FXML
    private DatePicker dpDateAndTime;
    // Talvez ao inves de escolher o livro, ele te joga pro formulário de cadastro de livro, ou deixa as duas opções

    /*
    @FXML
    private void saveMeeting(ActionEvent event) {
        Meeting novoMeeting = new Meeting(dpDateAndTime.getValue(),
            //book
            //host
        new Alert(Alert.AlertType.INFORMATION,
                "Criando novo Encontro").showAndWait();
        Dados.meetingsList.add(novoMeeting);
        clearScreen();
    }
*/
    @FXML
    private void clearScreen() {
        //todo escrever isso aqui
    }
}