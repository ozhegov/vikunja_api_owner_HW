package io.vikunja.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.vikunja.helpers.WithLogin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.vikunja.utils.TestData.*;

@DisplayName("Проверки функционала задач")
public class AddTaskTests extends TestBase {

    @Test
    @WithLogin
    @Owner("Maksim Ozhegov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("После добавления задачи в списке задач появляется новая задача")
    public void taskNameShouldBeVisibleAfterTaskAdded() {

        step("Открываем сайт", () -> {
            open("https://try.vikunja.io/");
        });

        step("Создаем новую задачу с именем " + taskName, () -> {
            $(".add-task-textarea").setValue(taskName).pressEnter();
        });

        step("Проверяем, что в списке задач появилась новая задача с именем " + taskName, () -> {
            $(".task-link").shouldHave(text(taskName));
        });


    }

}
