/**
 * Controller da tela de Agendar Encontro (RegisterMeeting.fxml)
 *
 * Carrega lista de livros do sistema.
 * Adiciona um novo encontro à lista de encontros (declarada em Dados).
 */

package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Book;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
                    return "Livro: " + obj.getTitle() + ", Editora:" + obj.getPublisher();
                }
                return "";
            }

            @Override
            public Book fromString(String stringBook) {
                return Dados.booksList
                        .stream()
                        .filter(autor -> stringBook.equals(autor.getTitle() + ":" + autor.getPublisher()))
                        .findAny()
                        .orElse(null);
            }
        });

        loadBooksList();
    }

    @FXML
    private void saveMeeting(ActionEvent event) {
        Member host = Dados.getCurrentUser();

        if (slBook.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Nenhum livro selecionado.");
            alert.showAndWait();
            return;
        }

        if (dpDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Nenhuma data selecionada.");
            alert.showAndWait();
            return;
        }

        Meeting novoMeeting = new Meeting(dpDate.getValue(),
                slBook.getSelectionModel().getSelectedItem(),
                host);
        new Alert(Alert.AlertType.INFORMATION,
                "Criando novo Encontro").showAndWait();
        Dados.meetingsList.add(novoMeeting);
        host.addUserMeeting(novoMeeting);
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        dpDate.setValue(null);
        //Todo REVER
        slBook.setSelectionModel(null);
    }

    private void loadBooksList() {
        slBook.setItems(Dados.booksList);
    }
}