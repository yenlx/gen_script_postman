package common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import handler.ParamTypeHandler;
import handler.ScriptTypeHandler;
import model.InputParam;
import model.OutputPostMan;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static common.Const.LOREM;

public class Utils {

    public static <T> List<T> getListObjectFromFileJson(String path, Type type) {
        try {
            GsonBuilder builder = getGsonBuilder();
            Gson gson = builder.create();
            JsonReader reader = new JsonReader(new FileReader(path));
            return gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            System.out.println("====CAN'T READ AND EXTRACT FILE====");
        }
        return Collections.EMPTY_LIST;
    }

    public static <T> T getObjectFromFileJson(String path, Class<T> clazz) {
        try {
            GsonBuilder builder = getGsonBuilder();
            Gson gson = builder.create();
            JsonReader reader = new JsonReader(new FileReader(path));
            return gson.fromJson(reader, clazz);
        } catch (FileNotFoundException e) {
            System.out.println("====CAN'T READ AND EXTRACT FILE====");
        }
        return null;
    }

    private static GsonBuilder getGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        addDeserializer(builder);
        return builder;
    }

    private static void addDeserializer(GsonBuilder gsonBuilder) {
        gsonBuilder.registerTypeAdapter(ParamType.class, new ParamTypeHandler());
        gsonBuilder.registerTypeAdapter(ScriptType.class, new ScriptTypeHandler());
    }

    public static List<String> buildTestScript(InputParam param, ValidateType validateType) {
        String builder = "let res = pm.response.json();\r" +
                "   pm.test(\"" + param.getName() + " " + validateType.name() + "\" , function(){\r" +
                "   pm.expect(res.data." + param.getName() + ".key).to.be.eql('" + validateType.getIndex() + "');\r" +
                "})\r";
        return Arrays.asList(builder.split("\r"));
    }

    public static void writeFile(OutputPostMan out) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonString = gson.toJson(out);
        File file = new File("../" + out.getInfo().getName() + ".json");
        try {
            FileUtils.writeStringToFile(file, prettyJsonString, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String genInvalidValueParams(ValidateType type, int length, String name) {
        switch (type) {
            case REQUIRED:
                return "";
            case OVER_LENGTH:
                return LOREM.substring(0, length + 1);
            case WRONG_FORMAT:
                return "";
            case INVALID_FORMAT:
                return "";
        }
        return "";
    }

}
