package by.pano.animals.categories;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NumbersCategory extends AbstractCategory {

  private static final String NAME = "NUMBERS";

  private static final String COLON = ": ";

  private static final String FORMAT = " %s:%d%n";

  private static final Collector<String, ?, Map<String, Long>> COLLECTOR
      = Collectors.groupingBy(Function.identity(), Collectors.counting());

  private static BiConsumer printer(PrintWriter out) {
    return (work, count) -> out.format(FORMAT, work, count);
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
          getItems().stream()
              .collect(COLLECTOR)
              .forEach(printer(out));
        });
  }
}
