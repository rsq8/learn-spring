package com.learnspring.service;

import com.learnspring.model.Speaker;
import com.learnspring.repository.HibernateSpeakerRepositoryImpl;
import com.learnspring.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {
    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker>  findAll() {
        return repository.findAll();
    }
}
