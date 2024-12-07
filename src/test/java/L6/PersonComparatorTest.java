package L6;

import L6.comparator.PersonNameComparator;
import L6.model.Person;
import L6.model.Place;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonComparatorTest {

    private static final String PLACE_ADDRESS_1 = "Place test address";
    private static final String PLACE_ADDRESS_2 = "Place test address";
    private static final String PERSON_1 = "Aliev";
    private static final String PERSON_2 = "Chulkov";
    static final int F=7;
    static final int F_1=18;

    private static List<Place> sortingByAddress;
    private static List<Place> sortingByAddressAndPerson;

    @BeforeAll
    static void setUp() {
        sortingByAddress = getSortingByAddress();
        sortingByAddressAndPerson = getSortingByAddressAndPerson();
    }


    @Test
    @DisplayName("Сортировка только по адресу")
    void sorPlaceByAddress(){
        var places = new ArrayList<Place>();
        places.add(new Place()
                .setAddress(PLACE_ADDRESS_2)
                .setFloorsCount(F)
                .setPerson(
                        new Person()
                                .setAge(18)
                                .setName("Rauf")
                                .setSurname("Aliev12")
                ));

        places.add(new Place()
                .setAddress(PLACE_ADDRESS_1)
                .setFloorsCount(F_1)
                .setPerson(
                        new Person()
                                .setAge(19)
                                .setName("Artem")
                                .setSurname("Chulkov")
                ));

        places.sort(new PersonNameComparator());

        for (int i = 0; i < places.size(); i++) {
            assertThat(places.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("floorsCount", "person")
                    .isEqualTo(sortingByAddress.get(i));
        }
    }

    @Test
    @DisplayName("Сортировка только по количеству страниц и автору")
    void sortBookByAddressAndPerson(){
        var places = new ArrayList<Place>();
        places.add(new Place()
                .setAddress(PLACE_ADDRESS_2)
                .setFloorsCount(F)
                .setPerson(
                        new Person()
                                .setAge(18)
                                .setName("Rauf")
                                .setSurname(PERSON_2)
                ));

        places.add(new Place()
                .setAddress(PLACE_ADDRESS_1)
                .setFloorsCount(F_1)
                .setPerson(
                        new Person()
                                .setAge(19)
                                .setName("Artem")
                                .setSurname(PERSON_1)
                ));

        places.sort(Comparator.comparing(Place::getFloorsCount).thenComparing(Place::getPerson));

        for (int i = 0; i < places.size(); i++) {
            assertThat(places.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("floorsCount", "person.name", "person.age")
                    .isEqualTo(sortingByAddressAndPerson.get(i));
        }
    }

    private static List<Place> getSortingByAddress(){
        return List.of(
                new Place()
                        .setAddress(PLACE_ADDRESS_2)
                        .setFloorsCount(F)
                        .setPerson(
                                new Person()
                                        .setAge(18)
                                        .setName("Rauf")
                                        .setSurname("Aliev12")
                        ),
                new Place()
                        .setAddress(PLACE_ADDRESS_1)
                        .setFloorsCount(F_1)
                        .setPerson(
                                new Person()
                                        .setAge(19)
                                        .setName("Artem")
                                        .setSurname("Chulkov")
                        )
        );
    }

    private static List<Place> getSortingByAddressAndPerson(){
        return List.of(
                new Place()
                        .setAddress(PLACE_ADDRESS_2)
                        .setFloorsCount(F)
                        .setPerson(
                                new Person()
                                        .setAge(18)
                                        .setName("Rauf")
                                        .setSurname(PERSON_2)
                        ),
                new Place()
                        .setAddress(PLACE_ADDRESS_1)
                        .setFloorsCount(F_1)
                        .setPerson(
                                new Person()
                                        .setAge(19)
                                        .setName("Artem")
                                        .setSurname(PERSON_1)
                        )
        );
    }
}
