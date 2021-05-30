package ua.lviv.iot.entertainments;

import ua.lviv.iot.entertainments.enums.Age;
import ua.lviv.iot.entertainments.enums.SortOrder;
import ua.lviv.iot.entertainments.manager.EntertainmentManager;
import ua.lviv.iot.entertainments.models.Entertainment;
import ua.lviv.iot.entertainments.models.RiverExcurcion;
import ua.lviv.iot.entertainments.models.DamnWheel;
import ua.lviv.iot.entertainments.models.RollerCoaster;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Entertainment> listOfAmusement = List.of(
                new RollerCoaster(1, "Fury 325", Age.ADULT, 50, 150, 4, 0,
                        "Metal", 8),
                new DamnWheel(1, "London eye", Age.ADULT, 25, 150, 8, 0,
                        5, 135.5f),
                new RiverExcurcion(1,"Finding nemo", Age.KIDS, 15, 100, 50, 10,
                        5000.0f, 15.5f));
        EntertainmentManager entertainmentManager =
                new EntertainmentManager(listOfAmusement);

        System.out.println("\n" + "Found by age:" + "\n" + "\n");
        EntertainmentManager.printEntertainments(
                entertainmentManager.findByAge(Age.ADULT));
        System.out.println("------------------------------------------" + "\n");

        System.out.println("Sorted by price" + "\n" + "\n");
        EntertainmentManager.printEntertainments(
                entertainmentManager.sortByPrice(SortOrder.ASC));
        System.out.println("------------------------------------------" + "\n");

        System.out.println("Sorted by max num of kids:" + "\n" + "\n");
        EntertainmentManager.printEntertainments(
                entertainmentManager.sortByMaxNumOfKids(SortOrder.DESC));

    }
}
