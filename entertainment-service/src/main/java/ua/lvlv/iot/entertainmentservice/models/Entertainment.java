package ua.lvlv.iot.entertainmentservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Entertainment {
    private Integer id;
    private String name;
    private Integer price;
    private Integer height;
    private Integer maxPeople;
    private Integer maxNumOfKids;
}
