package com.portfolio.Franco.Controller;

import com.portfolio.Franco.Dto.dtoProyect;
import com.portfolio.Franco.Entity.Proyect;
import com.portfolio.Franco.Security.Controller.Mensaje;
import com.portfolio.Franco.Service.ServiceProyect;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyect")
@CrossOrigin(origins = {"https://frontendfranco.web.app", "http://localhost:4200"})
public class ProyectController {

    @Autowired
    ServiceProyect serviceProyect;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = serviceProyect.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable("id") int id) {
        if (!serviceProyect.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyect proyect = serviceProyect.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceProyect.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        serviceProyect.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyect dtoproyect) {
        if (StringUtils.isBlank(dtoproyect.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (serviceProyect.existsByNombre(dtoproyect.getNombre())) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyect proyect = new Proyect(dtoproyect.getNombre(), dtoproyect.getDescripcion(), dtoproyect.getImg());
        serviceProyect.save(proyect);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyect dtoproyect) {
        //Existe el ID?
        if (!serviceProyect.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara los nombres del proyecto
        if (serviceProyect.existsByNombre(dtoproyect.getNombre()) && serviceProyect.getByNombre(dtoproyect.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya fue agregado anteriormente"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoproyect.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyect proyect = serviceProyect.getOne(id).get();
        proyect.setNombre(dtoproyect.getNombre());
        proyect.setDescripcion((dtoproyect.getDescripcion()));
        proyect.setImg(dtoproyect.getImg());

        serviceProyect.save(proyect);
        return new ResponseEntity(new Mensaje("Tu proyecto fue actualizada"), HttpStatus.OK);

    }
}
