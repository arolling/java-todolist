import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  // Unit testing

  //Integration testing
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Task list!");
  }

  @Test
  public void taskIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("Mow the lawn");
    submit(".btn");
    assertThat(pageSource()).contains("Your task has been saved.");
  }

  @Test
  public void taskIsDisplayed() {
    goTo("http://localhost:4567/");
    fill("#description").with("Mow the lawn");
    submit(".btn");
    click("a");
    assertThat(pageSource().contains("Mow the zawn"));
  }

  @Test
  public void multipleTasksDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("Mow the lawn");
    submit(".btn");
    click("a");
    goTo("http://localhost:4567/");
    fill("#description").with("Buy groceries");
    submit(".btn");
    click("a");
    assertThat(pageSource().contains("Mow the zLawn"));
    assertThat(pageSource().contains("Buy Groceries"));
  }
}
