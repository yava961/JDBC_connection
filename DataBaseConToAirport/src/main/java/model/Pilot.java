package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pilot {
    private Integer id;
    private String name;
    private Integer age;
    private String planes;

    public Pilot(String name, Integer age, String planes) {
        this.name = name;
        this.age = age;
        this.planes = planes;
    }

}
