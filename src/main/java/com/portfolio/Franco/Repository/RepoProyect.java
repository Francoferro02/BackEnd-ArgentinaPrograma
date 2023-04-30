
package com.portfolio.Franco.Repository;

import com.portfolio.Franco.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepoProyect extends JpaRepository<Proyect,Integer>{
    Optional<Proyect> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
