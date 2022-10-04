public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public String toString() {
        return "City{name='" + this.name + "', region='" + this.region + "', district='" + this.district + "', population=" + this.population + ", foundation=" + this.foundation + "}";
    }
}