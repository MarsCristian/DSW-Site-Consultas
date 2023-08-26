package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
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
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String sexo;
    private String dataNascimento;

    public UUID getIdPaciente() {return idPaciente;}

    public void setIdPaciente(UUID idPaciente) {this.idPaciente = idPaciente;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {this.senha = senha;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getDataNascimento() {return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento;}
}