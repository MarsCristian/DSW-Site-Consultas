package dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions;

public class CPFParsingException extends RuntimeException {
    public CPFParsingException() {
    }

    public CPFParsingException(String message) {
        super(message);
    }

    public CPFParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CPFParsingException(Throwable cause) {
        super(cause);
    }

    public CPFParsingException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
