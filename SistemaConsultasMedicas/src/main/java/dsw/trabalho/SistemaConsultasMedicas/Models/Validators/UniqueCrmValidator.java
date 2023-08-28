package dsw.trabalho.SistemaConsultasMedicas.Models.Validators;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IMedicoDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueCrmValidator implements ConstraintValidator<UniqueCrm, Crm> {


    @Autowired
    IMedicoDao dao;

    @Override
    public boolean isValid(Crm crm, ConstraintValidatorContext context) {
        if (dao != null) {
            MedicoModel medico = dao.findByCrm(crm);
            return medico == null;
        } else {
            return true;
        }
    }
}
