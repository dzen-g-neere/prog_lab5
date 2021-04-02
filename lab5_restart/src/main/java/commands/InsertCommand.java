package commands;

import exceptions.IncorrectScriptException;
import labwork.LabWork;
import utility.CollectionManager;
import utility.LabWorkAsker;

public class InsertCommand extends AbstractCommand{
    CollectionManager collectionManager;
    LabWorkAsker labWorkAsker;

    public InsertCommand(CollectionManager collectionManager, LabWorkAsker labWorkAsker) {
        super("insert", " \"key\" - добавить новый элемент с заданным ключом");
        this.collectionManager = collectionManager;
        this.labWorkAsker = labWorkAsker;
    }

    @Override
    public void execute(String argument) throws IncorrectScriptException{
//        Integer id,String name, Coordinates coordinates, Date creationDate, Long minimalPoint, long personalQualitiesMinimum, float averagePoint, Difficulty difficulty, Person author
        try {
            collectionManager.addLabWorkToCollection(
                    argument.trim(),
                    new LabWork(
                            labWorkAsker.askID(),
                            labWorkAsker.askName(),
                            labWorkAsker.askCoordinates(),
                            labWorkAsker.askDate(),
                            labWorkAsker.askMinimalPoint(),
                            labWorkAsker.askPersonalQualitiesMinimum(),
                            labWorkAsker.askAveragePoint(),
                            labWorkAsker.askDifficulty(),
                            labWorkAsker.askAuthor()
                    )
            );
        } catch (IncorrectScriptException e){
            throw new IncorrectScriptException();
        }
    }
}
