package com.miha.footballManager.controller;
import com.miha.footballManager.entity.Club;
import com.miha.footballManager.entity.Footballer;
import com.miha.footballManager.exception.CustomFirstCaseException;
import com.miha.footballManager.services.ClubService;
import com.miha.footballManager.services.FootballersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubsController {
    @Autowired
    private ClubService clubService;

    @RequestMapping("/clubs")
    public List<Club> getClubs(){
        return clubService.getClubs();
    }
    @RequestMapping("/clubs/{id}")
    public Club getClub(@PathVariable int id){
        return clubService.getClub(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/clubs")
    public void addClub(@RequestBody @Valid Club club) throws CustomFirstCaseException {
        clubService.addClub(club);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/clubs/{id}")
    public void updateClub(@RequestBody @Valid Club club,@PathVariable int id) throws CustomFirstCaseException {
        clubService.updateClub(club,id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/clubs/{id}")
    public void deleteClub(@PathVariable int id){
        clubService.deleteClub(id);
    }
}
