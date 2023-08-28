package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;


import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.CrmConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.TelefoneConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "crm")
    @Convert(converter = CrmConverter.class)
    @NotNull
    private Crm crm;
    private String especialidade;

    private String email;
    private String senha;

    @OneToMany(mappedBy = "medico")
    private List<ConsultaModel> consultas;


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
