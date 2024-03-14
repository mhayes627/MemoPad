package edu.jsu.mcis.cs408.memopad;

import android.util.Log;

import androidx.annotation.NonNull;

public class MemoPadModel extends AbstractModel {

    public static final String TAG = "MemoPadModel";

    private int id;
    private final String note;
    private DatabaseHandler db;

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

    public void addNewMemo(Memo memo){
        db.addMemo(memo);
    }

    public Memo deleteMemo(Memo memo){

        return memo;
    }

    public void listMemos(){
        db.getAllMemosAsList();
    }

}
