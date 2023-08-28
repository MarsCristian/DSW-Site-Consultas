package dsw.trabalho.SistemaConsultasMedicas.Persistence;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@SuppressWarnings("unchecked")
public interface IMedicoDao extends CrudRepository<MedicoModel, Long> {
    MedicoModel findByCrm(Crm crm);

    MedicoModel findByEmail(Email email);

    MedicoModel findByNome(String nome);

    List<MedicoModel> findAllByNome(String nome);

    List<MedicoModel> findAll();

    MedicoModel save(MedicoModel medicoModel);

    void deleteByCrm(Crm crm);
}
