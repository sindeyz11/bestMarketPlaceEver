package com.example.project.dto.serializer;

import com.example.project.dto.response.PickupPointDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PickupPointDTOSerializer extends StdSerializer<PickupPointDTO> {

    public PickupPointDTOSerializer() {
        this(null);
    }

    public PickupPointDTOSerializer(Class<PickupPointDTO> t) {
        super(t);
    }

    @Override
    public void serialize(PickupPointDTO pickupPoint, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // todo add income depends on user role
        // https://stackoverflow.com/questions/62793553/spring-boot-customize-api-response-based-on-the-user-roles
        jgen.writeStartObject();
        jgen.writeStringField("id", String.valueOf(pickupPoint.getId()));
        jgen.writeStringField("address", pickupPoint.getAddress());
        jgen.writeStringField("manager_name", String.valueOf(pickupPoint.getManagerName()));
        jgen.writeEndObject();
    }
}