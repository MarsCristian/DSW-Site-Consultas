package dsw.trabalho.SistemaConsultasMedicas.Persistence;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Cpf;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@SuppressWarnings("unchecked")
public interface IPacienteDao extends CrudRepository<PacienteModel, Long> {

    PacienteModel findByCpf(Cpf cpf);

    PacienteModel findByEmail(Email email);

    PacienteModel findByTelefone(Telefone telefone);

    List<PacienteModel> findAll();

    PacienteModel save(PacienteModel pacienteModel);

    void deleteByCpf(Cpf cpf);
}
