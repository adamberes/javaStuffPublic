package jpah2.repository;

import jpah2.entities.Wetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryJpa extends JpaRepository<Wetter, Long> {

    List<Wetter> findAll();
}
