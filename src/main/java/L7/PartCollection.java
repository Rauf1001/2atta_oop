package L7;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class PartCollection<T> {


    private PartCollection<T> previous;
    private PartCollection<T> next;
    private T value;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PartCollection<T> that = (PartCollection<T>) o;
        return Objects.equals(value, that.value);
    }
}
