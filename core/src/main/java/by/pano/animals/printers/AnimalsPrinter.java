package by.pano.animals.printers;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printer;

import java.io.PrintWriter;

public class AnimalsPrinter extends Printer {

  private static final String FORMAT_ITEMS = " %s%n";

  public AnimalsPrinter(Category category) {
    super(category);
  }

  @Override
  protected void printItems(final PrintWriter out) {
    category.getItems().stream()
        .sorted()
        .distinct()
        .forEach(item -> out.format(FORMAT_ITEMS, item));
  }
}
