package org.jug.algeria.domain;


import javax.persistence.*;

/**
 * Created by proximus on 11/8/2015.
 */

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;

    @Column(name = "USER_ID", insertable = false, updatable = false)
    private long userId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private AppUser user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
