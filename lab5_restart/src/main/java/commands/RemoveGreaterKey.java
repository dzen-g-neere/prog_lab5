package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;

public class RemoveGreaterKey extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public RemoveGreaterKey(CollectionManager collectionManager) {
        super("remove_greater_key", " - удалить из коллекции все элементы, ключ которых превышает заданный");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        collectionManager.removeGreaterKey(argument);
    }
}
