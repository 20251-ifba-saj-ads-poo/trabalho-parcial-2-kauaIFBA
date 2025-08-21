package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member extends AbstractModel<UUID>{
    private String name;
    private int cpf; // Usado no login
    private String password;
    private List<Meeting> attendedMeetings; // Encontros que participou
    private List<Meeting> subscribedMeetings; // Encontros que está inscrito

    Member(String name, int cpf, String login, String password) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.attendedMeetings = new ArrayList<>(); // Vazio
        this.subscribedMeetings = new ArrayList<>(); // Vazio
    }

    // Getters
    public String getName() { return name; }
    public int getCpf() { return cpf; }
    public String getPassword() { return password; }
    public List<Meeting> getAttendedMeetings() { return attendedMeetings; }
    public List<Meeting> getSubscribedMeetings() { return subscribedMeetings; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setCpf(int cpf) { this.cpf = cpf; }
    public void setPassword(String password) { this.password = password; }
    public void setAttendedMeetings(List<Meeting> attendedMeetings) { this.attendedMeetings = attendedMeetings; }
    public void setSubscribedMeetings(List<Meeting> subscribedMeetings) { this.subscribedMeetings = subscribedMeetings; }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                ", password='" + password + '\'' +
                ", attendedMeetings=" + attendedMeetings +
                ", subscribedMeetings=" + subscribedMeetings +
                '}';
    }
}
