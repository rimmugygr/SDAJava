package patterns.behavior.method;

public class Test {
    public static void main(String[] args) {
        EmailNewsProvider provider = new EmailNewsProvider();
        provider.sendEmailContent("Mail cocntent");
        provider.providedNews();

    }
}
