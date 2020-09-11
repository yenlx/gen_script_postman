package process.command;

import model.PostManOutputData;

public interface Command {
    void handler(PostManOutputData data);
}
