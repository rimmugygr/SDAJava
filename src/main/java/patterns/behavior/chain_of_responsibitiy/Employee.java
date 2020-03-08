package patterns.behavior.chain_of_responsibitiy;

public class Employee {
    private String name;
    private int level;
    private boolean department;

    public Employee(String name, int level, boolean department) {
        this.name = name;
        this.level = level;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDepartment() {
        return department;
    }

    public void setDepartment(boolean department) {
        this.department = department;
    }
}
