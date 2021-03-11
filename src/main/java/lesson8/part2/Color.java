package lesson8.part2;

public enum Color  {
    BLACK("черный", "black"), WHITE("белый", "white"), RED("рыжий", "red");

    private String russianColor;
    private String englishColor;

    Color(String russianColor, String englishColor) {
        this.russianColor = russianColor;
        this.englishColor = englishColor;
    }

    public String getRussianColor() {
        return russianColor;
    }

    public String getEnglishColor() {
        return englishColor;
    }

    @Override
    public String toString() {
        return "Color" + name()+ "{" + "russianColor='" + russianColor + '\'' + ", englishColor='" + englishColor + '\'' + '}';
    }
}
