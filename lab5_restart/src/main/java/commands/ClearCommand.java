package commands;

import exceptions.IncorrectScriptException;
import exceptions.WrongArgumentException;
import utility.CollectionManager;

public class ClearCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", " - очистить коллекцию");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String argument){
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            collectionManager.clearCollection();
            System.out.println("Коллекция очищена");
        } catch (WrongArgumentException e) {
            System.out.println("Некорректный аргумент. Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
