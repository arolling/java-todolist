import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @Rule
  public ClearRule clearRule = new ClearRule();

  @ClassRule
  public static ServerRule server = new ServerRule();
  // Unit testing

  //Integration testing
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Todo list!");
  }

  @Test
  public void categoryIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Category"));
    fill("#name").with("Household chores");
    submit(".btn");
    assertThat(pageSource()).contains("Your category has been saved");
  }

  @Test
  public void categoryIsDisplayedTest() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Household chores");
    submit(".btn");
    click("a", withText("View categories"));
    assertThat(pageSource()).contains("Household chores");
  }

  // @Test
  // public void taskIsCreatedTest() {
  //   goTo("http://localhost:4567/");
  //   click("a", withText("Add a new task"));
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Your task has been saved.");
  // }
  //
  // @Test
  // public void taskIsDisplayedTest() {
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("View tasks"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // @Test
  // public void multipleTasksAreDisplayedTest() {
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Buy groceries");
  //   submit(".btn");
  //   click("a", withText("View tasks"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  //   assertThat(pageSource()).contains("Buy groceries");
  // }

  // @Test
  // public void taskShowPageDisplaysDescription() {
  //   goTo("http://localhost:4567/tasks/new");
  //   fill("#description").with("Do the dishes");
  //   submit(".btn");
  //   click("a", withText("View tasks"));
  //   click("a", withText("Do the dishes"));
  //   assertThat(pageSource()).contains("Do the dishes");
  // }
  // @Test
  // public void taskNotFoundMessageShown() {
  //   goTo("http://localhost:4567/tasks/999");
  //   assertThat(pageSource()).contains("Task not found");
  // }
}
