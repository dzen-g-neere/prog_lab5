package commands;

import exceptions.IncorrectScriptException;
import exceptions.WrongArgumentException;
import labwork.LabWork;
import utility.CollectionManager;
import utility.LabWorkAsker;

public class ReplaceIfGreaterCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;
    LabWorkAsker labWorkAsker;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager, LabWorkAsker labWorkAsker) {
        super("replace_if_greater", " \"key\" - заменить значение по ключу, если новое значение больше старого");
        this.collectionManager = collectionManager;
        this.labWorkAsker = labWorkAsker;
    }

    @Override
    public void execute(String argument) throws IncorrectScriptException {
        LabWork labWorkNew = new LabWork(
                labWorkAsker.askID(),
                labWorkAsker.askName(),
                labWorkAsker.askCoordinates(),
                labWorkAsker.askDate(),
                labWorkAsker.askMinimalPoint(),
                labWorkAsker.askPersonalQualitiesMinimum(),
                labWorkAsker.askAveragePoint(),
                labWorkAsker.askDifficulty(),
                labWorkAsker.askAuthor()
        );
        LabWork labWorkOld;
        try {
            labWorkOld = collectionManager.getByKey(argument);
            if (labWorkNew.compareTo(labWorkOld) > 0) {
                collectionManager.removeKey(argument);
                collectionManager.addLabWorkToCollection(argument, labWorkNew);
            }
        } catch (WrongArgumentException e) {
            System.out.println("Аргумент " + argument + " некорректен");
        }
    }
}
