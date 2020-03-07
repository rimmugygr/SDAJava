package patterns.behavior.command;

public class Test {
    public static void main(String[] args) {
        MyFile myFile = new MyFile("SimpleFile.txt");
        FileOperationPerformer performer = new FileOperationPerformer();
        performer.executeOperation(new CreateFileOperation(myFile),"First entery ");
        System.out.println(myFile.getContent());
        performer.executeOperation(new UpdateFileOperation(myFile),"Second entery ");
        System.out.println(myFile.getContent());
    }
}
