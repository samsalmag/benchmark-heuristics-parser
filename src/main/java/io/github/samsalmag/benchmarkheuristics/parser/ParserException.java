package io.github.samsalmag.benchmarkheuristics.parser;

/**
 * Stores an exception thrown during parsing.
 *
 * @author Sam Salek
 */
public class ParserException {

    private final Object exception;

    public ParserException(Exception exception) {
        this.exception = exception;
    }

    public ParserException(NoClassDefFoundError exception) {
        this.exception = exception;
    }

    /**
     * Gets class name of the exception.
     *
     * @return Class name of the exception.
     */
    public String getClassName() {
        if (exception instanceof Exception) {
            Exception castException = (Exception) exception;
            return castException.getClass().getName();
        }
        else if (exception instanceof NoClassDefFoundError) {
            NoClassDefFoundError castException = (NoClassDefFoundError) exception;
            return castException.getClass().getName();
        }

        return null;
    }

    /**
     * Gets the message of the exception.
     *
     * @return Message of the exception.
     */
    public String getMessage() {
        if (exception instanceof Exception) {
            Exception castException = (Exception) exception;
            return castException.getMessage();
        }
        else if (exception instanceof NoClassDefFoundError) {
            NoClassDefFoundError castException = (NoClassDefFoundError) exception;
            return castException.getMessage();
        }

        return null;
    }

    /**
     * Gets the stack trace of the exception.
     *
     * @return Stack trace of the exception.
     */
    public StackTraceElement[] getStackTrace() {
        if (exception instanceof Exception) {
            Exception castException = (Exception) exception;
            return castException.getStackTrace();
        }
        else if (exception instanceof NoClassDefFoundError) {
            NoClassDefFoundError castException = (NoClassDefFoundError) exception;
            return castException.getStackTrace();
        }

        return new StackTraceElement[0];
    }
}
