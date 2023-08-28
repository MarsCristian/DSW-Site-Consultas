package dsw.trabalho.SistemaConsultasMedicas.Repositories;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.ConsultaModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, UUID> {
    @Query(value = "SELECT * FROM TB_MEDICOS medicos WHERE medicos.especialidade = :especialidade", nativeQuery = true)
    public List<MedicoModel> findByEspecialidade(@Param("especialidade") String especialidade);
}
