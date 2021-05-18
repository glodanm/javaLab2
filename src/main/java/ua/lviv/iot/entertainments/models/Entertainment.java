package ua.lviv.iot.entertainments.models;

import lombok.*;

import ua.lviv.iot.entertainments.enums.Age;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class Entertainment {
    public String name;
    public Age age;
    public Integer price;
    public Integer height;
    public Integer maxPeople;
    public Integer maxNumOfKids;

    @Override
    public String toString() {
        return "Entertainment{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", height=" + height +
                ", maxPeople=" + maxPeople +
                ", maxNumOfKids=" + maxNumOfKids +
                '}';
    }
}

