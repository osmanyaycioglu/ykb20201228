package com.training.ykb.rest;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.ykb.validation.StartWith;
import com.training.ykb.validation.TCKNCheck;


@Entity
@Table(name = "kisi")
@TCKNCheck(message = "TCKN failed")
public class Person {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long      pid;
    @NotEmpty
    @Size(min = 2, max = 25, message = "name 2 ile 25 arasında olmalı")
    @StartWith("is")
    private String    name;
    @NotEmpty
    @Size(min = 3, max = 30, message = "surname 3 ile 30 arasında olmalı")
    private String    surname;
    @Min(value = 50, message = "boy 50cm den küçük olamaz")
    @Max(value = 250, message = "boy 250cm den büyük olamaz")
    private int       height;
    @Past
    private LocalDate birthday;
    private String    tckn;
    private ENational national = ENational.TC;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final LocalDate birthdayParam) {
        this.birthday = birthdayParam;
    }


    @Override
    public String toString() {
        return "Person [pid="
               + this.pid
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", birthday="
               + this.birthday
               + ", tckn="
               + this.tckn
               + ", national="
               + this.national
               + "]";
    }

    public Long getPid() {
        return this.pid;
    }

    public void setPid(final Long pidParam) {
        this.pid = pidParam;
    }


    public String getTckn() {
        return this.tckn;
    }


    public void setTckn(final String tcknParam) {
        this.tckn = tcknParam;
    }


    public ENational getNational() {
        return this.national;
    }


    public void setNational(final ENational nationalParam) {
        this.national = nationalParam;
    }


}
