package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import br.edu.ifba.saj.fwads.Dados;
import javafx.util.StringConverter;

public class OpenMeetingsController {

    @FXML
    private ChoiceBox<Meeting> slOpenMeetings;

    @FXML
    private void initialize() {
        slOpenMeetings.setConverter(new StringConverter<Meeting>() {
            @Override
            public String toString(Meeting obj) {
                if (obj != null) {
                    return "Encontro do livro: " + obj.getBook().toString() + "\nirá ocorrer em: " + obj.getDateAndTime().toString();
                }
                return "";
            }

            @Override
            public Meeting fromString(String stringMeeting) {
                return Dados.meetingsList
                        .stream()
                        .filter(autor -> stringMeeting.equals(autor.toString()))
                        .findAny()
                        .orElse(null);
            }
        });

        loadMeetingsList();
    }

    @FXML
    public void subscribe(ActionEvent actionEvent) {
        Member currentUser = Dados.getCurrentUser();
        currentUser.addAttendedMeeting(slOpenMeetings.getValue());

        Meeting subscribedMeeting = slOpenMeetings.getValue();
        subscribedMeeting.addSubscribedMember(currentUser);
    }

    private void loadMeetingsList() {
        slOpenMeetings.setItems(Dados.meetingsList);
    }
}

/*
ANTIGO
    @FXML
    private ListView<Meeting> lvOpenMeetings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lvOpenMeetings.setItems(Dados.meetingsList);
        lvOpenMeetings.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void subscribe(ActionEvent actionEvent) {
        Member currentUser = Dados.getCurrentUser();
        currentUser.setSubscribedMeetings(lvOpenMeetings.getSelectionModel().getSelectedItems());
    }
 */
