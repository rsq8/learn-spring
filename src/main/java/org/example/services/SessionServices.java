package org.example.services;

import org.example.models.Session;
import org.example.repositories.SessionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SessionServices {
    Session get(Long id);

    List<Session> list();

    Session addSession(Session session);

    void deleteSession(Long id);

    Session updateSession(Long id, Session session);
}
