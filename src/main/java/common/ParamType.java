package common;

public enum ParamType {
    TEXT("text", "text"),
    ENUM("enum", "text");

    private String index;
    private String value;

    ParamType(String index, String value) {
        this.index = index;
        this.value = value;
    }

    public static ParamType parse(String index) {
        ParamType[] values = ParamType.values();
        for (ParamType value : values) {
            if (value.index.equals(index)) return value;
        }
        return TEXT;
    }

    public String getValue() {
        return value;
    }
}
