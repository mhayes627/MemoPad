package edu.jsu.mcis.cs408.memopad;

public class MemoPadController extends AbstractController
{
    private final MemoPadModel model;

    public MemoPadController(MemoPadModel model) {
        super();
        this.model = model;
        addModel(model);
    }

}
