package com.learnspring.repository;

import com.learnspring.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
