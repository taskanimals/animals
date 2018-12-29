package by.pano.animals.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static by.pano.animals.impl.Constants.PARAM_FILE;
import static by.pano.animals.impl.Constants.PARAM_FILE_DESCRIPTION;
import static by.pano.animals.impl.Constants.PARAM_FILE_FULL;

public final class Module extends AbstractModule {

  @Provides
  public Options provideOptions() {
    Options options = new Options();
    options.addOption(PARAM_FILE, PARAM_FILE_FULL, true, PARAM_FILE_DESCRIPTION);
    return options;
  }

  @Provides
  public CommandLineParser provideCommandLineParser() {
    return new DefaultParser();
  }

  @Provides
  public HelpFormatter provideHelpFormatter() {
    return new HelpFormatter();
  }

  @Provides
  public PrinterFactory providePrinterProvider() {
    return new PrinterFactory(PrinterSupport.load());
  }

  @Provides
  public Input provideInput(CommandLineParser parser, Options options) {
    return new Input(parser, options);
  }

  @Provides
  public Output provideInput(PrinterFactory printerFactory, HelpFormatter formatter, Options options) {
    return new Output(printerFactory, formatter, options);
  }

  @Provides
  public PrintWriter providePrintStream() {
    return new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
  }
}
