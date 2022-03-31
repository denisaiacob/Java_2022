package lab5;
public class IncorrectInstance extends Exception{
    public IncorrectInstance(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
