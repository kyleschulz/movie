package org.aim.movie.actor;

import org.springframework.data.repository.CrudRepository;

import org.aim.movie.actor.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}