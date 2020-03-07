package patterns.behavior.command;

public class CreateFileOperation implements FileOperation {
    private MyFile myFile;

    public CreateFileOperation(MyFile myFile) {
        this.myFile = myFile;
    }

    @Override
    public String performOperation(String content) {
        return myFile.createFile(content);
    }
}
