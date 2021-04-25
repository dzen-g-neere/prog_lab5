package commands;

import exceptions.IncorrectScriptException;
import exceptions.WrongArgumentException;
import labwork.LabWork;
import utility.CollectionManager;
import utility.LabWorkAsker;

/**
 * This is command 'replace_if_lowe'. Replaces element by key if new element is less than old one.
 */
public class ReplaceIfLowerCommand extends AbstractCommand implements Command {
    CollectionManager collectionManager;
    LabWorkAsker labWorkAsker;

    public ReplaceIfLowerCommand(CollectionManager collectionManager, LabWorkAsker labWorkAsker) {
        super("replace_if_lowe", " \"key\" - заменить значение по ключу, если новое значение меньше старого");
        this.collectionManager = collectionManager;
        this.labWorkAsker = labWorkAsker;
    }

    /**
     * Execute of 'replace_if_lowe' command.
     */
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
            if (labWorkNew.compareTo(labWorkOld) < 0) {
                collectionManager.removeKey(argument);
                collectionManager.addLabWorkToCollection(argument, labWorkNew);
            }
        } catch (WrongArgumentException e) {
            System.out.println("Аргумент " + argument + " некорректен");
        }
    }
}

