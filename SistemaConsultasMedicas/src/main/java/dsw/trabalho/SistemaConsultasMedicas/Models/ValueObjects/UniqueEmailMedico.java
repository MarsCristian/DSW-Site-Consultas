package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailPacienteValidator.class)
@Target(ElementType.FIELD)
public @interface UniqueEmailMedico {

    String message() default "Email já em uso";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
