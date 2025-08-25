/**
 * Controller da tela de Encontros no qual o atual usuário está Inscrito (SubscribedMeetings.fxml)
 *
 * Carrega lista de encontros inscritos (currentUser.subscribedMeetings).
 */

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
            protected void updateItem(Meeting meeting, boolean empty) { // Preenche o ListView com dados.
                super.updateItem(meeting, empty);
                if (empty || meeting == null || meeting.getBook() == null) {
                    setText(null);
                } else {
                    setText("Livro: " + meeting.getBook().getTitle() + " Irá ocorrer em: " + meeting.getDateAndTime());
                }
            }
        });
        Member currentUser = Dados.getCurrentUser();
        ObservableList<Meeting> userMeetings = FXCollections.observableArrayList(currentUser.getAttendedMeetings()); // Preciso de alguma forma para evitar este tipo de conversão.
        lvSubMeetings.setItems(userMeetings);
    }
}
