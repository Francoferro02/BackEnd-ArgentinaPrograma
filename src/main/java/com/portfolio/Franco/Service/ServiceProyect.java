package com.portfolio.Franco.Service;

import com.portfolio.Franco.Entity.Proyect;
import com.portfolio.Franco.Repository.RepoProyect;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ServiceProyect {
    @Autowired
    RepoProyect repoProyect;
    
    public List<Proyect> list(){
        return repoProyect.findAll();
    }
    
    public Optional<Proyect> getOne(int id){
        return repoProyect.findById(id);
    }
    
    public Optional<Proyect> getByNombre(String nombre){
        return repoProyect.findByNombre(nombre);
    }
    
    public void save(Proyect proyecto){
        repoProyect.save(proyecto);
    }
    
    public void delete(int id){
        repoProyect.deleteById(id);
    }
    
    public boolean existsById(int id){
        return repoProyect.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return repoProyect.existsByNombre(nombre);
    }
}
