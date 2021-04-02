package utility;

import commands.*;
import exceptions.IncorrectScriptException;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<Command> commandArrayList = new ArrayList<>();
    private InsertCommand insertCommand;
    private ShowCommand showCommand;
    private ExitCommand exitCommand;
    private UpdateIDCommand updateIDCommand;
    private InfoCommand infoCommand;
    private ClearCommand clearCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private FilterGreaterThanAveragePointCommand filterGreaterThanAveragePointCommand;
    private GroupCountingByCreationDateCommand groupCountingByCreationDateCommand;
    private HelpCommand helpCommand;
    private PrintDescendingCommand printDescendingCommand;
    private RemoveGreaterKey removeGreaterKey;
    private RemoveKeyCommand removeKeyCommand;
    private ReplaceIfGreaterCommand replaceIfGreaterCommand;
    private ReplaceIfLowerCommand replaceIfLowerCommand;
    private SaveCommand saveCommand;


    public CommandManager(
            InsertCommand insertCommand,
            ShowCommand showCommand,
            ExitCommand exitCommand,
            UpdateIDCommand updateIDCommand,
            InfoCommand infoCommand,
            ClearCommand clearCommand,
            ExecuteScriptCommand executeScriptCommand,
            FilterGreaterThanAveragePointCommand filterGreaterThanAveragePointCommand,
            GroupCountingByCreationDateCommand groupCountingByCreationDateCommand,
            HelpCommand helpCommand,
            PrintDescendingCommand printDescendingCommand,
            RemoveGreaterKey removeGreaterKey,
            RemoveKeyCommand removeKeyCommand,
            ReplaceIfGreaterCommand replaceIfGreaterCommand,
            ReplaceIfLowerCommand replaceIfLowerCommand,
            SaveCommand saveCommand
    ) {
        this.insertCommand = insertCommand;
        this.showCommand = showCommand;
        this.exitCommand = exitCommand;
        this.updateIDCommand = updateIDCommand;
        this.infoCommand = infoCommand;
        this.clearCommand = clearCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.filterGreaterThanAveragePointCommand = filterGreaterThanAveragePointCommand;
        this.groupCountingByCreationDateCommand = groupCountingByCreationDateCommand;
        this.helpCommand = helpCommand;
        this.printDescendingCommand = printDescendingCommand;
        this.removeGreaterKey = removeGreaterKey;
        this.removeKeyCommand = removeKeyCommand;
        this.replaceIfGreaterCommand = replaceIfGreaterCommand;
        this.replaceIfLowerCommand = replaceIfLowerCommand;
        this.saveCommand = saveCommand;

        commandArrayList.add(insertCommand);
        commandArrayList.add(showCommand);
        commandArrayList.add(exitCommand);
        commandArrayList.add(updateIDCommand);
        commandArrayList.add(infoCommand);
        commandArrayList.add(clearCommand);
        commandArrayList.add(executeScriptCommand);
        commandArrayList.add(filterGreaterThanAveragePointCommand);
        commandArrayList.add(groupCountingByCreationDateCommand);
        commandArrayList.add(helpCommand);
        commandArrayList.add(printDescendingCommand);
        commandArrayList.add(removeGreaterKey);
        commandArrayList.add(removeKeyCommand);
        commandArrayList.add(replaceIfGreaterCommand);
        commandArrayList.add(replaceIfLowerCommand);
        commandArrayList.add(saveCommand);
    }

    public void insertLWToCollection(String arg) throws IncorrectScriptException {
        try {
            insertCommand.execute(arg);
        } catch (IncorrectScriptException e) {
            throw new IncorrectScriptException();
        }

    }

    public void help(String argument) {
        if (argument.equals("")) {
            helpCommand.execute(argument);
            for (Command command : commandArrayList) {
                System.out.println(command.getName() + command.getDescription());
            }
        } else {
            helpCommand.execute(argument);
        }
    }

    public void showCollection(String arg) {
        showCommand.execute(arg);
    }

    public void info(String arg) {
        infoCommand.execute(arg);
    }

    public void remove_key(String s) {
        removeKeyCommand.execute(s);
    }

    public void clear(String s) {
        clearCommand.execute(s);
    }

    public void save(String s) {
        saveCommand.execute(s);
    }

    public void execute_script(String s) {
        executeScriptCommand.execute(s);
    }

    public void exit(String s) {
        exitCommand.execute(s);
    }

    public void replace_if_greater(String s) throws IncorrectScriptException{
        try {
            replaceIfGreaterCommand.execute(s);
        } catch (IncorrectScriptException e) {
            throw new IncorrectScriptException();
        }
    }

    public void replace_if_lowe(String s) throws IncorrectScriptException{
        try {
            replaceIfLowerCommand.execute(s);
        } catch (IncorrectScriptException e) {
            throw new IncorrectScriptException();
        }
    }

    public void remove_greater_key(String s) {
        removeGreaterKey.execute(s);
    }

    public void group_counting_by_creation_date(String s) {
        groupCountingByCreationDateCommand.execute(s);
    }

    public void filter_greater_than_average_point(String s) {
        filterGreaterThanAveragePointCommand.execute(s);
    }

    public void print_descending(String s) {
        printDescendingCommand.execute(s);
    }
}
