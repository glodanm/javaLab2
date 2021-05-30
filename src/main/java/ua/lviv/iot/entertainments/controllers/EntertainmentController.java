package ua.lviv.iot.entertainments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import ua.lviv.iot.entertainments.models.Entertainment;
import ua.lviv.iot.entertainments.service.EntertainmentService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/entertainment")
public class EntertainmentController {

    private static final Logger LOGGER = Logger.getLogger("ua/lviv/iot/entertainment/controllers/EntertainmentController");

    @Autowired
    private EntertainmentService entertainmentService;

    @GetMapping
    public ResponseEntity<List<Entertainment>> getEntertainmentList() {
        return new ResponseEntity<>(entertainmentService.getEntertainmentList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Entertainment> addEntertainment(@RequestBody Entertainment newEntertainment) {
        if (newEntertainment.getId() != null) {
            LOGGER.severe("BAD REQUEST: trying to set created object`s id externally");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(entertainmentService.addEntertainment(newEntertainment), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Entertainment> getEntertainment(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(entertainmentService.getEntertainment(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Entertainment> updateEntertainment(@RequestBody Entertainment newEntertainment) {
        try {
            return new ResponseEntity<>(entertainmentService.updateEntertainment(newEntertainment), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Entertainment> deleteEntertainment(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(entertainmentService.deleteEntertainment(id), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            LOGGER.severe(e.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}