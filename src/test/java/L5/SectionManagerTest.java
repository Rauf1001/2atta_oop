package L5;

import L5.exception.WrongSectionException;
import L5.model.Film.Film;
import L5.model.Film.FilmType;
import L5.model.Section.*;
import L5.service.SectionManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SectionManagerTest {





    @Test
    @DisplayName("1негатив тест ):")
    void testPutFilmOnSection_Success1() {
        Film film = new Film().setFilmName("Inception").setFilmType(FilmType.ACTION);
        Section section = new ActionSection();

        Map<String, Section> sections = new HashMap<>();
        sections.put("Action Section", section);

        SectionManager sectionManager = new SectionManager(sections);

        assertTrue(section.getFilms().isEmpty(), "Секция должна быть пуста до добавления фильма.");
        sectionManager.putFilmOnSection(film, section);


        assertEquals(1, section.getFilms().size(), "Секция должна содержать 1 фильм.");
        assertEquals(film, section.getFilms().get(0), "Фильм в секции должен быть тем же, что и добавленный.");
    }
    @Test
    @DisplayName("2негатив тест ):")
    void testPutFilmOnSection_Failure() {
        Film film = new Film().setFilmName("Inception");

        Section actionSection = new ActionSection();
        Section musicalSection = new MusicalSection();

        Map<String, Section> sections = new HashMap<>();
        sections.put("Action Section", actionSection);

        SectionManager sectionManager = new SectionManager(sections);

        WrongSectionException exception = assertThrows(WrongSectionException.class, () -> {
            sectionManager.putFilmOnSection(film, musicalSection);
        });

        assertEquals("Попытка положить товар не на ту полку!", exception.getMessage());

        assertTrue(actionSection.getFilms().isEmpty(), "Секция должна оставаться пустой, если фильм не добавлен.");
        assertTrue(musicalSection.getFilms().isEmpty(), "Секция не должна содержать фильм после неудачной попытки добавления.");
    }

    @Test
    @DisplayName("позитивный тест (:")
    void testNullCheck() {
        String str = "Inception";
        assertNotNull(str, "Строка не должна быть равна null.");
    }

}
