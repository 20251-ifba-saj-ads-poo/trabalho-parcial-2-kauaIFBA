package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Book;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.List;

public class UserMeetingsController {
    @FXML
    private ChoiceBox<Meeting> slUserMeetings;

    @FXML
    private Button btSave;
    @FXML
    private Button btCancel;
    @FXML
    private DatePicker dpDate;
    @FXML
    private ChoiceBox<Book> slBook;
    @FXML
    private Label lbDate;
    @FXML
    private Label lbBook;

    Member currentUser = Dados.getCurrentUser();
    ObservableList<Meeting> observable = FXCollections.observableArrayList(currentUser.getMyMeetings());

    @FXML
    private void initialize() {
        dpDate.setVisible(false);
        slBook.setVisible(false);
        btSave.setVisible(false);
        btCancel.setVisible(false);
        lbBook.setVisible(false);
        lbDate.setVisible(false);

        slUserMeetings.setConverter(new StringConverter<Meeting>() {
            @Override
            public String toString(Meeting obj) {
                if (obj != null) {
                    return "Encontro do livro: " + obj.getBook().toString() + "\nirá ocorrer em: " + obj.getDateAndTime().toString();
                }
                return "";
            }

            @Override
            public Meeting fromString(String stringMeeting) {

                return observable
                        .stream()
                        .filter(autor -> stringMeeting.equals(autor.toString()))
                        .findAny()
                        .orElse(null);
            }
        });

        loadMyMeetingsList();

        slBook.setConverter(new StringConverter<Book>() {
            @Override
            public String toString(Book obj) {
                if (obj != null) {
                    return obj.getTitle() + ":" + obj.getPublisher();
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
    void editMeeting(ActionEvent actionEvent) {
        // isso aqui está escrito da forma mais burra possível, desculpe
        if(slUserMeetings.getValue()!=null) {
            dpDate.setVisible(true);
            slBook.setVisible(true);
            btSave.setVisible(true);
            btCancel.setVisible(true);
            lbBook.setVisible(true);
            lbDate.setVisible(true);
        }
    }

    @FXML
    void cancelMeeting(ActionEvent actionEvent) {
    }

    @FXML
    private void saveMeeting(ActionEvent event) {
        Meeting selectedMeeting = slUserMeetings.getValue();

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

        selectedMeeting.setBook(slBook.getValue());
        selectedMeeting.setDateAndTime(dpDate.getValue());

        clearScreen();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Encontro atualizado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void clearScreen() {
        dpDate.setValue(null);
        //Todo REVER
        slBook.setSelectionModel(null);
    }

    private void loadMyMeetingsList() {
        slUserMeetings.setItems(observable);
    }

    private void loadBooksList() {
        slBook.setItems(Dados.booksList);
    }

}
