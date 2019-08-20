package com.example.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
//import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//@XSlf4j
@Slf4j
@RestController
public class TestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from bloguser";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                    log.debug(key+":"+value);
                }
            }
        }
        return list;
    }
//    @RequestMapping("/showUser/{id}")
//    public String selectUser (@PathVariable int id, Model model){
//        model.addAttribute("name", jdbcTemplate.selectUser(id).toString());
//        return "greets";
//
//    }
}