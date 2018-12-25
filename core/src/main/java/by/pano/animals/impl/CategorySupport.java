package by.pano.animals.impl;

import by.pano.animals.api.Category;
import org.atteo.classindex.ClassIndex;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class CategorySupport {

  private CategorySupport(){}

  /**
   * Loads list of {@link Category}.
   * @return list of {@link Category}
   */
  static List<Category> loadCategories() {
    final Iterable<Class<? extends Category>> klasses = ClassIndex
        .getSubclasses(Category.class, CategorySupport.class.getClassLoader());
    return StreamSupport.stream(klasses.spliterator(), false)
        .sorted(Comparator.comparing(Class::getName))
        .map(CategorySupport::instantiate)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  private static Category instantiate(Class<?> klass) {
    try {
      return Optional.of(klass.newInstance())
          .filter(instance -> instance instanceof Category)
          .map(Category.class::cast)
          .orElse(null);
    } catch (InstantiationException | IllegalAccessException e) {
      // doing nothing;
    }
    return null;
  }
}
