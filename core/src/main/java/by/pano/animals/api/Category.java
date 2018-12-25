package by.pano.animals.api;

import org.atteo.classindex.IndexSubclasses;

@IndexSubclasses
public interface Category extends Printable {

  /**
   * Adds item for category.
   * @param item String
   */
  void add(final String item);

  /**
   * Checks if string represents category.
   * @param string string to check
   * @return true - if represents, false otherwise
   */
  boolean is(final String string);
}
