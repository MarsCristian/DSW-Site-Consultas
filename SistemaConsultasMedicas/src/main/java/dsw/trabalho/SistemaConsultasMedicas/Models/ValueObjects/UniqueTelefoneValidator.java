package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IPacienteDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueTelefoneValidator implements ConstraintValidator<UniqueTelefone, Telefone> {

    @Autowired
    IPacienteDao dao;

    @Override
    public boolean isValid(Telefone telefone, ConstraintValidatorContext context) {
        if (dao != null) {
            PacienteModel paciente = dao.findByTelefone(telefone);
            return paciente == null;
        } else {
            return true;
        }
    }
}
