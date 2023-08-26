package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;


import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.CrmConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.Converter.EmailConverter;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;


import java.io.Serializable;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "TB_MEDICOS")
public class MedicoModel extends RepresentationModel<MedicoModel> implements Serializable {
    //todo crm e especialidade
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedico;//todo trocar de string pra value object
    private String nome;

    public void changeName(MedicoModel.Nome name) {
        this.nome = name.getValue();
    }
    @Column(name = "crm")
    @Convert(converter = CrmConverter.class)
    @NotNull
    private Crm crm;
    private String especialidade;
    @Column(name = "email")
    @Convert(converter = EmailConverter.class)
    @NotNull
    private Email email;
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

    public Crm getCrm() {
        return crm;
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


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Data
    @Setter(PRIVATE)
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor(access = PROTECTED)
    public static class ID implements Serializable {
        private UUID id;
    }

    @Value
    public static class Nome {
        String value;
    }

    public MedicoModel() {
        this.idMedico = idMedico;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }

    public MedicoModel(Link initialLink, UUID idMedico, String nome, Crm crm, String especialidade, Email email, String senha) {
        super(initialLink);
        this.idMedico = idMedico;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }

    public MedicoModel(Iterable<Link> initialLinks, UUID idMedico, String nome, Crm crm, String especialidade, Email email, String senha) {
        super(initialLinks);
        this.idMedico = idMedico;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }
}
