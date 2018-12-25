package by.pano.animals.impl;

import by.pano.animals.api.Category;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.PrintWriter;
import java.util.List;

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
  public Processor provideProcessor() {
    final List<Category> categories = CategorySupport.loadCategories();
    return new Processor(categories);
  }

  @Provides
  public Input provideInput(HelpFormatter formatter, CommandLineParser parser, Options options) {
    return new Input(formatter, parser, options);
  }

  @Provides
  public PrintWriter providePrintStream() {
    return new PrintWriter(System.out, true);
  }
}
