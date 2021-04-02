package run;

import commands.*;
import utility.*;

import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program.
 * @author Дмитрий Залевский P3112
 */
public class Main {

    public static void main(String[] args) {
//        String[] heh = (" ;;;;").split(";");
//        System.out.println(heh.length);
        Scanner userScanner = new Scanner(System.in);
        final String envVariable = "data.csv";
        //FileManager fileManager = new FileManager(envVariable);
        LabWorkAsker labWorkAsker = new LabWorkAsker(userScanner);
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager(
                new InsertCommand(collectionManager, labWorkAsker),
                new ShowCommand(collectionManager),
                new ExitCommand(),
                new UpdateIDCommand(collectionManager, labWorkAsker),
                new InfoCommand(collectionManager),
                new ClearCommand(collectionManager),
                new ExecuteScriptCommand(),
                new FilterGreaterThanAveragePointCommand(collectionManager),
                new GroupCountingByCreationDateCommand(collectionManager),
                new HelpCommand(),
                new PrintDescendingCommand(collectionManager),
                new RemoveGreaterKey(collectionManager),
                new RemoveKeyCommand(collectionManager),
                new ReplaceIfGreaterCommand(collectionManager, labWorkAsker),
                new ReplaceIfLowerCommand(collectionManager, labWorkAsker),
                new SaveCommand(collectionManager)
        );
//        InsertCommand insertCommand,
//        ShowCommand showCommand,
//        ExitCommand exitCommand,
//        UpdateIDCommand updateIDCommand,
//        InfoCommand infoCommand,
//        ClearCommand clearCommand,
//        ExecuteScriptCommand executeScriptCommand,
//        FilterGreaterThanAveragePointCommand filterGreaterThanAveragePointCommand,
//        GroupCountingByCreationDateCommand groupCountingByCreationDateCommand,
//        HelpCommand helpCommand,
//        PrintDescendingCommand printDescendingCommand,
//        RemoveGreaterKey removeGreaterKey,
//        RemoveKeyCommand removeKeyCommand,
//        ReplaceIfGreaterCommand replaceIfGreaterCommand,
//        ReplaceIfLowerCommand replaceIfLowerCommand,
//        SaveCommand saveCommand
        ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, labWorkAsker);
        consoleManager.interectiveMode();
    }

}
