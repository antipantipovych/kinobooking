package com.kinobooking.secure.entity;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Екатерина on 14.08.2017.
 */

@Entity
@Table(name="cinema")
public class Cinema {
    @Id
    @Column( name="cinema_id", unique = true, nullable = false)
    @GeneratedValue
    private int cinemaId;
    @Column(name="name", nullable = false, length = 30)
    private String name;
    @Column(name="location", length = 30)
    private String location;
    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls;
    @OneToMany(mappedBy = "cinema")
    private Set<Seans> seanses;
    @OneToMany(mappedBy = "cinema")
    private Set<Ticket> tickets;
    @OneToMany(mappedBy = "cinema")
    private Set<FilmCinema> FCTables;

    public Cinema() {
    }

    public Cinema(int cinemaId, String name, String location) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.location = location;
    }

    public Cinema(int cinemaId, String name, String location, Set<Hall> halls, Set<Seans> seanses, Set<Ticket> tickets, Set<FilmCinema> FCTables) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.location = location;
        this.halls = halls;
        this.seanses = seanses;
        this.tickets = tickets;
        this.FCTables = FCTables;
    }

    public Set<FilmCinema> getFCTables() {
        return FCTables;
    }

    public void setFCTables(Set<FilmCinema> FCTables) {
        this.FCTables = FCTables;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Seans> getSeanses() {
        return seanses;
    }

    public void setSeanses(Set<Seans> seanses) {
        this.seanses = seanses;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public int getCinemaId() {

        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
       this.location = location;
    }

}
