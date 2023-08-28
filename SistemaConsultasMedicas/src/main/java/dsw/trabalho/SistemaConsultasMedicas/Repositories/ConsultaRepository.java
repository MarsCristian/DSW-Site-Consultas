package dsw.trabalho.SistemaConsultasMedicas.Repositories;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.ConsultaModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, UUID> {
    @Query(value = "SELECT * FROM TB_CONSULTA consulta WHERE consulta.id_medico = :medico", nativeQuery = true)
    public List<ConsultaModel> findByMedico(@Param("medico") UUID medico);

    @Query(value = "SELECT * FROM TB_CONSULTA consulta WHERE consulta.id_paciente = :paciente", nativeQuery = true)
    public List<ConsultaModel> findByPaciente(@Param("paciente") UUID paciente);
    @Query(value = "SELECT CONCAT(consulta.data_consulta, '', consulta.horario_consulta, '', consulta.id_medico, '') FROM TB_CONSULTA consulta WHERE consulta.id_medico = :medico", nativeQuery = true)
    public List<String> validarData(@Param("medico") UUID medico);
}
