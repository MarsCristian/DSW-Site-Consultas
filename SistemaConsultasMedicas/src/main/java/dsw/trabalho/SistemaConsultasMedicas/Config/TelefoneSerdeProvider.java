package dsw.trabalho.SistemaConsultasMedicas.Config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects.Telefone;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@Component
class TelefoneSerdeProvider implements SerdeProvider<Telefone> {
    @Override
    public JsonDeserializer<Telefone> getJsonDeserializer() {
        return new JsonDeserializer<>() {
            @Override
            public Telefone deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                final var value = p.getValueAsString();
                if (value == null) {
                    return null;
                }
                return new Telefone(value);
            }
        };
    }
    @Override
    public Formatter<Telefone> getTypedFieldFormatter() {
        return new Formatter<>() {
            @Override
            public Telefone parse(String text, Locale locale) {
                return new Telefone(text);
            }

            @Override
            public String print(Telefone object, Locale locale) {
                return object.getValor();
            }
        };
    }

    @Override
    public JsonSerializer<Telefone> getJsonSerializer() {
        return new JsonSerializer<>() {
            @Override
            public void serialize(Telefone value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if (value == null) {
                    gen.writeNull();
                } else {
                    gen.writeString(value.getValor());
                }
            }
        };
    }

    @Override
    public Class<Telefone> getType() {
        return Telefone.class;
    }
}