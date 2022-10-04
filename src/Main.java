import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        //Module 1
        System.out.println("--- Module 1 ---");
        List<City> cityList = new ArrayList<>();
        Path filePath = Paths.get("source/CityBase");
        Scanner scanner = new Scanner(filePath);
        while (scanner.hasNext()) {
            String[] cityComponents = scanner.next().split(";");
            City city = new City(
                    cityComponents[1],
                    cityComponents[2],
                    cityComponents[3],
                    Integer.parseInt(cityComponents[4]),
                    Integer.parseInt(cityComponents[5])
            );
            cityList.add(city);
        }
        for (City city : cityList) {
            System.out.println(city);
        }

        //Module 2
        System.out.println("--- Module 2 ---");
        Comparator<City> orderByName = Comparator.comparing(o -> o.getName().toLowerCase(Locale.ROOT));
        Comparator<City> orderByDistrictAndName = (o1, o2) -> {
            if (o1.getDistrict().compareTo(o2.getDistrict()) == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getDistrict().compareTo(o2.getDistrict());
        };
        System.out.println("First sorting by name: ");
        cityList.stream()
                .sorted(orderByName)
                .forEach(System.out::println);
        System.out.println("Second sorting by district and name: ");
        cityList.stream()
                .sorted(orderByDistrictAndName)
                .forEach(System.out::println);

        //Module 3
        System.out.println("--- Module 3 ---");
        City[] arr = cityList.toArray(new City[0]);
        int max = arr[0].getPopulation(), id = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getPopulation() > max) {
                id = i;
                max = arr[i].getPopulation();
            }
        }
        System.out.println("Index and max population: ");
        System.out.printf("id: %d, max: %d", id, max);
        System.out.println();

        //Module 4
        System.out.println("--- Module 4 ---");
        Map<String, Integer> regionsCount = new HashMap<>();
        for (City city : cityList) {
            regionsCount.computeIfPresent(city.getRegion(), (k, v) -> v + 1);
            regionsCount.putIfAbsent(city.getRegion(), 1);
        }
        for (Map.Entry<String, Integer> pair : regionsCount.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
