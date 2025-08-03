package data;

public enum Language {
    RU("Найдите свою семью.\n" +
            "Узнайте что-то о самом себе."),
    En("Найдите свою семью.\n" +
            "Узнайте что-то о самом себе.");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}
