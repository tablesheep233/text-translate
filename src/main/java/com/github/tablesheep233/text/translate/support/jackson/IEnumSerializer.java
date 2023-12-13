package com.github.tablesheep233.text.translate.support.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.github.tablesheep233.text.translate.constant.IEnum;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * The type Enum serializer.
 *
 * @author tablesheep
 */
@JsonComponent
public class IEnumSerializer extends JsonSerializer<IEnum<?, ?>> {

    @Override
    public void serialize(IEnum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.name());
        gen.writeStringField(gen.getOutputContext().getCurrentName() + "Name", value.getMessage());
    }
}

