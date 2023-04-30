package com.portfolio.Franco.Repository;

import com.portfolio.Franco.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepoHys extends JpaRepository<Hys, Integer>{
    Optional<Hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
