package com.example.demo.cli;

import com.example.demo.racecar.RaceCar;
import com.example.demo.racecar.RaceCarService;
import com.example.demo.racingclass.RacingClass;
import com.example.demo.racingclass.RacingClassService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final RacingClassService racingClassService;
    private final RaceCarService raceCarService;

    public ConsoleRunner(RacingClassService racingClassService, RaceCarService raceCarService) {
        this.raceCarService = raceCarService;
        this.racingClassService = racingClassService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        printHelp();

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                return;
            }
            String command = scanner.nextLine().trim();

            switch (command) {
                case "help" -> printHelp();
                case "classes" -> listClasses();
                case "cars" -> listCars();
                case "add" -> addCar(scanner);
                case "delete" -> deleteCar(scanner);
                case "quit" -> {
                    System.out.println("Quitting...");
                    System.exit(0);
                }
                default -> System.out.println("Unknown command -> type 'help\n");
            }

        }
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("help - commands list");
        System.out.println("classes - racing classes list");
        System.out.println("cars - racing cars list");
        System.out.println("add - add a new car (select class after)");
        System.out.println("delete - delete the specified car");
        System.out.println("quit - quit the application\n");
    }

    private void listClasses() {
        List<RacingClass> allClasses = racingClassService.findAll();

        // Printing
        for (RacingClass racingClass : allClasses) {
            System.out.println(racingClass.getName() + " (max HP: " + racingClass.getMaxHorsepower() + ", min weight: " + racingClass.getMinWeight() + ")");
        }
    }

    private void listCars() {
        // Sort the cars first
        List<RaceCar> cars = raceCarService.findAll().stream().sorted().toList();

        // Printing
        for (int i = 0; i < cars.size(); i++) {
            RaceCar car = cars.get(i);
            System.out.println(i+1 + ". #" + car.getStartNumber() + " " + car.getModelName() + "[" + car.getRacingClass().getName() + "]");
        }
    }

    private void addCar(Scanner scanner) {
        System.out.println("Enter the model: ");
        String model = scanner.nextLine().trim();
        int startNumber = readInt(scanner, "Enter the starting number: ");
        double displacement = readDouble(scanner, "Enter the engine displacement (L): ");
        System.out.println("Hybrid (y/n): ");
        boolean hybrid = scanner.nextLine().trim().equals("y");

        List<RacingClass> classes = racingClassService.findAll();

        if (classes.isEmpty()) {
            System.out.println("No racing classes!");
            return;
        }

        for (int i = 0; i < classes.size(); i++) {
            System.out.println(i+1 + ". " + classes.get(i).getName());
        }

        int choice = readInt(scanner, "Select a racing class: ");
        if (choice < 1 || choice > classes.size()) {
            System.out.println("Entered a wrong number -> cancelling...");
            return;
        }

        raceCarService.create(model, startNumber, displacement, hybrid, classes.get(choice-1));
        System.out.println("Successfully created and added the car!");
    }

    private void deleteCar(Scanner scanner) {
        List<RaceCar> cars = raceCarService.findAll().stream().sorted().toList();
        listCars();

        if (cars.isEmpty()) {
            System.out.println("There are no cars.");
            return;
        }

        int choice = readInt(scanner, "Select the car to delete: ");
        if (choice < 1 || choice > cars.size()) {
            System.out.println("Entered a wrong number -> cancelling...");
            return;
        }
        raceCarService.delete(cars.get(choice - 1));
        System.out.println("Successfully deleted the car.");
    }

    /// Helper function for reading an int in a loop with validation
    private int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Not an integer.");
            }
        }
    }

    /// Helper function for reading a double in a loop with validation
    private double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Not a real number.");
            }
        }
    }
}
