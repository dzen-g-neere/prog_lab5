package commands;

import exceptions.IncorrectScriptException;
import utility.ConsoleManager;

public class ExecuteScriptCommand extends AbstractCommand implements Command{

    public ExecuteScriptCommand() {
        super("execute_script", " file_name - считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");

    }

    @Override
    public void execute(String argument) {

    }
}
