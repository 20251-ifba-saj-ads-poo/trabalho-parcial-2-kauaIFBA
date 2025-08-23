package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public class RegisterMeetingController {
    @FXML
    private DatePicker dpDate;

    @FXML
    private ChoiceBox<Book> slBook;

    @FXML
    private void initialize() {
        slBook.setConverter(new StringConverter<Book>() {
            @Override
            public String toString(Book obj) {
                if (obj != null) {
                    return obj.getTitle() + ":" + obj.getPublisher();
                }
                return "";
            }

            @Override
            public Book fromString(String stringAutor) {
                return Dados.booksList
                        .stream()
                        .filter(autor -> stringAutor.equals(autor.getTitle() + ":" + autor.getPublisher()))
                        .findAny()
                        .orElse(null);
            }
        });

        loadBooksList();
    }

    /*
    @FXML
    private void createMeeting(ActionEvent event) {
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

    private void loadBooksList() {
        slBook.setItems(Dados.booksList);
    }
}