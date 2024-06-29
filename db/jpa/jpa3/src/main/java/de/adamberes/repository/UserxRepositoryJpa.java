package de.jpah2.repository;

import de.jpah2.entities.Userx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserxRepositoryJpa extends JpaRepository<Userx, Long> {

    List<Userx> findAll();
}
