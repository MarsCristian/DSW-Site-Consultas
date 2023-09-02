package dsw.trabalho.SistemaConsultasMedicas.Config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Crm;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@Component
class CrmSerdeProvider implements SerdeProvider<Crm> {
    @Override
    public JsonDeserializer<Crm> getJsonDeserializer() {
        return new JsonDeserializer<>() {
            @Override
            public Crm deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                final var value = p.getValueAsString();
                if (value == null) {
                    return null;
                }
                return new Crm(value);
            }
        };
    }
    @Override
    public Formatter<Crm> getTypedFieldFormatter() {
        return new Formatter<>() {
            @Override
            public Crm parse(String text, Locale locale) {
                return new Crm(text);
            }

            @Override
            public String print(Crm object, Locale locale) {
                return object.getCrmNumber();
            }
        };
    }

    @Override
    public JsonSerializer<Crm> getJsonSerializer() {
        return new JsonSerializer<>() {
            @Override
            public void serialize(Crm value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if (value == null) {
                    gen.writeNull();
                } else {
                    gen.writeString(value.getCrmNumber());
                }
            }
        };
    }

    @Override
    public Class<Crm> getType() {
        return Crm.class;
    }
}