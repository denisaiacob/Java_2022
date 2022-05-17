package com.example.rest.SocialNetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialNetwork")
public class SocialNetworkController {
    private SocialNetworkRepository socialNetworkRepository;

    @Autowired
    public SocialNetworkController(SocialNetworkRepository socialNetworkRepository){
        this.socialNetworkRepository = socialNetworkRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        return ResponseEntity.ok(socialNetworkRepository.findAll());
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){ socialNetworkRepository.save(person); }

    @PutMapping("/{name}")
    public void updatePerson(@PathVariable("name") String name, @RequestBody Person person) throws NotFoundException {
        var foundPerson = socialNetworkRepository.findByName(name);
        if(foundPerson.isEmpty()){
            throw new NotFoundException("Person not found", "Invalid data", HttpStatus.NOT_FOUND);
        }
        foundPerson.get().update(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id")  Long id){
        socialNetworkRepository.deleteById(id);
    }

}

