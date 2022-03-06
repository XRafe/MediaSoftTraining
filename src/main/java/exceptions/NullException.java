package exceptions;

public class NullException extends Exception{

    private Integer twoArg = 0;

    public Integer getTwoArg() {
        return twoArg;
    }

    public NullException(String message, Integer twoArg) {
        super(message);
        this.twoArg = twoArg;
    }
}
