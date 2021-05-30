package ua.lvlv.iot.entertainmentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lvlv.iot.entertainmentservice.models.Entertainment;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/entertainment")
@RestController
public class EntertainmentController {
    private final Map<Integer, Entertainment> entertainments = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public Collection<Entertainment> getEntertainment() {
        return new ArrayList<Entertainment>(entertainments.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entertainment> getEntertainment(@PathVariable("id") Integer id) {

        if (entertainments.get(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entertainments.get(id));

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Entertainment createEntertainment(final @RequestBody Entertainment entertainment) {
        entertainment.setId(idCounter.incrementAndGet());
        entertainments.put(entertainment.getId(), entertainment);
        return entertainment;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Entertainment> deleteEntertainments(@PathVariable("id") int id) {
        HttpStatus status;
        if (entertainments.get(id) == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
            entertainments.remove(id);
        }

        return ResponseEntity.status(status).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Entertainment> updateEntertainments(final @PathVariable("id") int id, final
    @RequestBody Entertainment entertainment) {
        HttpStatus status;
        if (entertainments.get(id) == null) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.OK;
            entertainment.setId(id);
            entertainments.put(id, entertainment);
        }
        return ResponseEntity.status(status).build();
    }
}