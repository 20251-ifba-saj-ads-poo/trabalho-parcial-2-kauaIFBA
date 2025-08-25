/**
 * Controller da tela de Encontros em Aberto (OpenMeetings.fxml)
 *
 * Carrega lista de encontros.
 * Permite que o atual usuário se inscreva no encontro escolhido (no choicebox).
 */

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
        currentUser.addAttendedMeeting(slOpenMeetings.getValue()); // Adiciona o encontro no Membro como "Encontros em que está inscritos".

        Meeting subscribedMeeting = slOpenMeetings.getValue();
        subscribedMeeting.addSubscribedMember(currentUser); // Adiciona o membro no encontro como "Membros inscritos".
    }

    private void loadMeetingsList() {
        slOpenMeetings.setItems(Dados.meetingsList);
    }
}
