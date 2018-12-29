package by.pano.animals.api;

import java.io.PrintWriter;
import java.util.Optional;

public abstract class Printer{

  private static final String FORMAT_NAME = "%s:%n";

  protected final Category category;

  public Printer(Category category) {
    this.category = category;
  }

  protected void printName(final PrintWriter out) {
    out.format(FORMAT_NAME, category.getName());
  }

  protected abstract void printItems(final PrintWriter out);

  public void print(final PrintWriter out) {
    Optional.of(this.category.getItems())
        .filter(list -> !list.isEmpty())
        .ifPresent( items -> {
          printName(out);
          printItems(out);
        });
  }
}
