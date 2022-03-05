package com.solarlab.project.dto;

import com.solarlab.project.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDto {
    private static int PEOPLE_ID;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_ID, "Tom"));
        people.add(new Person(++PEOPLE_ID, "Jack"));
        people.add(new Person(++PEOPLE_ID, "Michael"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person ->
                person.getId() == id).findAny().orElse(null);
    }
}
