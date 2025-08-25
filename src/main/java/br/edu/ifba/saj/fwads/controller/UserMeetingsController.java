/**
 * Controller da tela de Encontros em que o atual usuário é host (UserMeetings.fxml)
 *
 * Atualmente esta tela é problemática, ela serve para visualizar dados do encontro, editar e adicionar minuta e participantes.
 */

package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Book;
import br.edu.ifba.saj.fwads.model.Meeting;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class UserMeetingsController implements Initializable {
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
    @FXML
    private Button btEdit;

    @FXML
    private Label lbSubs;
    @FXML
    private ListView<Member> lvMembers;
    @FXML
    private Button btMinutes;

    Member currentUser = Dados.getCurrentUser();
    ObservableList<Meeting> observable = FXCollections.observableArrayList(currentUser.getMyMeetings());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Só aparecem caso tenha alguma opção selecionada no ChoiceBox de encontros
        dpDate.setVisible(false);
        slBook.setVisible(false);
        btSave.setVisible(false);
        btCancel.setVisible(false);
        lbDate.setVisible(false);
        lbSubs.setVisible(false);
        lbBook.setVisible(false);
        lvMembers.setVisible(false);
        btMinutes.setVisible(false);
        btEdit.setVisible(false);

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

        // preenche ListView dos membros inscritos.
        lvMembers.setCellFactory(param -> new ListCell<Member>() {
            @Override
            protected void updateItem(Member member, boolean empty) {
                super.updateItem(member, empty);
                if (empty || member == null) {
                    setText(null);
                } else {
                    setText(member.getName());
                }
            }
        });

        // Só aparecem caso tenha alguma opção selecionada no ChoiceBox de encontros
        slUserMeetings.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                slBook.setValue(newValue.getBook());
                dpDate.setValue(newValue.getDateAndTime());

                lbDate.setVisible(true);
                lbSubs.setVisible(true);
                lbBook.setVisible(true);
                lvMembers.setVisible(true);
                btMinutes.setVisible(true);
                btEdit.setVisible(true);
                dpDate.setVisible(true);
                slBook.setVisible(true);
                btSave.setVisible(true);
                btCancel.setVisible(true);

                Meeting selectedMeeting = slUserMeetings.getValue();
                ObservableList<Member> subscribedMembers = FXCollections.observableArrayList(selectedMeeting.getSubscribedMembers());
                lvMembers.setItems(subscribedMembers);

            } else {
                lbDate.setVisible(false);
                lbSubs.setVisible(false);
                lbBook.setVisible(false);
                lvMembers.setVisible(false);
                btMinutes.setVisible(false);
                btEdit.setVisible(false);
                dpDate.setVisible(false);
                slBook.setVisible(false);
                btSave.setVisible(false);
                btCancel.setVisible(false);
                slBook.setValue(null);
                dpDate.setValue(null);
                lvMembers.setItems(null);
            }
        });
    }

    @FXML
    void editMeeting(ActionEvent actionEvent) {
        // Esconde as opções de edição, até que seja selecionado botão de edição e tenha um encontro selecionado.
        if (slUserMeetings.getValue()!=null) {
            slBook.setValue(slUserMeetings.getValue().getBook());
            dpDate.setValue(slUserMeetings.getValue().getDateAndTime());
            dpDate.setVisible(true);
            slBook.setVisible(true);
            btSave.setVisible(true);
            btCancel.setVisible(true);
        } else {
            dpDate.setVisible(false);
            slBook.setVisible(false);
            btSave.setVisible(false);
            btCancel.setVisible(false);
        }
    }

    @FXML
    private void saveMeeting(ActionEvent event) {
        // Atualiza o encontro
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
        slBook.setSelectionModel(null);
    }

    private void loadMyMeetingsList() {
        slUserMeetings.setItems(observable);
    }

    private void loadBooksList() {
        slBook.setItems(Dados.booksList);
    }
}