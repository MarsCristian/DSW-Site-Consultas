package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;


import jakarta.persistence.*;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_MEDICOS")
public class MedicoModel implements Serializable {
    //todo crm e especialidade
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMedico;//todo trocar de string pra value object
    private String nome;
    private String crm;
    private String especialidade;

    private String email;
    private String senha;





}
