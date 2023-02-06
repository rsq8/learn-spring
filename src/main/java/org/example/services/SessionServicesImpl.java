package org.example.services;

import org.example.exceptions.SessionNotFoundException;
import org.example.models.Session;
import org.example.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SessionServicesImpl implements SessionServices{

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public Session get(Long id){
        Optional<Session> optionalSession = sessionRepository.findById(id);

        if (optionalSession.isPresent()){
            return optionalSession.get();
        } else {
            throw new SessionNotFoundException("The session does not Exist");
        }
    }

    public List<Session> list(){
        return sessionRepository.findAll();
    }

    public Session addSession(Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    public void deleteSession(Long id) {
        //Add check for child records before delete
        sessionRepository.deleteById(id);
    }

    public Session updateSession(Long id, Session session) {
        //put or patch may be used. put replaces all, patch replaces parts.
        Session currentSession = sessionRepository.getOne(id);
        //TODO: Add validation that all properties are passed in, otherwise return a 400 bad payload error
        BeanUtils.copyProperties(session, currentSession, "session_id");
        return sessionRepository.saveAndFlush(currentSession);
    }
}
