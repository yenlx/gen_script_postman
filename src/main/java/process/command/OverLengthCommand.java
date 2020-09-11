package process.command;

import model.Item;
import model.PostManOutputData;
import process.interpreter.ValidateInterpreter;
import process.interpreter.ValidateOverLength;

import java.util.List;

public class OverLengthCommand extends ValidateHandler {

    @Override
    public void handler(PostManOutputData data) {
        ValidateInterpreter validateOverLength = new ValidateOverLength(data.getInputCollection());
        List<Item> items = validateOverLength.interpret(context);
        data.addAllItem(items);
    }
}
