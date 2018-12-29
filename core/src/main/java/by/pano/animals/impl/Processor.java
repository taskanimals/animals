package by.pano.animals.impl;


import by.pano.animals.api.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

final class Processor{

  private List<Category> categories;

  private Category categoryToUpdate;

  Processor(List<Category> categories) {
    this.categories = categories;
  }

  /**
   * Process input file.
   * @param path {@link Path}, which presents input file
   * @return list of {@link Category}
   * @throws AnimalsException, if cannot read input file.
   */
  List<Category> process(final Path path) throws AnimalsException {
    Optional.ofNullable(path)
        .orElseThrow(() -> new AnimalsException("Path should not be null"));

    try (final Stream<String> stream = Files.lines(path)) {
      stream.forEach(this::process);
    } catch (IOException e) {
      throw new AnimalsException(e.getMessage(),e);
    }
    return categories;
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
}
