import java.util.HashSet;
import java.util.Set;

/**
 * 🧾 Problem Statement:
 * ---------------------
 * Design a Java program that models a Country and its Cities.
 * - Each Country has a name, a list of cities, and exactly one capital city.
 * - Each City knows which Country it belongs to.
 * - Capital city must be set during country creation and should be automatically added to the city list.
 * - The program should support adding/removing cities and displaying all cities in a country.
 * - Attempting to remove the capital or set a capital that doesn't belong to the country should be prevented.
 *
 * 🧱 Assumptions:
 * --------------
 * - A city is uniquely identified by its object instance.
 * - Capital city is mandatory and set when the Country is created.
 * - The city name is assumed to be unique for simplicity (not enforced here).
 */

class City {
    private final String name;
    private final Country country;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getCityName() {
        return name;
    }

    public String getCountryName() {
        return country.getCountryName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return name.equals(other.name) && country.getCountryName().equals(other.getCountryName());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + country.getCountryName().hashCode();
    }
}

class Country {
    private final String name;
    private final Set<City> cities;
    private City capital;

    public Country(String name, String capitalCityName) {
        this.name = name;
        this.cities = new HashSet<>();
        this.capital = new City(capitalCityName, this);
        this.cities.add(capital); // Automatically add capital to city list
    }

    public void addCity(String cityName) {
        City city = new City(cityName, this);
        cities.add(city);
    }

    public void removeCity(City city) {
        if (!cities.contains(city)) {
            System.out.println("⚠️ " + city.getCityName() + " does not belong to " + name);
        } else if (capital.equals(city)) {
            System.out.println("🚫 Cannot remove the capital city: " + city.getCityName());
        } else {
            cities.remove(city);
        }
    }

    public void showCities() {
        System.out.println("🌆 Cities in " + name + ":");
        cities.forEach(c -> System.out.println("- " + c.getCityName()));
    }

    public String getCountryName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City city) {
        if (!cities.contains(city)) {
            System.out.println("⚠️ " + city.getCityName() + " is not part of " + name);
        } else {
            this.capital = city;
            System.out.println("✅ Capital changed to: " + city.getCityName());
        }
    }
}

public  class Task {
    public static void main(String[] args) {
        Country japan = new Country("Japan", "Tokyo");

        japan.addCity("Osaka");
        japan.addCity("Kyoto");

        System.out.println("🏛 Capital: " + japan.getCapital().getCityName());
        japan.showCities();

        // Attempt to remove the capital
        japan.removeCity(japan.getCapital());

        // Add a new city and try to make it the capital
        City osaka = new City("Osaka", japan);
        japan.setCapital(osaka); // Should work since Osaka is part of the country
    }
}
