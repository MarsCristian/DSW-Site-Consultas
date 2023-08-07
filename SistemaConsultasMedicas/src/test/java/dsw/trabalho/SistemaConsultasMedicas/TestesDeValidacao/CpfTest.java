package dsw.trabalho.SistemaConsultasMedicas.TestesDeValidacao;

import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.CPFParsingException;
import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.PhoneNumberParsingException;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Cpf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CpfTest {
    @ParameterizedTest
    @CsvSource({
            "592.115.551-91,59211555191",
            "59211555191,59211555191",
            "643.602.438-71,64360243871",
    })
        //input,expected output
    void DeveAnalisarOCPFdeFormaCorreta(String input, String expectedOutput) {
        final var cpf = assertDoesNotThrow(
                () -> new Cpf(input)
        );
        assertEquals(expectedOutput, cpf.getValor());
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "592.115.551-92", "-1", "-56"
    })
    void DeveDarThrowExceptionSeOTelefoneForInvalido(String input) {
        assertThrows(
                CPFParsingException.class,
                () -> new Cpf(input)
        );
    }
}
