package com.miha.footballManager.controller;

import com.miha.footballManager.entity.Footballer;
import com.miha.footballManager.exception.CustomFirstCaseException;
import com.miha.footballManager.services.FootballersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FootballersController {
    @Autowired
    private FootballersService footballersService;

    @RequestMapping("/footballers")
    public List<Footballer> getFootballers(){
        return footballersService.getFootballers();
    }
    @RequestMapping("/footballers/{id}")
    public Footballer getFootballer(@PathVariable int id){
        return footballersService.getFootballer(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/footballers")
    public void addFootballer(@RequestBody @Valid Footballer footballer) throws CustomFirstCaseException {
        footballersService.addFootballer(footballer);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/footballers/{id}")
    public void updateFootballer(@RequestBody @Valid Footballer footballer,@PathVariable int id) throws CustomFirstCaseException {
        footballersService.updateFootballer(footballer,id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/footballers/{id}")
    public void deleteFootballer(@PathVariable int id){
        footballersService.deleteFootballer(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/footballers/{id}/{id1}")
    public void changeFootballer(@PathVariable int id, @PathVariable int id1)throws CustomFirstCaseException{
        footballersService.changeClub(id,id1);
    }
}
