package org.jug.algeria.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USERS_TO_CARS", joinColumns = {@JoinColumn(name = "USER_ID",referencedColumnName = "ID")},inverseJoinColumns = {@JoinColumn(name = "CAR_ID",referencedColumnName = "ID")} )
  private List<Car> cars;

  @OneToMany(mappedBy = "user")
  private List<Adress> adresses;

    public AppUser() {
    }

    public AppUser(String username) {
        this.username = username;
    }

    public AppUser(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Adress> getAdresses() {
    return adresses;
  }

  public void setAdresses(List<Adress> adresses) {
    this.adresses = adresses;
  }

  @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
