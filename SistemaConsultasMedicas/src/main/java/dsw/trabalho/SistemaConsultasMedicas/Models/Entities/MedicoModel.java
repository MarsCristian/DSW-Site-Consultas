package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_MEDICOS")
public class MedicoModel extends RepresentationModel<MedicoModel> implements Serializable {
    //todo crm e especialidade
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedico;//todo trocar de string pra value object

    @NotEmpty
    @Column(nullable = false, unique = false)
    private String nome;

    @Size(min = 13, max = 13, message = ("{Size.medico.crm}"))
    @ValidateCRM(message = "{Validate.medico.crm}") //todo adicionar validation crm
    @NotBlank
    @Column(nullable = false, unique = true)
    private String crm;

    @NotEmpty
    @Column(nullable = false, unique = false)
    private String especialidade;

    @ValidateEmail(message = "{Validate.medico.email}") //todo adicionar validation email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(nullable = false, unique = false)
    private String senha;


    public UUID getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(UUID idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
