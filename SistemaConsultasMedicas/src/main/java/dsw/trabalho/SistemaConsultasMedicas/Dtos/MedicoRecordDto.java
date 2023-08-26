package dsw.trabalho.SistemaConsultasMedicas.Dtos;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import jakarta.validation.constraints.NotBlank;

public record MedicoRecordDto( //todo mudar os tipos de variaveis
                               @NotBlank String nome,
                               @NotBlank String crm,
                               @NotBlank String especialidade,
                               @NotBlank String email,
                               @NotBlank String senha
)
{

}
