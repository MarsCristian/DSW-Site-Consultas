package dsw.trabalho.SistemaConsultasMedicas.Dtos;

import jakarta.validation.constraints.NotBlank;

public record PacienteRecordDto(@NotBlank String cpf,
                                @NotBlank String email,
                                @NotBlank String senha,
                                @NotBlank String telefone,
                                @NotBlank String sexo,
                                @NotBlank String dataNacimento)
{
}
