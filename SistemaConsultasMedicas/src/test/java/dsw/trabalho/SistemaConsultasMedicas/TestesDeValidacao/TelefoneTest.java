package dsw.trabalho.SistemaConsultasMedicas.TestesDeValidacao;

import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.PhoneNumberParsingException;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TelefoneTest {
    @ParameterizedTest
    @CsvSource({
            "5511998877665,5511998877665",
            "11987654321, 5511987654321",
            "+5511987654321, 5511987654321",
    })
    //input,expected output
    void DeveAnalisarOTelefoneDeFormaCorreta(String input, String expectedOutput) {
        final var phoneNumber = assertDoesNotThrow(
                () -> new Telefone(input)
        );
        assertEquals(expectedOutput, phoneNumber.getValor());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0", "-1", "-56"
    })
    void DeveDarThrowExceptionSeOTelefoneForInvalido(String input) {
        assertThrows(
                PhoneNumberParsingException.class,
                () -> new Telefone(input)
        );
    }
}
