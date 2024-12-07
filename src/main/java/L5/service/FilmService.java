package L5.service;

import L5.exception.InvalidNameException;
import L5.model.Film.Film;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

public class FilmService {


    public static boolean areFilmNamesEqual(String filmName1, String filmName2) throws InvalidNameException {
        if (!Objects.equals(filmName1, filmName2)) {
            throw new InvalidNameException("Названия фильмов не совпадают: " + filmName1 + " и " + filmName2);
        }
        return true;
    }




}
