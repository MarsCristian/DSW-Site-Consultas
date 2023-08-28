package dsw.trabalho.SistemaConsultasMedicas.Models.Validators;

import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.ConsultaModel;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Cpf;
import dsw.trabalho.SistemaConsultasMedicas.Persistence.IConsultaDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueConsultaValidator implements ConstraintValidator<UniqueConsulta, ConsultaModel> {

    @Autowired
    IConsultaDao dao;
    @Override
    public boolean isValid(ConsultaModel value, ConstraintValidatorContext context) {

        String data = value.getDataConsulta();
        String hora = value.getHorarioConsulta();

        if(dao != null){
            ConsultaModel consulta = dao.findByDataConsultaAndHorarioConsulta(data, hora);
            return consulta == null;
        }else{
            return true;
        }
    }
}
