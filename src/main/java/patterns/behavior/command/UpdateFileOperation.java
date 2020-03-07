package patterns.behavior.command;

public class UpdateFileOperation implements FileOperation {
    private MyFile myFile;

    public UpdateFileOperation(MyFile myFile) {
        this.myFile = myFile;
    }

    @Override
    public String performOperation(String content) {
        return myFile.updateFile(content);
    }
}
