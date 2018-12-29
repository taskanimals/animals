package by.pano.animals.impl;

import by.pano.animals.api.Category;
import com.google.inject.Inject;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import static by.pano.animals.impl.Constants.CMD_ERROR_TEMPLATE;
import static by.pano.animals.impl.Constants.CMD_SYNTAX;

class Output {

  private final HelpFormatter formatter;

  private final Options options;

  private final PrinterFactory printerFactory;

  @Inject
  Output(PrinterFactory printerFactory, HelpFormatter formatter, Options options) {
    this.formatter = formatter;
    this.options = options;
    this.printerFactory = printerFactory;
  }

  /**
   * Prints given list of {@link Category}.
   * @param out {@link PrintWriter} to use
   * @param categories list of {@link Category} to print
   */
  void print(final PrintWriter out, final List<Category> categories) {
    categories.stream().forEach(category -> Optional.ofNullable(printerFactory.createFor(category))
          .ifPresent(printer -> printer.print(out))
    );
  }

  /**
   * Prints error massage and usage for given exception.
   * @param out {@link PrintWriter} to use
   * @param exception exception
   */
  void print(final PrintWriter out, final Exception exception) {
    out.format(CMD_ERROR_TEMPLATE, exception.getMessage());

    formatter.printHelp(out, formatter.getWidth(), CMD_SYNTAX, null,
        options,formatter.getLeftPadding(), formatter.getDescPadding(), null, false);
  }
}
