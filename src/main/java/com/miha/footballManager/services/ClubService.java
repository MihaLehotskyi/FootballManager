package com.miha.footballManager.services;

import com.miha.footballManager.entity.Club;
import com.miha.footballManager.entity.Footballer;
import com.miha.footballManager.exception.CustomFirstCaseException;
import com.miha.footballManager.repository.ClubRepository;
import com.miha.footballManager.repository.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getClubs(){
        List<Club> list = new ArrayList<Club>();
        for(Club club: clubRepository.findAll()){
            list.add(club);
        }
        return list;
    }
    public Club getClub(int id){
        return clubRepository.findById(id).get();
    }
    public void addClub(Club club) throws CustomFirstCaseException {
        for(Club c: clubRepository.findAll()){
            if(club.getId() != c.getId()){
                clubRepository.save(club);
            }else {
                throw new CustomFirstCaseException("Клуб з таким id вже існує!");
            }
        }
    }
    public void updateClub(Club club,int id) throws CustomFirstCaseException {
        Club club1 = clubRepository.findById(id).get();
        if(club.getId() == club1.getId()){
            clubRepository.save(club);
        }else throw new CustomFirstCaseException("Неможна змінювати id!");
    }
    public void deleteClub(int id){
        clubRepository.deleteById(id);
    }
}

