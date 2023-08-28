package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IPacienteDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueCpfValidator implements ConstraintValidator<UniqueCpf, Cpf> {

    @Autowired
    IPacienteDao dao;

    @Override
    public boolean isValid(Cpf cpf, ConstraintValidatorContext context) {
        if (dao != null) {
            PacienteModel paciente = dao.findByCpf(cpf);
            return paciente == null;
        } else {
            return true;
        }
    }
}
