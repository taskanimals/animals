package by.pano.animals.impl;

import com.google.inject.Inject;

import java.io.PrintWriter;

public final class App {

  private final Processor processor;

  private final Input input;

  private final PrintWriter out;

  @Inject
  App(Processor processor, Input input, PrintWriter out) {
    this.processor = processor;
    this.input = input;
    this.out = out;
  }

  /**
   * Runs app.
   * @param args command line args.
   */
  public void run(final String[] args) {
    try {
      processor.process(input.inputFile(args));
      processor.print(out);
    } catch (AnimalsException e) {
      input.printError(out, e);
    }
  }
}
