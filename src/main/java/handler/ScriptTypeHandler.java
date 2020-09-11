package handler;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import common.ScriptType;

import java.lang.reflect.Type;

public class ScriptTypeHandler implements JsonDeserializer<ScriptType> {
    @Override
    public ScriptType deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return ScriptType.parse(json.getAsString());
    }
}
