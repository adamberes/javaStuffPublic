package r2dbc_h2mem.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import r2dbc_h2mem.entities.Wetter;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends R2dbcRepository<Wetter, Long> {

    Flux<Wetter> findAll();
}
