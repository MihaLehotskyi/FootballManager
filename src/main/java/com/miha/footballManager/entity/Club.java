package com.miha.footballManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    int id;
    String name;
    @Min(1)
    @Max(10)
    int comission;

    int ballance;

    public Club(int id, String name, int comission, int ballance) {
        this.id = id;
        this.name = name;
        this.comission = comission;
        this.ballance = ballance;
    }

    public Club() {
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

    public int getComission() {
        return comission;
    }

    public void setComission(int comission) {
        this.comission = comission;
    }

    public int getBallance() {
        return ballance;
    }

    public void setBallance(int ballance) {
        this.ballance = ballance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Club club)) return false;
        return getId() == club.getId() && getComission() == club.getComission() && getBallance() == club.getBallance() && Objects.equals(getName(), club.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getComission(), getBallance());
    }
}

