package ua.lviv.iot.entertainments.models;

import ua.lviv.iot.entertainments.enums.Age;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Entity

public class Entertainment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Age age;
    public Integer price;
    public Integer height;
    public Integer maxPeople;
    public Integer maxNumOfKids;

    @Override
    public String toString() {
        return "Entertainment{"
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
                '}';
    }
}

