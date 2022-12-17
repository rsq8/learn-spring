package com.learnspring.service;

import com.learnspring.model.Speaker;
import com.learnspring.repository.HibernateSpeakerRepositoryImpl;
import com.learnspring.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.System.out;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository;

    public SpeakerServiceImpl (){
        out.println("SpeakerServiceImpl no args constructor");
    }

    public SpeakerServiceImpl (SpeakerRepository sRepository){
        out.println("SpeakerServiceImpl repository constructor");
        repository = sRepository;
    }

    @Override
    public List<Speaker>  findAll() {
        return repository.findAll();
    }

    @Autowired
    public void setRepository(SpeakerRepository repository) {
        out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
