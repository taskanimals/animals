package by.pano.animals.impl;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printable;
import com.google.inject.Inject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

final class Processor implements Printable {

  private List<Category> categories;

  private Category categoryToUpdate;

  @Inject
  Processor(List<Category> categories) {
    this.categories = categories;
  }

  /**
   * Process input file.
   * @param path {@link Path}, which presents input file
   * @throws AnimalsException, if cannot read input file.
   */
  void process(final Path path) throws AnimalsException {
    try (final Stream<String> stream = Files.lines(path)) {
      stream.forEach(this::process);
    } catch (IOException e) {
      throw new AnimalsException(e.getMessage(),e);
    }
  }

  private void process(final String line) {
    Optional.ofNullable(resolveCategory(line))
        .ifPresent(category -> {
          this.categoryToUpdate = category;
          this.categoryToUpdate.add(line);
        });
  }

  private Category resolveCategory(final String line) {
    return categories.stream()
        .filter(category -> category.is(line))
        .findFirst()
        .orElse(categoryToUpdate);
  }

  @Override
  public void print(PrintWriter out) {
    categories.forEach(category -> category.print(out));
  }
}
