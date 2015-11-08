package org.jug.algeria.controller;

import org.jug.algeria.domain.AppUser;
import org.jug.algeria.domain.Car;
import org.jug.algeria.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Inject
    UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello there !";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser create(@PathVariable String username) {
        return userRepository.save(new AppUser(username));
    }

    @RequestMapping(value = "/user/{username}/cars/{carName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
         public AppUser createUserWithCar(@PathVariable String username,@PathVariable String carName) {
    AppUser appUser = new AppUser();
    appUser.setUsername(username);

    Car car = new Car();
    car.setCarName(carName);

    List<Car> cars = new ArrayList<>();
    cars.add(car);

    appUser.setCars(cars);

    return userRepository.save(appUser);
  }

  @RequestMapping(value = "/user/{username}/cars/{carName}/newCarName/{newCarName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public AppUser updateCar(@PathVariable String username,@PathVariable String carName,@PathVariable String newCarName) {
    AppUser appUser = userRepository.findByUsername(username);
    appUser.getCars().get(0).setCarName(newCarName);
    return userRepository.save(appUser);
  }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<>();
        final Iterable<AppUser> all = userRepository.findAll();
        all.forEach(new Consumer<AppUser>() {
            @Override
            public void accept(AppUser appUser) {
                resultList.add(appUser);
            }
        });
        return resultList;
    }

}
