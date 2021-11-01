package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {
    private static List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car("Bob", "Lada", 111));
        cars.add(new Car("Hana", "Toyota Camry", 222));
        cars.add(new Car("Lena", "Lada Sedan", 333));
        cars.add(new Car("Ivan", "Infinity", 444));
        cars.add(new Car("Jack", "Ford", 555));
    }

    public CarService() {

    }

    public List<Car> getCars(int amount) {
        List<Car> result = new ArrayList<>();
        for(int i = 0; i < Math.min(cars.size(), amount); i++) {
            result.add(cars.get(i));
        }
        return result;
    }
}
