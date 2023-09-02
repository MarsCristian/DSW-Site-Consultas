package dsw.trabalho.SistemaConsultasMedicas.Persistence;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.ConsultaModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unchecked")
public interface IConsultaDao extends CrudRepository<ConsultaModel, Long> {

    ConsultaModel findByMedico(MedicoModel medico);

    ConsultaModel findByPaciente(PacienteModel paciente);

    ConsultaModel findByDataConsultaAndHorarioConsulta(String dataConsulta, String horarioConsulta);

    List<ConsultaModel> findAll();

    ConsultaModel save(ConsultaModel consultaModel);

    void deleteById(UUID id);
}
