package bibliotech.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bibliotech.project.model.Model;
import bibliotech.project.repository.Repository;

@RestController
@RequestMapping("/bibliotech")
public class Controller {


    @Autowired
    private Repository repository;
    
   
    @GetMapping
    public List<Model> getAllModels() {
        return repository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable("id") long id) {
        Optional<Model> model = repository.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public ResponseEntity<Model> createModel(@RequestBody Model model) {
        Model savedModel = repository.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModel);
    }


    // Método DELETE - Deletar um item pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable("id") long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

    


