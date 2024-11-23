package L5.service;


import L5.model.Film.FilmType;
import L5.model.Film.Film;
import L5.model.Section.Section;
import L5.model.Section.SectionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import L5.exception.WrongSectionException;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class SectionManager {


    private final Map<String, Section> sections;
    private static final String ERROR_MESSAGE = "Во время выполнения функции произошла ошибка: %s";


    public void putFilmOnSection(Film film, Section section) {
        try {
            isRightSection(film.getFilmType(), section.getSectionType());
            section.putFilmOnSection(film);
        } catch (WrongSectionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (section.getFilms().isEmpty()) {
                section.putFilmOnSection(film); // Вставка фильма в секцию, если она пуста
            }
        }
    }

    private void isRightSection(FilmType filmType, SectionType sectionType){
        if (!filmType.toValue().equals(sectionType.toValue())){
            throw new WrongSectionException("Попытка положить фильм не в тот отдел!");
        }
    }




























}
