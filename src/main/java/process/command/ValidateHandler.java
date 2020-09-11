package process.command;

import process.interpreter.ValidateBuilderContext;

public abstract class ValidateHandler implements Command, ValidatorBuilderContextAware {
    protected ValidateBuilderContext context;

    @Override
    public void setValidatorBuildContext(ValidateBuilderContext validatorBuildContext) {
        this.context = validatorBuildContext;
    }
}
