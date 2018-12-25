package by.pano.animals.api;

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
