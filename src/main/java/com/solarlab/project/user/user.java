package com.solarlab.project.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class user {
    private Long id;
    private String name;
    private String email;
    private int ads;
    private int age;

    public user(
            Long id,
            String name,
            String email,
            int ads,
            int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ads = ads;
        this.age = age;
    }

    public user(String name,
                String email,
                int ads,
                int age) {
        this.name = name;
        this.email = email;
        this.ads = ads;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAds() {
        return ads;
    }

    public void setAds(int ads) {
        this.ads = ads;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", ads=" + ads +
                ", age=" + age +
                '}';
    }
}
