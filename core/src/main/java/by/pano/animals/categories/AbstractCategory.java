package by.pano.animals.categories;


import by.pano.animals.api.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCategory implements Category {

  private List<String> items;

  public AbstractCategory() {
    items = new ArrayList<>();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void add(String item) {
    Optional.ofNullable(item)
        .filter(i1 -> !this.getName().equals(i1))
        .ifPresent(i2 -> items.add(i2));
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean is(final String string) {
    return this.getName().equals(string);
  }

  protected List<String> getItems() {
    return items;
  }

  protected abstract String getName();

}
