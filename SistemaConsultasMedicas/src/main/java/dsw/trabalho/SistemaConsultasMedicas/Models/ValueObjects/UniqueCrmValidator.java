package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IMedicoDao;
import dsw.trabalho.SistemaConsultasMedicas.Repositories.MedicoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCrmValidator implements ConstraintValidator<UniqueCrm, Crm> {


    @Autowired
    MedicoRepository dao;

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
