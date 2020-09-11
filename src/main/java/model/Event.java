package model;

import common.ScriptType;
import common.ValidateType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import static common.Utils.buildTestScript;

@Getter
@Setter
@NoArgsConstructor
public class Event {
    private String listen;
    private Script script;

    public static Event eventTestBuild(InputParam inputParam, ValidateType validateType) {
        Event event = new Event();
        event.setListen(ScriptType.TEST.getIndex());
        Script testScript = new Script();
        testScript.setId(UUID.randomUUID());
        testScript.setType("text/javascript");
        testScript.setExec(buildTestScript(inputParam, validateType));

        event.setScript(testScript);
        return event;
    }

    public static Event eventPreBuild(InputParam inputParam, ValidateType validateType) {
        Event event = new Event();
        event.setListen(ScriptType.PREREQUEST.getIndex());
        Script testScript = new Script();
        testScript.setId(UUID.randomUUID());
        testScript.setType("text/javascript");
        testScript.setExec(buildTestScript(inputParam, validateType));

        event.setScript(testScript);
        return event;
    }

}
