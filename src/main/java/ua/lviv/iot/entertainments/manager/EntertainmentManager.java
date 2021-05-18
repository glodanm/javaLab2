package ua.lviv.iot.entertainments.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.lviv.iot.entertainments.models.Entertainment;
import ua.lviv.iot.entertainments.enums.Age;
import ua.lviv.iot.entertainments.enums.SortOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor

public class EntertainmentManager {
    private List<Entertainment> amusement;

    public List<Entertainment> findByAge(final Age age){
        return amusement.stream().filter(item -> item.getAge() == age).collect(Collectors.toList());
    }

    public List<Entertainment> sortByPrice(final SortOrder sortOrder){
        List<Entertainment> sortedAmusement = new ArrayList<>(amusement);
        if (sortOrder == sortOrder.ASC){
            sortedAmusement.sort((amusement1, amusement2) -> amusement1.getPrice().compareTo(amusement2.getPrice()));
        }else{
            sortedAmusement.sort((amusement1, amusement2) -> amusement2.getPrice().compareTo(amusement1.getPrice()));
        }
        return sortedAmusement;
    }

    public List<Entertainment> sortByMaxNumOfKids(final SortOrder sortOrder){
        List<Entertainment> sortedAmusement = new ArrayList<>(amusement);
        if (sortOrder == SortOrder.ASC){
            sortedAmusement.sort((amusement1, amusement2) -> amusement1.getMaxNumOfKids().compareTo(amusement2.getMaxNumOfKids()));
        }else {
            sortedAmusement.sort((amusement1, amusement2) -> amusement2.getMaxNumOfKids().compareTo(amusement1.getMaxNumOfKids()));
        }
        return sortedAmusement;
    }

    public static void printEntertainments(final  List<Entertainment> amusement){
        amusement.forEach(System.out::println);
    }
}
