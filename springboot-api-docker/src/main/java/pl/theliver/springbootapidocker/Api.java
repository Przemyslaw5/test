package pl.theliver.springbootapidocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private final AnimalRepo animals;

    public Api(AnimalRepo animals) {
        this.animals = animals;
        animals.save(new Animal("cat"));
        animals.save(new Animal("dog"));
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animals.findAll();
    }

    @PostMapping("/animals")
    public void addAnimals(@RequestBody Animal animal) {
        animals.save(animal);
    }
}
