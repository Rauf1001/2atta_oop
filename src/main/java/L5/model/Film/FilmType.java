package L5.model.Film;

public enum FilmType {

    COMEDY("comedy"),
    MUSICAL("musical"),
    ACTION("action");

    private final String value;

    FilmType(String value){
        this.value = value;

    }

    public String toValue(){
        return value;
    }




}
