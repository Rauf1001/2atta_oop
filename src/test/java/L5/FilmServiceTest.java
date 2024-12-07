package L5;

import L5.exception.InvalidNameException;
import L5.model.Film.Film;
import L5.model.Film.FilmType;
import L5.service.FilmService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


//public class FilmServiceTest {
//
//
//
//
//    @Test
//    @DisplayName("первый тест(:")
//    void testAreFilmNamesEqual_Success() {
//        String filmName1 = "Inception";
//        String filmName2 = "Inception";
//
//        assertTrue(FilmService.areFilmNamesEqual(filmName1, filmName2));
//    }
//
//
//    @Test
//    @DisplayName("второй тест(:")
//    void testAreFilmNamesEqual_Failure() {
//
//        String filmName1 = "Inception";
//        String filmName2 = "Interstellar";
//
//
//        assertThrows(InvalidNameException.class, () ->
//                FilmService.areFilmNamesEqual(filmName1, filmName2)
//        );
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
