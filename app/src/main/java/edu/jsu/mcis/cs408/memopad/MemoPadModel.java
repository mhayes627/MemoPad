package edu.jsu.mcis.cs408.memopad;

import android.util.Log;

import androidx.annotation.NonNull;

public class MemoPadModel extends AbstractModel {

    public static final String TAG = "MemoPadModel";

    private int id;
    private final String memo;
    private DatabaseHandler db;

    public MemoPadModel(int id, String memo) {

        this.id = id;
        this.memo = memo;

    }

    public MemoPadModel(String memo) {

        this.memo = memo;

    }

    public String getMemo() {
        return memo;
    }

    @NonNull
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("#").append(id).append(": ");
        s.append(memo);
        return s.toString();

    }

    public void addNewMemo(MemoPadModel memo){
        db.addMemo(memo);
    }

    public MemoPadModel deleteMemo(MemoPadModel memo){

        return memo;
    }

    public void listMemos(){
        db.getAllMemosAsList();
    }

}
