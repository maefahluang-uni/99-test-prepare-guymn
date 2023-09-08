package lab.end2end.concert.services;

import java.util.List;
import java.util.Optional;

import lab.end2end.concert.domain.Concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/concerts")
public class ConcertController {

    private static Logger LOGGER = LoggerFactory.getLogger(ConcertController.class);

    // TODO: add repository
    @Autowired
    private ConcertRepository concertRepository;

    // TODO: add @GET and @Path
    @GetMapping("/{id}")
    public ResponseEntity<Concert> retrieveConcert(@PathVariable Long id) { // TODO: add @PathVariable for id

        // TODO: find concert by ID suing em.find(...
        Optional<Concert> optConcert = concertRepository.findById(id);

        // TODO: Handle the case when no entity is found
        if (!optConcert.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(optConcert.get());

    }

    // TODO: add @GET and @Path
    @GetMapping
    public ResponseEntity<List<Concert>> retrieveAllConcert() {
        // TODO: get all concert
        List<Concert> concerts = concertRepository.findAll();
        return ResponseEntity.ok(concerts);
    }

    // TODO: add proper annotation Post verb
    @PostMapping
    public ResponseEntity<String> createConcert(@RequestBody Concert concert) { // add @ResponseBody

        // TODO save concert to database using repository
        concertRepository.save(concert);
        return ResponseEntity.status(HttpStatus.CREATED).body("Concert Created");

    }

    // TODO: add proper annotation Put verb
    @PutMapping
    public ResponseEntity<String> updateConcert(@RequestBody Concert concert) { // add @ResponseBody

        if (!concertRepository.existsById(concert.getId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        concertRepository.save(concert);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Concert updated");
    }

    // TODO: add annotation for Delete verb and and @Path for id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) { // TODO: add @PathVariable for id

        // TODO: Return a HTTP 404 response if the specified Concert isn't found.
        if (!concertRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }

        concertRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Concert deleted");

    }

    // TODO: add annotation for Delete verb
    @DeleteMapping
    public ResponseEntity<String> deleteAllConcerts() {

        // TODO: query to get all concerts into a list using guideline in the reference
        concertRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All od concert were deleted");
    }
}
