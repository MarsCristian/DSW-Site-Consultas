package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.CpfConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.EmailConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Validators.UniqueCpf;
import dsw.trabalho.SistemaConsultasMedicas.Models.Validators.UniqueEmailPaciente;
import dsw.trabalho.SistemaConsultasMedicas.Models.Validators.UniqueTelefone;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

//
@Entity
@Data
@Table(name = "TB_PACIENTES")
public class PacienteModel extends RepresentationModel<PacienteModel> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPaciente;

    @Column(name = "cpf")
    @UniqueCpf(message = "{Unique.paciente.cpf}")
    @Convert(converter = CpfConverter.class)
    @NotNull Cpf cpf;

    @Column(name = "email")
    @UniqueEmailPaciente(message = "{Unique.paciente.email}")
    @Convert(converter = EmailConverter.class)
    @NotNull
    private Email email;
    private String senha;


    @Column(name = "telefone")
    @UniqueTelefone(message = "{Unique.paciente.telefone}")
    @Convert(converter = TelefoneConverter.class)
    @NotNull
    private Telefone telefone;


    private String sexo;
    private String dataNascimento;

    public UUID getIdPaciente() {return idPaciente;}

    public void setIdPaciente(UUID idPaciente) {this.idPaciente = idPaciente;}

    public Cpf getCpf() {return cpf;}

    public void setCpf(Cpf cpf) {this.cpf = cpf;}

    public Email getEmail() {return email;}

    public void setEmail(Email email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public Telefone getTelefone() {return telefone;}

    public void setTelefone(Telefone telefone) {this.telefone = telefone;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
}