package L5.model.Film;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.time.LocalDate;
@Getter
@Setter
@Accessors(chain = true)
public class Film {
    private String filmName;
    private FilmType filmType;

    private LocalDate dateOfManufacture;
    private LocalDate validUntil;
}