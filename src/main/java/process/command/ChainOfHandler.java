package process.command;

import model.Item;
import model.PostManOutputData;
import process.interpreter.ValidateBuilderContext;

import java.util.ArrayList;
import java.util.List;

public class ChainOfHandler implements ConcatCommand {
    private ValidateBuilderContext context;
    private List<Command> commands;

    public ChainOfHandler(ValidateBuilderContext context) {
        this.context = context;
        this.commands = new ArrayList<>();
    }

    @Override
    public void addCommand(Command command) {
        if (command instanceof ValidatorBuilderContextAware) {
            ((ValidatorBuilderContextAware) command).setValidatorBuildContext(context);
        }
        this.commands.add(command);
    }

    @Override
    public void handler(PostManOutputData data) {
        for (Command command : this.commands)
            command.handler(data);
    }
}
