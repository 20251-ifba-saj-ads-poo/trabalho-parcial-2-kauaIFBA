package br.edu.ifba.saj.fwads.model;

import java.util.UUID;

public class Book extends AbstractModel<UUID> {
    private String title;
    private String author;
    private String genre;
    private String synopsis;
    private String publisher;
    private int publicationYear;

    public Book(String title, String author, String genre, String synopsis, String publisher, int publicationYear){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.synopsis = synopsis;
        this.publisher = publisher;
        this.publicationYear = publicationYear;

    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getSynopsis() { return synopsis; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
