package process.command;

public interface ConcatCommand extends Command {
    void addCommand(Command command);
}
