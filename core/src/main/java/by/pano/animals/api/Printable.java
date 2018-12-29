package by.pano.animals.api;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IndexAnnotated
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Printable {

  /**
   * Indicates which {@link Printer} should be used for printing annotated {@link Category}.
   */
  Class<? extends Printer> print() ;
}
