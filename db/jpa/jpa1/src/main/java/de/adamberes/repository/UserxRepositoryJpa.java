package de.adamberes.repository;

import de.adamberes.entities.Userx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserxRepositoryJpa extends CrudRepository<Userx, Long> {

    List<Userx> findAll();
    Userx save(Userx userx);
}
