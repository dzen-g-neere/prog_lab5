package commands;

import exceptions.IncorrectScriptException;
import exceptions.WrongIDException;
import labwork.LabWork;
import utility.CollectionManager;
import utility.LabWorkAsker;

import java.util.Map;

public class UpdateIDCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;
    LabWorkAsker labWorkAsker;
    public UpdateIDCommand(CollectionManager collectionManager, LabWorkAsker labWorkAsker) {
        super("update", " ID - обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.labWorkAsker = labWorkAsker;
    }
    @Override
    public void execute(String argument) throws IncorrectScriptException {
        int id = Integer.parseInt(argument);
        try {
            Map.Entry<String, LabWork> pair = collectionManager.findByID(id);
            collectionManager.addLabWorkToCollection(
                    pair.getKey(),
                    new LabWork(
                            id,
                            labWorkAsker.askName(),
                            labWorkAsker.askCoordinates(),
                            pair.getValue().getCreationDate(),
                            labWorkAsker.askMinimalPoint(),
                            labWorkAsker.askPersonalQualitiesMinimum(),
                            labWorkAsker.askAveragePoint(),
                            labWorkAsker.askDifficulty(),
                            labWorkAsker.askAuthor()
                    )
                    );
        } catch (WrongIDException e){
            System.out.println("Элемента с id " + id + " не существует");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка");
        }
    }
}
