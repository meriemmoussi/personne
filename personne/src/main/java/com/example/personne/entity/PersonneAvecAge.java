package com.example.personne.entity;
public class PersonneAvecAge {
    private Personne personne;
    private int age;

    public PersonneAvecAge(Personne personne, int age) {
        this.personne = personne;
        this.age = age;
    }

    public String getNom() {
        return personne.getNom();
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

