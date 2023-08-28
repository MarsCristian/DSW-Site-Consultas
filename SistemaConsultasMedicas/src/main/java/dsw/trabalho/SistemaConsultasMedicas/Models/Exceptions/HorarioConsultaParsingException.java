package dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions;

public class HorarioConsultaParsingException extends RuntimeException {
    public HorarioConsultaParsingException() {
    }

    public HorarioConsultaParsingException(String message) {
        super(message);
    }

    public HorarioConsultaParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HorarioConsultaParsingException(Throwable cause) {
        super(cause);
    }

    public HorarioConsultaParsingException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
