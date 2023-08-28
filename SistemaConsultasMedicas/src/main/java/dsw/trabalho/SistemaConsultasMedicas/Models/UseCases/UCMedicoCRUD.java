package dsw.trabalho.SistemaConsultasMedicas.Models.UseCases;

import dsw.trabalho.SistemaConsultasMedicas.Controllers.MedicoController;
import dsw.trabalho.SistemaConsultasMedicas.Dtos.MedicoRecordDto;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UCMedicoCRUD extends CrudRepository<MedicoRecordDto, Long> {

    MedicoRecordDto findByCrm(@NotNull Crm crm);

    MedicoRecordDto findByEmail(@NotNull Email email);

    List<MedicoRecordDto> findAllByEspecialidade(@NotBlank String especialidade);

    MedicoRecordDto findByNome(@NotBlank String nome);

    void deleteByCrm(@NotNull Crm crm);
}