package L5.model.Section;
import L5.model.Film.Film;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@NoArgsConstructor
@Getter
@Slf4j
public abstract class Section{

    public abstract SectionType getSectionType();
    public abstract void putFilmOnSection(Film film);
    public abstract List<Film> getFilms();
    public abstract void clearSection();
    public void log(String message){
        log.info(message);
    }
}
