package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

//
@Entity
//@Getter
@Table(name = "TB_PACIENTES")
public class PacienteModel extends RepresentationModel<PacienteModel> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPaciente;

    @Size(min = 14, max = 14, message = "{Size.paciente.cpf}")
    @ValidateCPF (message = "{Validate.paciente.cpf}") //todo adicionar validation cpf
    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @ValidateEmail(message = "{Validate.paciente.email}") //todo adicionar validation email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false, unique = false)
    private String senha;

    @NotEmpty
    @Column(nullable = false, unique = false)
    private String nome;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String telefone;

    @NotEmpty
    @Column(nullable = false, unique = false, length = 1)
    private String sexo;

    @ValidateDataNascimento(message = "{Validate.paciente.datanascimento}") //todo validacao da data de nascimento
    @NotNull
    @Column(nullable = false, unique = false)
    private Date dataNascimento;

    public UUID getIdPaciente() {return idPaciente;}

    public void setIdPaciente(UUID idPaciente) {this.idPaciente = idPaciente;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public Date getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(Date dataNascimento) {this.dataNascimento = dataNascimento;}
}