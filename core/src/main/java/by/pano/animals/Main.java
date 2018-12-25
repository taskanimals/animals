package by.pano.animals;

import by.pano.animals.impl.App;
import by.pano.animals.impl.Module;
import com.google.inject.Guice;

public final class Main {

  public static void main(final String[] args) {
    Guice.createInjector(new Module())
        .getInstance(App.class)
        .run(args);
  }

}

