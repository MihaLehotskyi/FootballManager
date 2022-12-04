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
public class FootballersService {
    @Autowired
    private FootballerRepository footballerRepository;

    @Autowired
    private ClubRepository clubRepository;

    public List<Footballer> getFootballers(){
        List<Footballer> list = new ArrayList<Footballer>();
        for(Footballer footballer: footballerRepository.findAll()){
            list.add(footballer);
        }
        return list;
    }
    public Footballer getFootballer(int id) {
        return footballerRepository.findById(id).get();
    }
    public void addFootballer(Footballer footballer) throws CustomFirstCaseException {
        for(Footballer f: footballerRepository.findAll()){
            if(footballer.getId() != f.getId()){
                if(footballer.getClub().equals(f.getClub())) {
                    footballerRepository.save(footballer);
                }else {
                    throw new CustomFirstCaseException("Неможна міняти поля клубу в цьому запиті. Для цього є інший запит!");
                }
            }else {
                throw new CustomFirstCaseException("Футболіст з таким id вже існує!");
            }
        }

    }
    public void updateFootballer(Footballer footballer,int id) throws CustomFirstCaseException {
        Footballer footballer1 = footballerRepository.findById(id).get();
        if(footballer.getId() == footballer1.getId()){
            if(footballer.getClub().equals(footballer1.getClub())){
                footballerRepository.save(footballer);
            }else throw new CustomFirstCaseException("Неможна міняти поля клубу в цьому запиті. Для цього є інший запит!");
        }else throw new CustomFirstCaseException("Неможна змінювати id!");
    }
    public void deleteFootballer(int id){
        footballerRepository.deleteById(id);
    }
    public void changeClub(int fid,int cid) throws CustomFirstCaseException {
        Footballer footballer = footballerRepository.findById(fid).get();
        Club c = footballer.getClub();
        Club c1 = clubRepository.findById(cid).get();
        if(c.getId() == c1.getId()){
            throw new CustomFirstCaseException("Неможливо зробити трансфер гравця в команду в якій він грає зараз!");
        }
        int val = footballer.getExperience() * 100000/footballer.getAge();
        int com = val * c.getComission()/100;
        int sum = val + com;
        int newbal = c1.getBallance() - sum;
        if(newbal > 0){
            footballer.setClub(c1);
            c1.setBallance(newbal);
            c.setBallance(c.getBallance() + sum);
            footballerRepository.save(footballer);
            clubRepository.save(c);
            clubRepository.save(c1);
        }else{
            throw new CustomFirstCaseException("Неможливо зробити трансфер, бо в команди не вистачає грошей на викуп!");
        }
    }
}

