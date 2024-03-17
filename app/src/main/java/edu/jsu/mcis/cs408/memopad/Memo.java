package edu.jsu.mcis.cs408.memopad;

public class Memo {

    private int id;
    private final String memo;

    public Memo(int id, String memo) {
        this.id = id;
        this.memo = memo;
    }

    public Memo(String memo) {
        this.memo = memo;
    }

    public int getId() { return id; }

    public String getMemo() { return memo; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("#").append(id).append(": ");
        s.append(memo);
        return s.toString();
    }
}
