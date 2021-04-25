package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;

/**
 * This is command 'remove_key'. Deletes element by key.
 */
public class RemoveKeyCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        super("remove_key", " \"key\" - удалить элемент из коллекции по его ключу");
        this.collectionManager = collectionManager;
    }
    /**
     * Execute of 'remove_key' command.
     */
    @Override
    public void execute(String argument) {
        collectionManager.removeKey(argument);
    }
}
