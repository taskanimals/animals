package by.pano.animals.categories;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printable;
import by.pano.animals.printers.CarsPrinter;

@Printable(print = CarsPrinter.class)
public class CarsCategory extends Category {

  private static final String NAME = "CARS";

  @Override
  public String getName() {
    return NAME;
  }
}
