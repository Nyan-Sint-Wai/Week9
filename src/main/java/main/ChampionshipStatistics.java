package main;

import java.util.*;

class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        return drivers.isEmpty() ? 0 : drivers.stream().mapToInt(Driver::getPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            countryPoints.put(driver.getCountry(), countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getPoints());
        }
        return countryPoints.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getInstance().getTotalRaces();
    }
}