package com.kinobooking.secure.service;

import com.kinobooking.secure.dao.CinemaDao;
import com.kinobooking.secure.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Екатерина on 24.08.2017.
 */
@Service
public class SeansDetailsService {
    @Autowired
    private FilmDao filmDao;
    @Autowired
    private CinemaDao cinemaDao;


    public List<String> loadFilmNames(){
        return filmDao.getFilmNames();
    }

    public List<String> loadCinemaNames(){
        return cinemaDao.getCinemaNames();
    }
}
