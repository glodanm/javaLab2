package ua.lviv.iot.entertainments.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import ua.lviv.iot.entertainments.enums.Age;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class RollerCoaster extends Entertainment {
    public String materialType;
    public Integer numbersOfTrolleys;

    public RollerCoaster(Integer id, String name, Age age, Integer price, Integer height,
                         Integer maxPeople, Integer maxNumOfKids,
                         String materialType, Integer numbersOfTrolleys) {
        super(id, name, age, price, height, maxPeople, maxNumOfKids);
        this.materialType = materialType;
        this.numbersOfTrolleys = numbersOfTrolleys;
    }

    @Override
    public String toString() {
        return "RollerCoaster{"
                +
                "name='" + name + '\''
                +
                ", age=" + age
                +
                ", price=" + price
                +
                ", height=" + height
                +
                ", maxPeople=" + maxPeople
                +
                ", maxNumOfKids=" + maxNumOfKids
                +
                ", materialType='" + materialType + '\''
                +
                ", numbersOfTrolleys=" + numbersOfTrolleys
                +
                '}';
    }
}
