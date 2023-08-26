package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.EmailParsingException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.regex.Pattern;


@Value
@Schema(implementation = String.class, description = "Email")
public class Email {

    private static final String padraoRegex = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
    String email;
    public Email(String email){
        this.email = validarNormalizarEmail(email);
    }

    private static String validarNormalizarEmail(String email){
        try{
            //nao pode ser vazio
            if(email == null || email.isEmpty()){
                throw new EmailParsingException("email em branco ");//todo criar mensagem de telefone negativo
            }

            Pattern pattern = Pattern.compile(padraoRegex);

            if(!pattern.matcher(email).matches()){ //se nao faz parte do regex
                throw new EmailParsingException("email esta errado ");//todo criar mensagem de telefone negativo
            }

            //se ta tudo certo retorna
            return email;

        }catch (EmailParsingException e)
        {
            throw new EmailParsingException("email isn't valid: " + email, e);//todo criar mensagem de telefone negativo
        }
    }
}
