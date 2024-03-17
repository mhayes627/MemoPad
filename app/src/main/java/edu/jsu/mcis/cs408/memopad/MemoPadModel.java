package edu.jsu.mcis.cs408.memopad;

public class MemoPadModel extends AbstractModel {

    public static final String TAG = "MemoPadModel";

    public void addNewMemo(DatabaseHandler db, Memo memo){
        db.addMemo(memo);
        firePropertyChange(MemoPadController.ELEMENT_ADD_MEMO, null, memo);
    }

    public void deleteMemo(DatabaseHandler db, int id){
        db.deleteMemo(id);
        firePropertyChange(MemoPadController.ELEMENT_DELETE_MEMO, null, id);
    }

}
