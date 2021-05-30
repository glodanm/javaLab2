package ua.lviv.iot.entertainments.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import ua.lviv.iot.entertainments.enums.Age;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class DamnWheel extends Entertainment {
    public Integer numbersOfCircles;
    public Float constructionHeight;

    public DamnWheel(Integer id, String name, Age age, Integer price, Integer height,
                     Integer maxPeople, Integer maxNumOfKids,
                     Integer numbersOfCircles, Float constructionHeight) {
        super(id, name, age, price, height, maxPeople, maxNumOfKids);
        this.numbersOfCircles = numbersOfCircles;
        this.constructionHeight = constructionHeight;
    }

    @Override
    public String toString() {
        return "DamnWheel{"
                +
                ", name='" + name + '\''
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
                ", numbersOfCircles=" + numbersOfCircles
                +
                ", constructionHeight=" + constructionHeight
                +
                '}';
    }
}
