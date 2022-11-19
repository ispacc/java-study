package jdk8.optional;

import lombok.Data;

import java.util.Optional;

@Data
class Zoo {
   private Dog dog;
}

@Data
class Dog {
   private int age;
}

class ZooTest {
   public static void main(String[] args) {
      Optional.ofNullable(new Zoo()).map(Zoo::getDog).map(Dog::getAge).ifPresent(System.out::println);



   }
}
