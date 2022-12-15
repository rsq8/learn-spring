package com.learnspring.repository;

import com.learnspring.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker first = new Speaker();
        Speaker second = new Speaker();
        Speaker third = new Speaker();

        first.setFirstName("Yusuf");
        first.setLastName("Dauda");

        second.setFirstName("Aliaa");
        second.setLastName("Dauda");

        third.setFirstName("Zainab");
        third.setLastName("Dauda");

        speakers.add(first);
        speakers.add(second);
        speakers.add(third);

        return speakers;
    }
}
