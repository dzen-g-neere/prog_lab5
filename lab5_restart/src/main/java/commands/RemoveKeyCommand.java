package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;

public class RemoveKeyCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        super("remove_key", " \"key\" - удалить элемент из коллекции по его ключу");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        collectionManager.removeKey(argument);
    }
}
