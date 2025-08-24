package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifba.saj.fwads.Dados;

public class SubscribedMeetingsController implements Initializable {

    @FXML
    private ListView<Meeting> lvSubMeetings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvSubMeetings.setCellFactory(param -> new ListCell<Meeting>() {
            @Override
            protected void updateItem(Meeting meeting, boolean empty) {
                super.updateItem(meeting, empty);
                if (empty || meeting == null || meeting.getBook() == null) {
                    setText(null);
                } else {
                    setText(meeting.getBook().getTitle() + " - " + meeting.getDateAndTime());
                }
            }
        });
        Member currentUser = Dados.getCurrentUser();
        ObservableList<Meeting> userMeetings = FXCollections.observableArrayList(currentUser.getAttendedMeetings());
        lvSubMeetings.setItems(userMeetings);
    }
}
/*
ANTIGO
    @FXML
    private ListView<Meeting> lvSubMeetings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Member currentUser = Dados.getCurrentUser();
        lvSubMeetings.setItems(FXCollections.observableArrayList(currentUser.getAttendedMeetings()));
    }
 */
