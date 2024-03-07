package edu.jsu.mcis.cs408.memopad;

import android.util.Log;

import androidx.annotation.NonNull;

public class MemoPadModel extends AbstractModel {

    public static final String TAG = "DefaultModel";

    private int id;
    private final String note;

    public MemoPadModel(int id, String note) {

        this.id = id;
        this.note = note;

    }

    public MemoPadModel(String note) {

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
