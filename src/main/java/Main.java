import common.Utils;
import model.InputCollection;
import model.PostManOutputData;
import process.command.ChainOfHandler;
import process.command.OverLengthCommand;
import process.command.RequiredCommand;
import process.interpreter.ValidateBuilderContext;

import java.util.ArrayList;

import static common.Const.PATH_INPUT_DATA;
import static common.Utils.getObjectFromFileJson;

public class Main {
    public static void main(String[] args) {
        InputCollection collection = getObjectFromFileJson(PATH_INPUT_DATA, InputCollection.class);
        if (collection != null) {
            PostManOutputData data = new PostManOutputData(collection, new ArrayList<>());
            genScript(data);
            Utils.writeFile(data.outputPostMan());
        }
    }

    private static void genScript(PostManOutputData data) {
        ChainOfHandler chain = new ChainOfHandler(new ValidateBuilderContext());
        chain.addCommand(new RequiredCommand());
        chain.addCommand(new OverLengthCommand());
        chain.handler(data);
    }
}
