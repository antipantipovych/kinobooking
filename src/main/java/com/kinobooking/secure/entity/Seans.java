package com.kinobooking.secure.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Екатерина on 15.08.2017.
 */
@Entity
@Table(name="seans")
public class Seans {
    @Id
    @Column( name="seans_id", unique = true, nullable = false)
    @GeneratedValue
    private int seansId;
    @Column(name="seans_date", nullable = false)
    private Date seansDate;
    @Column(name="seans_time", nullable = false)
    @Type(type="timestamp")
    private Date seansTime;
    @Column(name="avail_seats", nullable = false)
    private int seatsAvail;
    @Column(name="3D_seans", nullable = false)
    private int seans_3D;
    @ManyToOne
    @JoinColumn(name="film_id", nullable = false)
    private Film film;
    @ManyToOne
    @JoinColumn(name="hall_id", nullable = false)
    private Hall hall;
    @ManyToOne
    @JoinColumn(name="cinema_id", nullable = false)
    private Cinema cinema;
    @OneToMany(mappedBy = "seans")
    private Set<Ticket> tickets;

    public Seans() {
    }

    public Seans(int seansId, Date seansDate, Date seansTime, int seatsAvail, int seans_3D) {
        this.seansId = seansId;
        this.seansDate = seansDate;
        this.seansTime = seansTime;
        this.seatsAvail = seatsAvail;
        this.seans_3D = seans_3D;
    }

    public Seans(Set<Ticket> tickets, Hall hall, Film film, int seans_3D, int seatsAvail, Date seansTime, Date seansDate, int seansId, Cinema cinema) {
        this.tickets = tickets;
        this.hall = hall;
        this.film = film;
        this.seans_3D = seans_3D;
        this.seatsAvail = seatsAvail;
        this.seansTime = seansTime;
        this.seansDate = seansDate;
        this.seansId = seansId;
        this.cinema = cinema;
    }

    public int getSeansId() {
        return seansId;
    }

    public void setSeansId(int seansId) {
        this.seansId = seansId;
    }

    public Date getSeansDate() {
        return seansDate;
    }

    public void setSeansDate(Date seansDate) {
        this.seansDate = seansDate;
    }

    public Date getSeansTime() {
        return seansTime;
    }

    public void setSeansTime(Date seansTime) {
        this.seansTime = seansTime;
    }

    public int getSeatsAvail() {
        return seatsAvail;
    }

    public void setSeatsAvail(int seatsAvail) {
        this.seatsAvail = seatsAvail;
    }

    public int getSeans_3D() {
        return seans_3D;
    }

    public void setSeans_3D(int seans_3D) {
        this.seans_3D = seans_3D;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
