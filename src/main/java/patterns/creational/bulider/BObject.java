package patterns.creational.bulider;

public class BObject {
    private String name;
    private String param1;
    private int param2;
    private boolean param3;

    private BObject(BObjectBulider bulider) {
        this.name = bulider.name;
        this.param1 = bulider.param1;
        this.param2 = bulider.param2;
        this.param3 = bulider.param3;
    }

    public static class BObjectBulider{
        private String name;
        private String param1;
        private int param2;
        private boolean param3;

        public BObjectBulider(String name, String param1) {
            this.name = name;
            this.param1 = param1;
        }

        public BObjectBulider setParam2(int param2) {
            this.param2 = param2;
            return this;
        }

        public BObjectBulider setParam3(boolean param3) {
            this.param3 = param3;
            return this;
        }

        public BObject bulid(){
            return new BObject(this);
        }
    }

    @Override
    public String toString() {
        return "BObject{" +
                "name='" + name + '\'' +
                ", param1='" + param1 + '\'' +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }
}
