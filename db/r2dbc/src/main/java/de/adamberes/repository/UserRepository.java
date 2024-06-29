package de.adamberes.repository;

import de.adamberes.entities.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends R2dbcRepository<Users, Long> {

    Flux<Users> findAll();
}
