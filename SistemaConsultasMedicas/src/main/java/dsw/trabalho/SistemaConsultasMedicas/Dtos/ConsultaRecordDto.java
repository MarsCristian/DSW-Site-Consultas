package dsw.trabalho.SistemaConsultasMedicas.Dtos;

import jakarta.validation.constraints.NotBlank;

public record ConsultaRecordDto( //todo mudar os tipos de variaveis
                                 @NotBlank String crmMedico,
                                 @NotBlank String cpfPaciente,
                                 @NotBlank String dataConsulta,
                                 @NotBlank String horarioConsulta
)
{

}