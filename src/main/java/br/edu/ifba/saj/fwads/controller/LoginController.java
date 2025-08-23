/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Member;
import br.edu.ifba.saj.fwads.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class LoginController {

    @FXML // fx:id="txPassword"
    private PasswordField txPassword; // Value injected by FXMLLoader

    @FXML // fx:id="txCpf"
    private TextField txCpf; // Value injected by FXMLLoader

    @FXML
    void login(ActionEvent event) {
        String user = txCpf.getText();
        String password = txPassword.getText();

        /*
        boolean autenticado = Dados.membersList.stream()
                .anyMatch(m -> m.getCpf().equals(user) && m.getPassword().equals(password));
         */

        // TODO - REMOVER ISSO AQUI OK >:3
        boolean autenticado = true;

        if (autenticado) {
            new Alert(Alert.AlertType.INFORMATION, "Usuário e senha corretos").showAndWait();
            App.setRoot("controller/Menu.fxml");
        } else {
            new Alert(Alert.AlertType.ERROR, "Usuário ou senha inválidos").show();
        }
    }

    @FXML
    void newAccount(ActionEvent event) {
        App.setRoot("controller/RegisterMember.fxml");
    }
}
