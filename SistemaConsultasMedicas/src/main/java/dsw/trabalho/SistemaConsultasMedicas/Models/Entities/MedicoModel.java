package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;


import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.CrmConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.EmailConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.UniqueCrm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.UniqueEmailMedico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_MEDICOS")
public class MedicoModel extends RepresentationModel<MedicoModel> implements Serializable {
    //todo crm e especialidade
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedico;//todo trocar de string pra value object
    private String nome;

    @UniqueCrm(message = "{Unique.medico.crm}")
    @Column(name = "crm",unique = true,nullable = false)
    @Convert(converter = CrmConverter.class)
    @NotNull
    private Crm crm;
    private String especialidade;

    @UniqueEmailMedico(message = "O email deve ser unico")
    @Column(name = "email",unique = true,nullable = false)
    @Convert(converter = EmailConverter.class)
    @NotNull
    private Email email;
    private String senha;

    //@OneToMany(mappedBy = "medico")
    //private List<ConsultaModel> consultas;


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

    public Crm getCrm() {return crm;}

    public void setCrm(Crm crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
