package commands;

import exceptions.WrongArgumentException;
import utility.CollectionManager;
import utility.LabWorkAsker;

public class ExitCommand extends AbstractCommand implements Command{

    public ExitCommand() {
        super("exit", " - выход из программы");
    }
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            System.out.println("Завершение программы");
            System.exit(0);
        } catch (WrongArgumentException e) {
            System.out.println("Некорректный аргумент. Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
