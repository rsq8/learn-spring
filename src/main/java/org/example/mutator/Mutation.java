package org.example.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.example.exceptions.SessionNotFoundExceptionGQL;
import org.example.models.Session;
import org.example.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private SessionRepository sessionRepository;

    public Session newSession(String name, int length, String description) {
        Session session = new Session();
        session.setSession_name(name);
        session.setSession_description(description);
        session.setSession_length(length);
        sessionRepository.saveAndFlush(session);
        return session;
    }

    public Boolean deleteSession(long id) {
        boolean deleted = false;
        Optional<Session> optionalSession = sessionRepository.findById(id);

        if (optionalSession.isPresent()){
            sessionRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

    public Session updateSessionName(String name, long id) {
        Optional<Session> optionalSession = sessionRepository.findById(id);

        if (optionalSession.isPresent()){
            Session currentSession = sessionRepository.getOne(id);
            Session session = new Session();
            String[] ignoreProperties = {
                    "session_id",
                    "session_description",
                    "session_length",
                    "speakers"};
            session.setSession_name(name);
            BeanUtils.copyProperties(session, currentSession, ignoreProperties);
            return sessionRepository.saveAndFlush(currentSession);
        } else {
            throw new SessionNotFoundExceptionGQL("The session does not Exist", id);
        }
    }
}
