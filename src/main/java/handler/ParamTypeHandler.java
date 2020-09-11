package handler;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import common.ParamType;

import java.lang.reflect.Type;

public class ParamTypeHandler implements JsonDeserializer<ParamType> {
    @Override
    public ParamType deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return ParamType.parse(json.getAsString());
    }
}
