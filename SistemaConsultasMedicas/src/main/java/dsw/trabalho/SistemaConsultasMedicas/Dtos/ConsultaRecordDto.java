package dsw.trabalho.SistemaConsultasMedicas.Dtos;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.HorarioConsulta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsultaRecordDto( //todo mudar os tipos de variaveis
                                 @NotNull MedicoModel medico,
                                 @NotNull PacienteModel paciente,
                                 @NotBlank String dataConsulta,
                                 @NotNull HorarioConsulta horarioConsulta
)
{

}
