package by.pano.animals.printers;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printer;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.PrintWriter;
import java.util.Comparator;

public class CarsPrinter extends Printer {

  private static final String FORMAT_ITEMS = " %s (%s)%n";

  public CarsPrinter(Category category) {
    super(category);
  }

  @Override
  protected void printItems(PrintWriter out) {
    category.getItems().stream()
      .map(String::toLowerCase)
      .sorted(Comparator.reverseOrder())
      .distinct()
      .forEach(item -> out.format(FORMAT_ITEMS, item.toLowerCase(), DigestUtils.md5Hex(item)));
  }
}
