package L6.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Person implements Comparable<Person> {


    @Override
    public int compareTo(Person o) {
        if (this.equals(o)) {
            return 0;
        }
        return this.surname.compareTo(o.surname);
    }

    private String name;
    private String surname;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname)
                && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode()  {
        return Objects.hash(name, surname, age);
    }

}