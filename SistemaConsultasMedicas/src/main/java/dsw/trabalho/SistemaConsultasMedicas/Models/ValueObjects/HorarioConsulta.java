package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.EmailParsingException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.regex.Pattern;

@Value
@Schema(implementation = String.class, description = "horarioConsulta")
public class HorarioConsulta {

    String horarioNumber;

    private static final String padraoRegex = "([01]\\d|2[0-3]):(00|30)";

    public HorarioConsulta(String horario){
        this.horarioNumber = validarNormalizarHorario(horario);
    }

    private static String validarNormalizarHorario(String horario){
        try{
            //nao pode ser vazio
            if(horario == null || horario.isEmpty()){
                throw new EmailParsingException("Horario em branco ");//todo criar mensagem de telefone negativo
            }

            Pattern pattern = Pattern.compile(padraoRegex);

            if(!pattern.matcher(horario).matches()){ //se nao faz parte do regex
                throw new EmailParsingException("email esta errado ");//todo criar mensagem de telefone negativo
            }

            //se ta tudo certo retorna
            return horario;

        }catch (EmailParsingException e)
        {
            throw new EmailParsingException("Horario isn't valid: " + horario, e);//todo criar mensagem de telefone negativo
        }
    }
}
