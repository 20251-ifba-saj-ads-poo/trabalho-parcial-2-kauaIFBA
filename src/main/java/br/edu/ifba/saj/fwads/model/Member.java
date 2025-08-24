package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member extends AbstractModel<UUID>{
    private String name;
    private String cpf; // Usado no login
    private String password;
    private List<Meeting> attendedMeetings; // Encontros que participou
    private List<Meeting> subscribedMeetings; // Encontros que está inscrito
    private List<Meeting> myMeetings;

    public Member(String name, String cpf, String password) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.attendedMeetings = new ArrayList<>(); // Vazio
        this.subscribedMeetings = new ArrayList<>(); // Vazio
        this.myMeetings = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getCpf() { return cpf; }
    public String getPassword() { return password; }
    public List<Meeting> getAttendedMeetings() { return attendedMeetings; }
    public List<Meeting> getSubscribedMeetings() { return subscribedMeetings; }
    public List<Meeting> getMyMeetings() { return myMeetings; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setPassword(String password) { this.password = password; }
    public void setAttendedMeetings(List<Meeting> attendedMeetings) { this.attendedMeetings = attendedMeetings; }
    public void setSubscribedMeetings(List<Meeting> subscribedMeetings) { this.subscribedMeetings = subscribedMeetings; }
    public void setMyMeetings(List<Meeting> myMeetings) {this.myMeetings = myMeetings;}

    public void addAttendedMeeting(Meeting meeting) {
        if (meeting != null && !attendedMeetings.contains(meeting)) {
            attendedMeetings.add(meeting);
        }
    }

    public void addUserMeeting(Meeting meeting) {
        if (meeting != null && !myMeetings.contains(meeting)) {
            myMeetings.add(meeting);
        }
    }

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
