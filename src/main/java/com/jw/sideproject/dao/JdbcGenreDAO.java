package com.jw.sideproject.dao;

import com.jw.sideproject.model.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDAO implements GenreDAO {
    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ResponseEntity<List<Genre>> getGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre ORDER BY genre_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            genres.add(new Genre(
                    results.getLong("genre_id"),
                    results.getString("genre_name")
            ));
        }
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
