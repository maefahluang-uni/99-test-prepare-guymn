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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcertController {

    private static Logger LOGGER = LoggerFactory.getLogger(ConcertController.class);

    // TODO: add repository

    // TODO: add @GET and @Path
    public ResponseEntity<Concert> retrieveConcert(long id) { // TODO: add @PathVariable for id

        // TODO: find concert by ID suing em.find(...

        // TODO: Handle the case when no entity is found

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // TODO: add @GET and @Path
    public ResponseEntity<List<Concert>> retrieveAllConcert() {
        // TODO: get all concert
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // TODO: add proper annotation Post verb
    public ResponseEntity<String> createConcert(Concert concert) { // add @ResponseBody

        // TODO save concert to database using repository
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // TODO: add proper annotation Put verb
    public ResponseEntity<String> updateConcert(Concert concert) { // add @ResponseBody

        // TODO update concert using em.merge(..
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // TODO: add annotation for Delete verb and and @Path for id
    public ResponseEntity<String> delete(long id) { // TODO: add @PathVariable for id

        // TODO: delete concert using em.remove

        // TODO: Return a HTTP 404 response if the specified Concert isn't found.

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // TODO: add annotation for Delete verb
    public ResponseEntity<String> deleteAllConcerts() {

        // TODO: query to get all concerts into a list using guideline in the reference

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
