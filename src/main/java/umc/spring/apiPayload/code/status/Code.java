package umc.spring.apiPayload.code.status;

public enum Code {
    FOOD_CATEGORY_NOT_FOUND("FOOD_CATEGORY_NOT_FOUND"),;

    private final String value;

    Code(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}