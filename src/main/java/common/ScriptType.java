package common;

public enum ScriptType {
    PREREQUEST("prerequest"),
    TEST("test");

    private String index;

    ScriptType(String index) {
        this.index = index;
    }

    public static ScriptType parse(String index) {
        ScriptType[] values = ScriptType.values();
        for (ScriptType value : values) {
            if (value.index.equals(index)) return value;
        }
        return TEST;
    }

    public String getIndex() {
        return index;
    }
}
