package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.EmailConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
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

    @Column(name = "email")
    @Convert(converter = EmailConverter.class)
    @NotNull
    private Email email;
    private String senha;
    @Column(name = "telefone")
    @Convert(converter = TelefoneConverter.class)
    @NotNull
    private Telefone telefone;
    private String sexo;
    private String dataNascimento;

    public UUID getIdPaciente() {return idPaciente;}

    public void setIdPaciente(UUID idPaciente) {this.idPaciente = idPaciente;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

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