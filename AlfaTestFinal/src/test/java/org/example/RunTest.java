package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
				features = "src/test/resources/features",
				glue = "org.example",
				tags = "@moneytaker",
				plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
				snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunTest
{ }
