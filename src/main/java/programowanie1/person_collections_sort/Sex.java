package programowanie1.person_collections_sort;

public enum Sex {
    WOMAN("W","woman","kobieta",1),
    MAN("M","man","mezczyzna",2);
    private String shortName;
    private String englishName;
    private String polishName;
    private int index;

    Sex(String shortName, String englishName, String polishName, int index) {
        this.shortName = shortName;
        this.englishName = englishName;
        this.polishName = polishName;
        this.index = index;
    }

    public static Sex getByShortName(String sexShortName) {
        for(Sex s : Sex.values()){
            if(s.getShortName().equals(sexShortName))return s;
        }
        return null;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPolishName() { return polishName; }

    public void setPolishName(String polishName) {
        this.polishName = polishName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
