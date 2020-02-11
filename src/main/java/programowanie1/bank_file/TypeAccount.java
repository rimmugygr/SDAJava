package programowanie1.bank_file;

public enum TypeAccount {
    O("O"),
    R("R"),
    P("P"),
    T("T");
    String name;

    TypeAccount(String name) {
        this.name = name;
    }



    public static TypeAccount getByName(String name) {
        for (TypeAccount nameType : TypeAccount.values()) {
            if(nameType.getName().equals(name))return nameType;
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
