/**
 * Controller da tela de Login (Login.fxml)
 *
 * Valida se as credenciais inseridas (CPF e senha) batem com algum membro cadastrado.
 * Redireciona à tela de Menu.
 * Redireciona à tela de Cadastro.
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
                .findFirst() // currentUser será preenchido com as credenciais inseridas caso encontre algum membro existente.
                .orElse(null); // caso não, ele será null.

        // se NÃO for for nulo, significa que o usuário e senha estão corretos.
        if (currentUser != null) {
            Dados.setCurrentUser(currentUser);

            new Alert(Alert.AlertType.INFORMATION, "Usuário e senha corretos").showAndWait();
            App.setRoot("controller/Menu.fxml");
        } else { // se for nulo, já sabe
            new Alert(Alert.AlertType.ERROR, "Usuário ou senha inválidos").show();
        }
    }

    @FXML
    void newAccount(ActionEvent event) {
        App.setRoot("controller/RegisterMember.fxml");
    }
}
