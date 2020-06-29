package com.gsy.markbook.data;

public class NoteData {
    private String title;
    private String content;
    private String text;
    private String fileName;
    private String fileType;

    public NoteData(String title, String content, String text, String fileName, String fileType) {
        this.title = title;
        this.content = content;
        this.text = text;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getText() {
        return text;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return "NoteData{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", text='" + text + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
