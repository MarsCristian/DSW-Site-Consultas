package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.springframework.beans.factory.annotation.Value;

import static com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164;

@Value
public class Telefone {

    //usando lib do google de validacao de telefone
    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    String valor;
    public Telefone(String valor){
        this.valor = ValidarNormalizarTelefone(valor);
    }

    //validar o telefone
    private static String ValidarNormalizarTelefone(String valor){
        try{
            if(Long.parseLong(valor) <= 0){
                throw new PhoneNumberParsingException("The phone number cannot be negative: " + valor);//todo internacionalizar msg
            }
            final var Telefone = PHONE_NUMBER_UTIL.parse(valor,"BR");
            final String TelefoneFormatado = PHONE_NUMBER_UTIL.format(Telefone,E164);

            return TelefoneFormatado.substring(1);
        }
        catch (NumberParseException | NumberFormatException e) {
            throw new PhoneNumberParsingException("The phone number isn't valid: " + valor, e);//todo adicionar mensagem
        }
    }

}