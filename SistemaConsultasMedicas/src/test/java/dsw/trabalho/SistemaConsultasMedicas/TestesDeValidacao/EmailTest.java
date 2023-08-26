package dsw.trabalho.SistemaConsultasMedicas.TestesDeValidacao;

import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.EmailParsingException;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @ParameterizedTest
    @CsvSource({
            "username+something@domain.com, username+something@domain.com",
            "jao@estudante.ufscar.br, jao@estudante.ufscar.br",
            "alow@hotmail.com, alow@hotmail.com",
    })
        //input,expected output
    void DeveAnalisarOEmailDeFormaCorreta(String input, String expectedOutput) {
        final var email = assertDoesNotThrow(
                () -> new Email(input)
        );
        assertEquals(expectedOutput, email.getEmail());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a@a", "-1", "jota.com","email@a@a@a.net"
    })
    void DeveDarThrowExceptionSeOEmailForInvalido(String input) {
        assertThrows(
                EmailParsingException.class,
                () -> new Email(input)
        );
    }
}