package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.util.List;

public class UserMeetingsController {
    @FXML
    private ChoiceBox<Meeting> slUserMeetings;

    Member currentUser = Dados.getCurrentUser();
    ObservableList<Meeting> observable = FXCollections.observableArrayList(currentUser.getMyMeetings());

    @FXML
    private void initialize() {
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
    }

    private void loadMyMeetingsList() {
        slUserMeetings.setItems(observable);
    }

}
