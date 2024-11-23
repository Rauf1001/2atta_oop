package L5.model.Section;

public enum SectionType {
    COMEDY_SECTION("comedy"),
    MUSICAL_SECTION("musical"),
    ACTION_SECTION("action");

    private final String value;
    SectionType(String value){
        this.value = value;
    }
    public String toValue(){
        return value;
    }
}
