package main.classes.kindergarten_garden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KindergartenGarden {

    private String garden;

    private String[] students =
            {
                    "Alice",
                    "Bob",
                    "Charlie",
                    "David",
                    "Eve",
                    "Fred",
                    "Ginny",
                    "Harriet",
                    "Ileana",
                    "Joseph",
                    "Kincaid",
                    "Larry"
            };

    public KindergartenGarden(String garden) {
        this.garden = garden;
    }

    public List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();
        List<String> allStudents = new ArrayList<>(Arrays.asList(students));
        String[] rows = garden.split("\n");
        int index = allStudents.indexOf(student) * 2;
        for (String row : rows) {
            plants.add(Plant.getPlant(row.charAt(index)));
            plants.add(Plant.getPlant(row.charAt(index + 1)));
        }
        return plants;
    }
}
