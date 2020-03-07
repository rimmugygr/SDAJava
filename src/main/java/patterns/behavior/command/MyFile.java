package patterns.behavior.command;

public class MyFile {
    private String fileName;
    private String content;

    public MyFile(String fileName) {
        this.fileName = fileName;
    }

    public String createFile(String content){
        this.content=content;
        return "Crateing file " + fileName + " with content: " + content;
    }

    public String updateFile(String content){
        this.content+=content;
        return "Update file " + fileName + " with content: " + content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
