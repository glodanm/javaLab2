package ua.lviv.iot.entertainments.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import ua.lviv.iot.entertainments.enums.Age;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class RiverExcurcion extends Entertainment{
    public Float routeLength;
    public Float lengthOfBoat;

    public RiverExcurcion(String name, Age age, Integer price, Integer height, Integer maxPeople, Integer maxNumOfKids,
                          Float routeLength, Float lengthOfBoat){
        super(name, age, price, height, maxPeople, maxNumOfKids);
        this.routeLength = routeLength;
        this.lengthOfBoat = lengthOfBoat;
    }

    @Override
    public String toString() {
        return "RiverExcurcion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", height=" + height +
                ", maxPeople=" + maxPeople +
                ", maxNumOfKids=" + maxNumOfKids +
                ", routeLength=" + routeLength +
                ", lengthOfBoat=" + lengthOfBoat +
                '}';
    }
}
