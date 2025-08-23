package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Meeting;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;
import br.edu.ifba.saj.fwads.Dados;

public class OpenMeetingsController implements Initializable {

    @FXML
    private ListView lvOpenMeetings;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvOpenMeetings.setItems(Dados.meetingsList);
    }
}
