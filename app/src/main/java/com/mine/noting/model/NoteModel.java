package com.mine.noting.model;

import lombok.Data;

@Data
public class NoteModel {

    private long noteId;
    private String noteContent;
    private int noteIconType;
    private long noteSavedTimestamp;
}
