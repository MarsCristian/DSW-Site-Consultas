package dsw.trabalho.SistemaConsultasMedicas.Config;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import org.springframework.format.Formatter;


public interface SerdeProvider<T> {
    JsonDeserializer<T> getJsonDeserializer();

    Formatter<T> getTypedFieldFormatter();

    JsonSerializer<T> getJsonSerializer();

    //Formatter<T> getTypedFieldFormatter();
    Class<T> getType();
}
