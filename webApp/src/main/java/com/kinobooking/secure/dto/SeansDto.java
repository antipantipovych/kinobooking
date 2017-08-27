package com.kinobooking.secure.dto;

import java.util.Date;

/**
 * Created by Екатерина on 24.08.2017.
 */
public class SeansDto {

    private String filmName;
    private String cinemaName;
    private Date seansDate;

    public Date getSeansDate() {
        return seansDate;
    }

    public void setSeansDate(Date seansDate) {
        this.seansDate = seansDate;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
