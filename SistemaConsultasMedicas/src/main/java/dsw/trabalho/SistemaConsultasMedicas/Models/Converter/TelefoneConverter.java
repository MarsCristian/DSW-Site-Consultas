package dsw.trabalho.SistemaConsultasMedicas.Models.Converter;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//usando conversores de objetos como o telefone para string para facilitar na hora de mandar pro BD
@Converter
public class TelefoneConverter implements AttributeConverter<Telefone,String> {

    //converter de objeto pra string
    @Override
    public String convertToDatabaseColumn(Telefone atributo){
        return atributo.getValor();
    }

    //converter de string pra objeto
    @Override
    public Telefone convertToEntityAttribute(String dbData) {
        return new Telefone(dbData);
    }

}
