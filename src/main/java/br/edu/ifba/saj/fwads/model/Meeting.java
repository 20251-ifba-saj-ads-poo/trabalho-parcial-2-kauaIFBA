package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Meeting extends AbstractModel<UUID>{
    private LocalDate date;
    private Book book;
    private List<Member> subscribedMembers;
    private List<Member> attendedMembers;
    private Member host;
    private String minutes;

    public Meeting(LocalDate date, Book book, Member host) {
        this.date = date;
        this.book = book;
        this.host = host;

        this.subscribedMembers = new ArrayList<>();
        this.attendedMembers = new ArrayList<>();

        this.minutes = "";
    }

    // Getters
    public LocalDate getDateAndTime() { return date; }
    public Book getBook() { return book; }
    public List<Member> getSubscribedMembers() { return subscribedMembers; }
    public List<Member> getAttendedMembers() { return attendedMembers; }
    public Member getHost() { return host; }
    public String getMinutes() { return minutes; }

    // Setters
    public void setDateAndTime(LocalDate date) { this.date = date; }
    public void setBook(Book book) { this.book = book; }
    public void setSubscribedMembers(List<Member> subscribedMembers) { this.subscribedMembers = subscribedMembers; }
    public void setAttendedMembers(List<Member> attendedMembers) { this.attendedMembers = attendedMembers; }
    public void setHost(Member host) { this.host = host; }
    public void setMinutes(String minutes) {this.minutes = minutes; }

    @Override
    public String toString() {
        return "Meeting{" +
                "date=" + date +
                ", book=" + book +
                ", subscribedMembers=" + subscribedMembers +
                ", attendedMembers=" + attendedMembers +
                ", host=" + host +
                ", minutes='" + minutes + '\'' +
                '}';
    }
}
