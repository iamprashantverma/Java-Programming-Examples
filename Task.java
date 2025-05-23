//  Assumption 
/*
 *  Country will be created first then city
 *  After assigning a city as capital we can't change it
 *  we can add or remove a city from the country (excluding the capital city)
 *  to create a new city we need city name and the country
 */
import java.util.*;

class City {

    private String name;
    private Country country;

    City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
    
    public String getCityName () {
        return this.name;
    }

    public String getCountryName () {
        return country.getCountryName();
    }
}

class Country {

    private final  String name;
    private final Set<City> cities ;
    private  City capital ;

    public Country(String name) {
        capital  = new City("hui", this);
        this.name = name;
        this.cities = new HashSet<>();
    }

    public void addCity(City city ){
        cities.add(city);
    }

    public void removeCity(City city) {
        if ( !cities.contains(city)) {
            System.out.println(city.getCityName() +": do not belong to- "+this.name );
        }else if (capital != null && capital == city) {
            System.out.println("We can't remove the capital city from our region");
        } else {
            cities.remove(city);
        }
    }

    public void showCities() {
        cities.stream().forEach(x->System.out.println(x.getCityName()));
    }   
    
    public String getCountryName() {
        return name;
    }
    
    public void marksCityAsCapital(City city) {
        if (!cities.contains(city)) {
            System.out.println(city.getCityName() + " do not belong to -"+name);
        } else if(capital != null && capital != city) {
            System.out.println(name +" has Already capital :"+capital.getCityName());
        }else {
            this.capital = city;
        }
    }

}
public class Task {
    
}
