package dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions;

public class EmailParsingException extends RuntimeException {
    public EmailParsingException() {
    }

    public EmailParsingException(String message) {
        super(message);
    }

    public EmailParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailParsingException(Throwable cause) {
        super(cause);
    }

    public EmailParsingException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
