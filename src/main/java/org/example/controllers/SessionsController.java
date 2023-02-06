package org.example.controllers;

import org.example.exceptions.SessionNotFoundException;
import org.example.models.Session;
import org.example.services.SessionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionsController {
    @Autowired
    private SessionServices sessionServices;

    @GetMapping
    public ResponseEntity<List<Session>> list(){
        return new ResponseEntity<List<Session>>(sessionServices.list(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Session> get(@PathVariable Long id){
        try{
            return new ResponseEntity<Session>(sessionServices.get(id), HttpStatus.OK);
        } catch (SessionNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The session does not Exist");
        }
        //return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return sessionServices.addSession(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionServices.deleteSession(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return sessionServices.updateSession(id,session);
    }
}
