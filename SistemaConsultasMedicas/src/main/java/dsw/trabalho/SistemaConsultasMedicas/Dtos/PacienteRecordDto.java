package dsw.trabalho.SistemaConsultasMedicas.Dtos;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRecordDto(@NotBlank String cpf,
                                @NotNull Email email,
                                @NotBlank String senha,
                                @NotNull Telefone telefone,
                                @NotBlank String sexo,
                                @NotBlank String dataNascimento)
{
}
