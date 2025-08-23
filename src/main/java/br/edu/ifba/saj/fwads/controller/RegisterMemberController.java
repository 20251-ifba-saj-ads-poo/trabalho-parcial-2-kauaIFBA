package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;

public class RegisterMemberController {

    @FXML
    private TextField txName;

    @FXML
    private TextField txCpf;

    @FXML
    private PasswordField txPassword;

    @FXML
    private void saveNewMember(ActionEvent event) {
        Member newMember = new Member(txName.getText(),txCpf.getText(), txPassword.getText());
        new Alert(Alert.AlertType.INFORMATION,
                "Cadastrando Membro:"+newMember.getName()).showAndWait();
        Dados.membersList.add(newMember);
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        txName.setText("");
        txCpf.setText("");
        txPassword.setText("");
        App.setRoot("controller/Login.fxml");
    }
}
