package algorithm.offer.lambda.java8InAction.optional;

import java.util.Optional;

public class Person {
    class Car {
        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }

    }

    static class Insurance {
        public Insurance(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }
    }


    public static void main(String[] args) {
        Runnable target;
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {

            }
        });
        Person person = new Person();
        Car car = person.new Car();
        System.out.println(car.insurance.of(new Insurance("no insurance").getName()));
    }

}
