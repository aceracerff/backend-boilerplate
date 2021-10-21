package com.jw.sideproject.dao;

import com.jw.sideproject.model.Genre;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreDAO {
    ResponseEntity<List<Genre>> getGenres();
}
