package by.pano.animals.categories;


import java.io.PrintWriter;
import java.util.Optional;
import java.util.function.Consumer;

public class AnimalsCategory extends AbstractCategory {

  private static final String NAME = "ANIMALS";

  private static final char COLON = ':';

  private static final String FORMAT = " %s%n";

  private static Consumer printer(PrintWriter out) {
    return item -> out.format(FORMAT, item);
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
              .sorted()
              .distinct()
              .forEach(printer(out));
        });
  }
}
