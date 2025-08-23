package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class RegisterNewMemberController {
    @FXML
    private TextField txName;
    @FXML
    private TextField txCpf;
    @FXML
    private PasswordField txPassword;
/*
    @FXML
    private void saveNewMember() {
        Member newMember = new Member(txName.getText(),txCpf.getText(), txPassword.getText());
        new Alert(Alert.AlertType.INFORMATION,
                "Cadastrando Autor:"+newMember.getName()).showAndWait();
        Dados.listaMembers.add(newMember);
        clearScreen();
    }

 */

    @FXML
    private void clearScreen() {
        txName.setText("");
        txCpf.setText("");
        txPassword.setText("");
    }
}
