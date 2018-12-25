package by.pano.animals.categories;

import by.pano.animals.api.annotation.Category;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;

@Category
public class CarsCategory extends AbstractCategory {

  private static final String NAME = "CARS";

  private static final char COLON = ':';

  private static final String FORMAT = " %s (%s)%n";

  private static Consumer<String> printer(PrintWriter out) {
    return item -> out.format(FORMAT, item.toLowerCase(), DigestUtils.md5Hex(item));
  }

  @Override
  protected String getName() {
    return NAME;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void print(final PrintWriter out) {
    Optional.of(getItems())
        .filter(list -> !list.isEmpty())
        .ifPresent( items -> {
          out.println(NAME + COLON);
          items.stream()
              .map(String::toLowerCase)
              .sorted(Comparator.reverseOrder())
              .distinct()
              .forEach(printer(out));
        });
  }
}
