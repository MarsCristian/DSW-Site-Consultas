package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.EmailParsingException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.regex.Pattern;

@Value
@Schema(implementation = String.class, description = "horarioConsulta")
public class HorarioConsulta {

    String horarioNumber;

    public HorarioConsulta(String horario){
        this.horarioNumber = validarNormalizarHorario(horario);
    }

    private static String validarNormalizarHorario(String horario) {
        String regex = "([01]\\d|2[0-3]):(00|30)";
        Pattern pattern = Pattern.compile(regex);

        if(!pattern.matcher(horario).matches()){
            throw new IllegalArgumentException("Formato de CRM inválido");
        }

        return horario;
    }
}
