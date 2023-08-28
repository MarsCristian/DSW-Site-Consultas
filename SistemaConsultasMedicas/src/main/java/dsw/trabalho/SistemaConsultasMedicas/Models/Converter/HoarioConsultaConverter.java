package dsw.trabalho.SistemaConsultasMedicas.Models.Converter;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.HorarioConsulta;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter
public class HoarioConsultaConverter implements AttributeConverter<HorarioConsulta,String> {

    //converter de objeto pra string
    @Override
    public String convertToDatabaseColumn(HorarioConsulta atributo){
        return atributo.getHorarioNumber();
    }

    //converter de string pra objeto
    @Override
    public HorarioConsulta convertToEntityAttribute(String dbData) {
        return new HorarioConsulta(dbData);
    }

}

