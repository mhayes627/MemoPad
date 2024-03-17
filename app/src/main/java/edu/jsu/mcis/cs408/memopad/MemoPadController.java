package edu.jsu.mcis.cs408.memopad;

public class MemoPadController extends AbstractController {
    private final MemoPadModel model;
    public static final String ELEMENT_ADD_MEMO = "AddMemo";

    public MemoPadController(MemoPadModel model) {
        super();
        this.model = model;
        addModel(model);
    }

    public void addNewMemo(DatabaseHandler db, Memo memo){
        model.addNewMemo(db, memo);
    }

}
