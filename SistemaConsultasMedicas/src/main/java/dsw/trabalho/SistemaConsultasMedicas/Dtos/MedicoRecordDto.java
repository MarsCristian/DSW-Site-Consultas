package dsw.trabalho.SistemaConsultasMedicas.Dtos;

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
