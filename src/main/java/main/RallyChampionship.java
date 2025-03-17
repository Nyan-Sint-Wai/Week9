package main;

import java.util.Map;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Register drivers
        Driver driver1 = new Driver("Sebastien Ogier", "France", new GravelCar("Toyota", "Yaris WRC", 338, 30));
        Driver driver2 = new Driver("Kalle Rovanpera", "Finland", new AsphaltCar("Hyundai", "i20 Coupe WRC", 337, 50));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Fiesta WRC", 340, 32));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Citroën", "C3 WRC", 336, 45));

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // Simulate Race 1
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.addRaceResult(race1);

        // Simulate Race 2
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.addRaceResult(race2);

        // Display Championship Standings
        System.out.println();
        int rank = 1;
        for (Driver driver : manager.getDriverStandings()) {
            System.out.println(rank + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            rank++;
        }

        // Display Champion
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getPoints() + " points");

        // Display Statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getTotalDrivers());
        System.out.println("Total Races: " + manager.getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int position = 1;
            for (Map.Entry<Driver, Integer> entry : race.getResults()) {
                System.out.println("Position " + position + ": " + entry.getKey().getName() + " - " + entry.getValue() + " points");
                position++;
            }
            System.out.println();
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.printf("Gravel Car Performance: %.1f%n", driver1.getCar().calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f%n", driver2.getCar().calculatePerformance());


    }
}