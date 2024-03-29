package com.jy.movie.repository;

import com.jy.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    public Actor findByActorId(Long actorId);



}
