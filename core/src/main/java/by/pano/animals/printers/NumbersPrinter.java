package by.pano.animals.printers;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printer;

import java.io.PrintWriter;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NumbersPrinter extends Printer {

  private static final String FORMAT_NAME = "%s: %n";
  private static final String FORMAT_ITEMS = " %s:%d%n";

  private static final Collector<String, ?, Map<String, Long>> COLLECTOR
      = Collectors.groupingBy(Function.identity(), Collectors.counting());

  public NumbersPrinter(Category category) {
    super(category);
  }

  @Override
  protected void printName(PrintWriter out) {
    out.format(FORMAT_NAME, category.getName());
  }

  @Override
  protected void printItems(PrintWriter out) {
    category.getItems().stream()
        .collect(COLLECTOR)
        .forEach((work, count) -> out.format(FORMAT_ITEMS, work, count));
  }
}
