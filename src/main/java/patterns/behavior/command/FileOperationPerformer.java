package patterns.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class FileOperationPerformer {
    private final List<FileOperation> fileOperations = new ArrayList<>();

    public String executeOperation(FileOperation fileOperation,String content){
        fileOperations.add(fileOperation);
        return fileOperation.performOperation(content);
    }

    public List<FileOperation> getFileOperations() {
        return fileOperations;
    }
}
