package com.pvt.pojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meeting")
public class Meeting {

    private Integer id;
    private String subject;
    private Set<Employee> employees;

    public Meeting() {
        employees = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer meetingId) {
        this.id = meetingId;
    }

    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @ManyToMany(mappedBy = "meetings")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + id +
                ", subject='" + subject + '\'' +
                '}';
    }
}
