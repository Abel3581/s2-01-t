package fiados.com.controller;


import fiados.com.models.request.CategoryRequest;
import fiados.com.models.response.CategoryResponse;
import fiados.com.service.abstraction.CategoryService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import javassist.NotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCategory(
            @RequestBody CategoryRequest category)
            throws URISyntaxException, NotFoundException {       
            ResponseEntity<?> response = service.addCategory(category);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());       
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, 
             @RequestBody CategoryRequest entity) 
            throws URISyntaxException, NotFoundException{       
            ResponseEntity<?> response = service.update(id,entity);
            return new ResponseEntity<>(response.getBody(), response.getStatusCode());       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws EntityNotFoundException, NotFoundException {       
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   
    }

 
}
