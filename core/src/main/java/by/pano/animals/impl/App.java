package by.pano.animals.impl;

import com.google.inject.Inject;

import java.io.PrintWriter;

public final class App {

  private final Input input;

  private final Output output;

  private final PrintWriter out;

  @Inject
  App(Input input, Output output, PrintWriter out) {
    this.input = input;
    this.output = output;
    this.out = out;
  }

  /**
   * Runs app.
   * @param args command line args.
   */
  public void run(final String[] args) {
    final Processor processor = new Processor(CategorySupport.load());
    try {
      output.print(out, processor.process(input.inputFile(args)));
    } catch (AnimalsException e) {
      output.print(out, e);
    }
  }
}
