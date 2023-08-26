package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.regex.Pattern;

@Value
@Schema(implementation = String.class, description = "CRM")
public class Crm {
    String crmNumber;

    public Crm(String crm) {
        this.crmNumber = validateCRM(crm);

    }

    private static String validateCRM(String crm) {
        String regex = "\\d{6}CRM/[A-Z]{2}";
        Pattern pattern = Pattern.compile(regex);

        if(!pattern.matcher(crm).matches()){
            throw new IllegalArgumentException("Formato de CRM inválido");
        }

        return crm;
    }
}