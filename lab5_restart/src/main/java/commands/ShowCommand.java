package commands;
import exceptions.WrongArgumentException;
import utility.CollectionManager;

public class ShowCommand extends AbstractCommand implements Command{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", " - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            collectionManager.showCollection();
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}