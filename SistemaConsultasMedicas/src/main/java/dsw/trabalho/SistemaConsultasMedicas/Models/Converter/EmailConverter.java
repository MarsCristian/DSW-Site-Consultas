package dsw.trabalho.SistemaConsultasMedicas.Models.Converter;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Email;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//usando conversores de objetos como o telefone para string para facilitar na hora de mandar pro BD
@Converter
public class EmailConverter implements AttributeConverter<Email,String> {

    //converter de objeto pra string
    @Override
    public String convertToDatabaseColumn(Email atributo){
        return atributo.getEmail();
    }

    //converter de string pra objeto
    @Override
    public Email convertToEntityAttribute(String dbData) {
        return new Email(dbData);
    }

}
