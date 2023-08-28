package dsw.trabalho.SistemaConsultasMedicas.Models.Validators;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IMedicoDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailMedicoValidator implements ConstraintValidator<UniqueEmailMedico, Email> {

    @Autowired
    IMedicoDao dao;

    @Override
    public boolean isValid(Email email, ConstraintValidatorContext context) {
        if (dao != null) {
            MedicoModel medico = dao.findByEmail(email);
            return medico == null;
        } else {
            return true;
        }
    }
}