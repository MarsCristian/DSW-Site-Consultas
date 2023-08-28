package dsw.trabalho.SistemaConsultasMedicas.Models.Validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueCrmValidator.class)
@Target(ElementType.FIELD)
public @interface UniqueCrm {

    String message() default "CRM já em uso";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
