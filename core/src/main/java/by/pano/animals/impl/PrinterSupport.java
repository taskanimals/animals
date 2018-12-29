package by.pano.animals.impl;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printable;
import by.pano.animals.api.Printer;
import org.atteo.classindex.ClassIndex;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class PrinterSupport {

  private PrinterSupport() { }

  /**
   * Loads mapping of {@link Category} subclasses to {@link Printer} classes.
   * @return mapping of {@link Category} subclasses to {@link Printer} classes
   */
  static Map<String, Class<? extends Printer>> load() {
    final Iterable<Class<?>> klasses = ClassIndex.getAnnotated(Printable.class);
    return StreamSupport.stream(klasses.spliterator(), false)
        .collect(Collectors.toMap(Class::getName, toPrinter));
  }

  private static Function<Class<?>, Class<? extends Printer>> toPrinter =
      klass -> ((Printable)klass.getAnnotationsByType(Printable.class)[0]).print();
}
