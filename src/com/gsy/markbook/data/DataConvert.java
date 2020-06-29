package com.gsy.markbook.data;

public class DataConvert {
    public static String[] convert(NoteData noteData) {
        String[] raw = new String[4];
        raw[0] = noteData.getTitle();
        raw[1] = noteData.getContent();
        raw[2] = noteData.getFileName();
        raw[3] = noteData.getText();
        return raw;
    }
}
