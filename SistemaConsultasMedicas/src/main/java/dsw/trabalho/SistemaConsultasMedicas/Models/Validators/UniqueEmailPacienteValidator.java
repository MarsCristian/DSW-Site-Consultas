package dsw.trabalho.SistemaConsultasMedicas.Models.Validators;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IPacienteDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailPacienteValidator implements ConstraintValidator<UniqueEmailPaciente, Email>{

    @Autowired
    IPacienteDao dao;

    @Override
    public boolean isValid(Email email, ConstraintValidatorContext context) {
        if (dao != null) {
            PacienteModel paciente = dao.findByEmail(email);
            return paciente == null;
        } else {
            return true;
        }
    }
}
