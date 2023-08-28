package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(implementation = String.class, description = "horarioConsulta")
public class HorarioConsulta {

    String horarioNumber;

    public HorarioConsulta(String horario){
        this.horarioNumber = validateHorario(horario);
    }

    public static String validateHorario(String horario){
        //todo montar o validate hora
        return "aaa";
    }
}
