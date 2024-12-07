package L6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Place {
    private String address;
    private int floorsCount;
    private Person person;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return Objects.equals(address, place.address) && Objects.equals(person, place.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, person);
    }

}