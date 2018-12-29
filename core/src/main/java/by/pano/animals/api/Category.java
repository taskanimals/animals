package by.pano.animals.api;


import org.atteo.classindex.IndexSubclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@IndexSubclasses
public abstract class Category {

  private List<String> items;

  public Category() {
    items = new ArrayList<>();
  }

  /**
   * Adds item for category.
   * @param item String
   */
  public void add(final String item) {
    Optional.ofNullable(item)
        .filter(i1 -> !this.getName().equalsIgnoreCase(i1))
        .ifPresent(i2 -> items.add(i2));
  }

  /**
   * Checks if given string represents category.
   * @param string string to check
   * @return true - if represents, false otherwise
   */
  public boolean is(final String string) {
    return this.getName().equalsIgnoreCase(string);
  }

  public List<String> getItems() {
    return items;
  }

  public abstract String getName();

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Category category = (Category) obj;
    return Objects.equals(items, category.items)
        && Objects.equals(getName(), category.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, getName());
  }
}
