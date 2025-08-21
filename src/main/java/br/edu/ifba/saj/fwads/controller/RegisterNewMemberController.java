package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Biblioteca;
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
    private TextField txPassword;

    @FXML
    private void saveNewMember() {
        Member newMember = new Member(txName.getText(),txCpf.getText(), txPassword.getText());
        new Alert(Alert.AlertType.INFORMATION,
                "Cadastrando Autor:"+newMember.getName()).showAndWait();
        Biblioteca.listaAutores.add(newMember);
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        txName.setText("");
        txCpf.setText("");
        txPassword.setText("");
    }
}
