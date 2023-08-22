package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter

@Table(name = "pacientes")

public class PacienteModel {
    //todo colocar aqui cpf = id, telefone, sexo, data de nascimento
    @Id
    private UUID id;


    @Column(name = "telefone")
    @Convert(converter = TelefoneConverter.class)
    @NotNull
    private Telefone phoneNumber;
}
//TODO mexer no Paciente