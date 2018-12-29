package by.pano.animals.impl;

import com.google.inject.Inject;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.ArrayUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static by.pano.animals.impl.Constants.PARAM_FILE;

final class Input{

  private final CommandLineParser parser;

  private final Options options;

  @Inject
  Input(CommandLineParser parser, Options options) {
    this.parser = parser;
    this.options = options;
  }

  /**
   * Parse args.
   * @param args command line args
   * @return {@link Path} from args
   * @throws AnimalsException if something goes wrong during args parsing, or file does not exists
   */
  Path inputFile(final String[] args) throws AnimalsException {
    Optional.ofNullable(args)
      .filter(ArrayUtils::isNotEmpty)
      .orElseThrow(() ->  new AnimalsException("Required argument missed"));

    try {
      final CommandLine cmd = parser.parse(options, args);
      return Optional.ofNullable(cmd.getOptionValue(PARAM_FILE))
          .map(Paths::get)
          .filter(Files::exists)
          .orElseThrow(() ->  new AnimalsException("File does not exists"));
    } catch (ParseException e) {
      throw new AnimalsException("Cannot parse parameters", e);
    }
  }

}
