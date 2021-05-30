package ua.lviv.iot.entertainments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.NoSuchElementException;

import ua.lviv.iot.entertainments.dal.EntertainmentRepositiry;
import ua.lviv.iot.entertainments.models.Entertainment;


@Service
@ApplicationScope
public class EntertainmentService {

    @Autowired
    private EntertainmentRepositiry repository;

    public Entertainment addEntertainment(Entertainment receivedEntertainment) {
        return repository.save(receivedEntertainment);
    }

    public List<Entertainment> getEntertainmentList() {
        return repository.findAll();
    }

    public Entertainment getEntertainment(Integer id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new NoSuchElementException("NOT FOUND: Cannot find entertainment with id:" + id + "in the system");
    }

    public Entertainment updateEntertainment(Entertainment receivedEntertainment) {

        if (repository.existsById(receivedEntertainment.getId())) {
            return repository.save(receivedEntertainment);
        }
        throw new NoSuchElementException(
                "NOT FOUND: Cannot find entertainment with id:" + receivedEntertainment.getId() + "in the system"
        );
    }

    public Entertainment deleteEntertainment(Integer id) {
        Entertainment deletedEntertainment = getEntertainment(id);
        repository.deleteById(id);
        return deletedEntertainment;
    }
}
