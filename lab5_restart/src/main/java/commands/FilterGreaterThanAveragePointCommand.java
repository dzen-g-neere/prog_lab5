package commands;

import exceptions.IncorrectScriptException;
import utility.CollectionManager;

public class FilterGreaterThanAveragePointCommand extends AbstractCommand implements Command{
    CollectionManager collectionManager;

    public FilterGreaterThanAveragePointCommand(CollectionManager collectionManager) {
        super("filter_greater_than_average_point", " averagePoint - вывести элементы, значение поля averagePoint которых больше заданного");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String argument) {
        float averagePoint;
        try {
            averagePoint = Float.parseFloat(argument);
            if (averagePoint <= 0){
                throw new NumberFormatException();
            }
            collectionManager.filterGreaterThanAveragePoint(averagePoint);
        } catch (NullPointerException e){
            System.out.println("Ошибка. Аргумент не может быть пустой строкой.");
        } catch (NumberFormatException e){
            System.out.println("Ошибка. Аргумент должен быть числом больше 0.");
        }

    }
}
