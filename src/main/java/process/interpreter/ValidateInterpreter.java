package process.interpreter;

import model.Item;

import java.util.List;

public interface ValidateInterpreter {
    List<Item> interpret(ValidateBuilderContext context);
}
