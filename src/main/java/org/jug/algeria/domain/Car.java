package org.jug.algeria.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by proximus on 11/8/2015.
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String carName;
    private String carModel;

    @ManyToMany(mappedBy = "cars")
    private List<AppUser> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
