package process.command;

import process.interpreter.ValidateBuilderContext;

public interface ValidatorBuilderContextAware {

    void setValidatorBuildContext(ValidateBuilderContext context);
}
