package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.Dados;
import br.edu.ifba.saj.fwads.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.util.converter.IntegerStringConverter;
import java.util.function.UnaryOperator;

public class RegisterBookController {
    @FXML
    private TextField txTitle;
    @FXML
    private TextField txAuthor;
    @FXML
    private TextField txGenre;
    @FXML
    private TextField txPublisher;
    @FXML
    private TextField txPublicationYear;
    @FXML
    private TextField txSynopsis;

    @FXML
    private void initialize() {

    }

    @FXML
    void saveBook(ActionEvent event) {
        if (txTitle.getText().isEmpty() || txAuthor.getText().isEmpty() || txGenre.getText().isEmpty() || txPublisher.getText().isEmpty() ||  txPublicationYear.getText().isEmpty() || txSynopsis.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Para registrar, preencha todos os campos").show();
        } else {
            int publicationYear = Integer.parseInt(txPublicationYear.getText());
            // Book(String title, String author, String genre, String synopsis, String publisher, int publicationYear)
            Book newBook = new Book(txTitle.getText(),
                    txAuthor.getText(),
                    txGenre.getText(),
                    txSynopsis.getText(),
                    txPublisher.getText(),
                    publicationYear);
            new Alert(Alert.AlertType.INFORMATION,
                    "Cadastrando Livro:"+newBook.getTitle()).showAndWait();
            Dados.booksList.add(newBook);
        }
        clearScreen();
    }

    @FXML
    private void clearScreen() {
        txTitle.setText("");
        txAuthor.setText("");
        txGenre.setText("");
        txPublisher.setText("");
        txPublicationYear.setText("");
        txSynopsis.setText("");
    }
}
/*
    @FXML
    private TextField txTitulo;
    @FXML
    private TextField txSubTitulo;
    @FXML
    private TextField txISBN;
    @FXML
    private ChoiceBox<Autor> slAutor;

    @FXML
    void salvarLivro(ActionEvent event) {
        Book novoLivro = new Book(txTitulo.getText(),
                    txSubTitulo.getText(),
                    txISBN.getText(),
                    slAutor.getSelectionModel().getSelectedItem());
        new Alert(AlertType.INFORMATION,
        "Cadastrando Livro(Fake):"+novoLivro.toString()).showAndWait();
        limparTela();


    }

    @FXML
    private void initialize() {
        slAutor.setConverter(new StringConverter<Autor>() {
            @Override
            public String toString(Autor obj) {
                if (obj != null) {
                    return obj.getNome() + ":" + obj.getEmail();
                }
                return "";
            }

            @Override
            public Autor fromString(String stringAutor) {
                return Biblioteca.listaAutores
                    .stream()
                    .filter(autor -> stringAutor.equals(autor.getNome() + ":" + autor.getEmail()))
                    .findAny()
                    .orElse(null);
            }
        });

        carregarListaAutores();
    }

    @FXML
    private void limparTela() {
        txTitulo.setText("");
        txSubTitulo.setText("");
        txISBN.setText("");
        //Todo REVER, rever oque dog?
        slAutor.setSelectionModel(null);
    }

    private void carregarListaAutores() {
        slAutor.setItems(Biblioteca.listaAutores);
    }

 */