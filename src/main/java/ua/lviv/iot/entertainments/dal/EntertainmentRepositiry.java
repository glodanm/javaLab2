package ua.lviv.iot.entertainments.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.entertainments.models.Entertainment;

@Repository
public interface EntertainmentRepositiry extends JpaRepository<Entertainment, Integer> {

}
