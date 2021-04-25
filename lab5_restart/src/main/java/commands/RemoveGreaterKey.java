package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;

/**
 * This is command 'remove_greater_key'. Remove elements which have key that is more than given.
 */
public class RemoveGreaterKey extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public RemoveGreaterKey(CollectionManager collectionManager) {
        super("remove_greater_key", " - удалить из коллекции все элементы, ключ которых превышает заданный");
        this.collectionManager = collectionManager;
    }

    /**
     * Execute of 'remove_greater_key' command.
     */
    @Override
    public void execute(String argument) {
        collectionManager.removeGreaterKey(argument);
    }
}
