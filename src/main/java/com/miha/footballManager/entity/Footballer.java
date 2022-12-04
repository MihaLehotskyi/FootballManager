package com.miha.footballManager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="footballers")
public class Footballer {
    @Id
    int id;
    String name;

    int experience;
    @Min(18)
    @Max(60)
    int age;

    @ManyToOne
    @JoinColumn(name="club_id",nullable = false)
    private Club club;

    public Footballer(int id, String name, int experience, int age, Club club) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.age = age;
        this.club = club;
    }

    public Footballer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

