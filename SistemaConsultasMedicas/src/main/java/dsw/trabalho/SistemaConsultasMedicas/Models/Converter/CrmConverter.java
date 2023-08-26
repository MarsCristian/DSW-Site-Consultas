package dsw.trabalho.SistemaConsultasMedicas.Models.Converter;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CrmConverter implements AttributeConverter<Crm,String>  {
    //converter de objeto pra string
    @Override
    public String convertToDatabaseColumn(Crm atributo){
        return atributo.getCrmNumber();
    }

    //converter de string pra objeto
    @Override
    public Crm convertToEntityAttribute(String dbData) {
        return new Crm(dbData);
    }
}
