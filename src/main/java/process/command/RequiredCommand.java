package process.command;

import model.Item;
import model.PostManOutputData;
import process.interpreter.ValidateInterpreter;
import process.interpreter.ValidateRequired;

import java.util.List;

public class RequiredCommand extends ValidateHandler {

    @Override
    public void handler(PostManOutputData data) {
        ValidateInterpreter validateRequired = new ValidateRequired(data.getInputCollection());
        List<Item> items = validateRequired.interpret(context);
        data.addAllItem(items);
    }
}
