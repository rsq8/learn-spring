package org.example.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.example.models.Session;
import org.example.repositories.SessionRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private SessionRepository sessionRepository;

    public Iterable<Session> findAllSessions() {
        return sessionRepository.findAll();
    }

    public long countSessions() {
        return sessionRepository.count();
    }
}
