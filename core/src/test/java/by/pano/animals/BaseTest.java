package by.pano.animals;

import by.pano.animals.impl.Module;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class BaseTest {

  protected ByteArrayOutputStream stream;

  protected static Injector injector;

  @BeforeAll
  static void init() {
    injector = Guice.createInjector(new Module());
  }

  protected PrintWriter newOut() {
    stream = new ByteArrayOutputStream();
    return new PrintWriter(stream, true);
  }

  protected String getOutput() {
    return new String(stream.toByteArray(),  StandardCharsets.UTF_8);
  }
}
