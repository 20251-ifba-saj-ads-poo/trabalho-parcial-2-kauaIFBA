package br.edu.ifba.saj.fwads.model;

public class Book extends AbstractModel<> {
    private String title;
    private String author;
    private String genre;
    private String synopsis;
    private String publisher;
    private int publicationYear;

    Book(String title, String author, String genre, String synopsis, String publisher, int publicationYear){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.synopsis = synopsis;
        this.publisher = publisher;
        this.publicationYear = publicationYear;

    }

    // Métodos getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Métodos setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

}
