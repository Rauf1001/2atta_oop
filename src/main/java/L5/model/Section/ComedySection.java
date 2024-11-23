package L5.model.Section;

import L5.model.Film.Film;
import java.util.ArrayList;
import java.util.List;
public class ComedySection extends Section{

    private List<Film> filmList = new ArrayList<>();

    @Override
    public SectionType getSectionType(){
        return SectionType.COMEDY_SECTION;
    }

    @Override
    public void putFilmOnSection(Film film){
        super.log("Кладем фильм в отдел комедии");
        this.filmList.add(film);
    }

    @Override
    public List<Film> getFilms(){
        return this.filmList;
    }
    @Override
    public void clearSection(){
        this.filmList = new ArrayList<>();
    }


}
