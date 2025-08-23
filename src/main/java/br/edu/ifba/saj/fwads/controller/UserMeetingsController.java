package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.ifba.saj.fwads.Dados;
import javafx.scene.control.SelectionMode;

public class UserMeetingsController implements Initializable{

    @FXML
    private ListView lvUserMeetings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvUserMeetings.setItems(Dados.meetingsList);
    }
}
