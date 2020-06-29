package com.gsy.markbook.processor;

import com.gsy.markbook.data.NoteData;

import java.util.List;

public class DefaultSourceData implements SourceNoteData {
    private String fileName;

    private String topic;

    private List<NoteData> noteList;

    public DefaultSourceData(String fileName, String topic, List<NoteData> noteList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteList = noteList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }
}

