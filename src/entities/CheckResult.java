package entities;

public class CheckResult {
    private boolean result;
    private String message;

    public CheckResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
}
