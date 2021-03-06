package com.ff.welcome.controller;


import com.ff.welcome.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/welcome")
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{sortid}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody List<Word> get(@PathVariable String sortid) {
        String sql = "select * from word order by sortid asc";
        RowMapper<Word> rowMapper=new BeanPropertyRowMapper<Word>(Word.class);
        List<Word> wordList = jdbcTemplate.query(sql, rowMapper);
        return wordList;
    }
}
