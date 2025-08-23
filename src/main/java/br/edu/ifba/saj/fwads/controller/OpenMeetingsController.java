package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifba.saj.fwads.Dados;
import javafx.scene.control.SelectionMode;

public class OpenMeetingsController implements Initializable {

    @FXML
    private ListView<Meeting> lvOpenMeetings; // 🔹 Agora tipado

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvOpenMeetings.setItems(Dados.meetingsList);
        lvOpenMeetings.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void subscribe(ActionEvent actionEvent) {
        Member currentUser = Dados.getCurrentUser();
        for (Meeting meeting : lvOpenMeetings.getSelectionModel().getSelectedItems()) {
            if (!currentUser.getSubscribedMeetings().contains(meeting)) {
                currentUser.getSubscribedMeetings().add(meeting);
            }
        }
    }
}
