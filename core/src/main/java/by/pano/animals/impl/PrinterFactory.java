package by.pano.animals.impl;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printer;
import com.google.inject.Inject;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;


class PrinterFactory {

  private final Map<String, Class<? extends Printer>> printers;

  @Inject
  PrinterFactory(Map<String, Class<? extends Printer>> printers) {
    this.printers = printers;
  }

  /**
   * Creates {@link Printer} for given {@link Category}.
   * @param category {@link Category} to create {@link Printer} for
   * @return {@link Printer}, or null, if cannot find printer for given category
   */
  public Printer createFor(final Category category) {
    return Optional.ofNullable(category)
        .map(Category::getClass)
        .map(Class::getName)
        .map(printers::get)
        .map(this.toPrinter(category))
        .orElse(null);
  }

  private Function<Class<? extends Printer>, Printer> toPrinter(final Category category) {
    return klass -> {
      try {
        return klass.getConstructor(Category.class).newInstance(category);
      } catch (Exception e) {
        return null;
      }
    };
  }
}
