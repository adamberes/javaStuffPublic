package de.adamberes.repository;

import de.adamberes.entities.Userx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserxRepositoryJpa extends JpaRepository<Userx, Long> {

    List<Userx> findAll();
    Userx saveAndFlush(Userx userx);
}
