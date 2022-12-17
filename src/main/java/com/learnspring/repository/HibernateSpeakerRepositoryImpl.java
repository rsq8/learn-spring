package com.learnspring.repository;

import com.learnspring.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar cal;

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

        out.format("cal: %s%n", cal.getTime());

        speakers.add(first);
        speakers.add(second);
        speakers.add(third);

        return speakers;
    }
}
