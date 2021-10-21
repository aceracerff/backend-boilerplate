package com.jw.sideproject.controller;

import com.jw.sideproject.dao.JdbcGenreDAO;
import com.jw.sideproject.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class GenreController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/api/genres")
    public ResponseEntity<List<Genre>> getGenres() {
        JdbcGenreDAO jdbcGenreDAO = new JdbcGenreDAO(dataSource);
        return jdbcGenreDAO.getGenres();
    }
}
