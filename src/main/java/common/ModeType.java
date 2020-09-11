package common;

public enum ModeType {
    URLENCODED("urlencoded"),
    RAW("raw");

    private String index;

    ModeType(String index) {
        this.index = index;
    }

    public static ModeType parse(String index) {
        ModeType[] values = ModeType.values();
        for (ModeType value : values) {
            if (value.index.equals(index)) return value;
        }
        return URLENCODED;
    }

    public String getIndex() {
        return index;
    }
}
