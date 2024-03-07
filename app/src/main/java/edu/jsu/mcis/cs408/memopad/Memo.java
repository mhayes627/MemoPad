package edu.jsu.mcis.cs408.memopad;

import androidx.annotation.NonNull;

public class Memo {
    private int id;
    private final String note;

    public Memo(int id, String note) {

        this.id = id;
        this.note = note;

    }

    public Memo(String note) {

        this.note = note;

    }

    public String getNote() {
        return note;
    }

    @NonNull
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append(id).append(": ");
        s.append(note).append("\n");
        return s.toString();

    }

}
