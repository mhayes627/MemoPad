package edu.jsu.mcis.cs408.memopad;

public class MemoPadModel extends AbstractModel {

    public static final String TAG = "MemoPadModel";

    public void addNewMemo(DatabaseHandler db, Memo memo){
        db.addMemo(memo);
        firePropertyChange(MemoPadController.ELEMENT_ADD_MEMO, null, memo);
    }

    public void listMemos(DatabaseHandler db){
        db.getAllMemosAsList();
    }

}
