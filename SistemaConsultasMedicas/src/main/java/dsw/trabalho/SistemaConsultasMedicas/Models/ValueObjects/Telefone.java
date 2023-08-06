package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.PhoneNumberParsingException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import static com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164;

@Value
@Schema(implementation = String.class, description = "Telefone")
public class Telefone {

    //using Google's phone number validation library
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    String valor;

    public Telefone(String valor){
        this.valor = validarNormalizarTelefone(valor);
    }

    //validate and normalize the phone number
    private static String validarNormalizarTelefone(String valor){
        try{
            //value cannot be negative
            if(Long.parseLong(valor) <= 0){
                throw new PhoneNumberParsingException("The phone number cannot be negative: " + valor);//todo criar mensagem de telefone negativo
            }
            final var telefone = PHONE_NUMBER_UTIL.parse(valor,"BR");
            final String telefoneFormatado = PHONE_NUMBER_UTIL.format(telefone, E164);

            return telefoneFormatado.substring(1);
        } catch (NumberParseException | NumberFormatException e) { //invalid number
            throw new PhoneNumberParsingException("The phone number isn't valid: " + valor, e);//todo criar mensagem de telefone invalido
        }
    }
}
