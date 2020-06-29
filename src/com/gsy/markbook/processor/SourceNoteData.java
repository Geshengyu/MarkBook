package com.gsy.markbook.processor;

import com.gsy.markbook.data.NoteData;

import java.util.List;

public interface SourceNoteData {
    public String getFileName();

    public String getTopic();

    public List<NoteData> getNoteList();
}
