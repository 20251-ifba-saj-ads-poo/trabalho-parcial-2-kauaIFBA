/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txPassword;

    @FXML
    private TextField txCpf;

    @FXML
    void login(ActionEvent event) {
        String user = txCpf.getText();
        String password = txPassword.getText();

        Member currentUser = Dados.membersList.stream()
                .filter(m -> m.getCpf().equals(user) && m.getPassword().equals(password))
                .findFirst() // procura o usuário inserido em txCpf e txPassword na lista lá em dados
                .orElse(null); // se não achar ele é nulo

        // se ele for nulo, significa que o usuário ou senha estão errados
        if (currentUser != null) {
            Dados.setCurrentUser(currentUser);

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
