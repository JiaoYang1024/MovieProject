package com.jy.movie.service;

import com.jy.movie.entity.Actor;
import com.jy.movie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ActorService {


    @Autowired
    ActorRepository actorRepository;


    public void checkActorId(Actor actor) {



        if(actorRepository.findByActorId(actor.getActorId())==null) {

            actorRepository.save(actor);
        }
    }
}
