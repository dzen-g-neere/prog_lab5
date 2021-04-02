package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;
import utility.LabWorkAsker;

public class GroupCountingByCreationDateCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public GroupCountingByCreationDateCommand(CollectionManager collectionManager) {
        super("group_counting_by_creation_date", " - сгруппировать элементы коллекции по значению поля creationDate, вывести количество элементов в каждой группе)");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument) {
        collectionManager.groupCountingByCrDate();
    }
}
