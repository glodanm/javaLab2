package ua.lviv.iot.entertainments;

import ua.lviv.iot.entertainments.enums.*;
import ua.lviv.iot.entertainments.manager.EntertainmentManager;
import ua.lviv.iot.entertainments.models.*;

import java.util.List;

public class App {
    public static void main(String[] args){
        List<Entertainment> listOfAmusement = List.of(
                new RollerCoaster("Fury 325", Age.ADULT, 50, 150, 4, 0,
                        "Metal", 8),
                new DamnWheel("London eye", Age.ADULT, 25, 150, 8, 0,
                        5, 135.5f),
                new RiverExcurcion("Finding nemo", Age.KIDS, 15, 100, 50, 10,
                        5000.0f, 15.5f));
        EntertainmentManager entertainmentManager = new EntertainmentManager(listOfAmusement);

        System.out.println("\n" + "Found by age:" + "\n" + "\n");
        EntertainmentManager.printEntertainments(entertainmentManager.findByAge(Age.ADULT));
        System.out.println("------------------------------------------" + "\n");

        System.out.println("Sorted by price" + "\n" + "\n");
        EntertainmentManager.printEntertainments(entertainmentManager.sortByPrice(SortOrder.ASC));
        System.out.println("------------------------------------------" + "\n");

        System.out.println("Sorted by max num of kids:" + "\n" + "\n");
        EntertainmentManager.printEntertainments(entertainmentManager.sortByMaxNumOfKids(SortOrder.DESC));

    }
}
