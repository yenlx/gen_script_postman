package common;

public enum ValidateType {
    REQUIRED("required"),
    WRONG_FORMAT(""),
    OVER_LENGTH("overlength"),
    INVALID_FORMAT("");

    private String index;

    ValidateType(String index) {
        this.index = index;
    }

    public static ValidateType parse(String index) {
        ValidateType[] values = ValidateType.values();
        for (ValidateType value : values) {
            if (value.index.equals(index)) return value;
        }
        return REQUIRED;
    }

    public String getIndex() {
        return index;
    }
}
