package circus;

import circus.animal.*; // coding standard violation
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals : " + animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
//        animals[2] = new Parrot("Dolly"); // obviously you cannot do this

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        System.out.println("Size of the array list : " + animalArrayList.size());
        animalArrayList.add(new Parrot("Dolly"));
        animalArrayList.add(new Duck("Goose"));
        System.out.println("Size of the array list : " + animalArrayList.size());

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        Elephant strongOne = new Elephant("Strong One");
        Tiger shareKhan = new Tiger("Share Khan");

        System.out.println("Before sorting...");
        printAllAnimals(animalArrayList);
        System.out.println("Index of Louie: " + animalArrayList.indexOf(louie));

        System.out.println("After sorting...");
        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);
        System.out.println("Index of Louie: " + animalArrayList.indexOf(louie));

    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}
