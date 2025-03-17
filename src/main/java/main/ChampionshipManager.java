package main;

import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();
    private static int totalRaces = 0;
    private static int totalDrivers = 0;

    private ChampionshipManager() {
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        drivers.sort((d1, d2) -> d2.getPoints() - d1.getPoints());
        return drivers;
    }

    public Driver getLeadingDriver() {
        return getDriverStandings().get(0);
    }

    public List<RallyRaceResult> getRaceResults() {
        return races;
    }

    public int getTotalChampionshipPoints(){
        return drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public int getTotalDrivers() {
        return totalDrivers;
    }

    public int getTotalRaces() {
        return totalRaces;
    }




}

