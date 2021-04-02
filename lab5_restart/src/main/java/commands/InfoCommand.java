package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;
import utility.LabWorkAsker;

public class InfoCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info", " - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {
        collectionManager.showInfo();
    }
}
