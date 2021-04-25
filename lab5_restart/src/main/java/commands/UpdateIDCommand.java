package commands;

import exceptions.IncorrectScriptException;
import exceptions.WrongIDException;
import labwork.LabWork;
import utility.CollectionManager;
import utility.LabWorkAsker;

import java.util.Map;

/**
 * This is command 'update'. Refreshes an element of collection which id equals given one.
 */
public class UpdateIDCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;
    LabWorkAsker labWorkAsker;

    public UpdateIDCommand(CollectionManager collectionManager, LabWorkAsker labWorkAsker) {
        super("update", " ID - обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.labWorkAsker = labWorkAsker;
    }
    /**
     * Execute of 'update' command.
     */
    @Override
    public void execute(String argument) throws IncorrectScriptException {
        int id;
        try {
            id = Integer.parseInt(argument);
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
            System.out.println("Элемента с заданным id нет в коллекции");
        } catch (NumberFormatException e){
            System.out.println("ID должен быть целым числом");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка");
        }
    }
}
