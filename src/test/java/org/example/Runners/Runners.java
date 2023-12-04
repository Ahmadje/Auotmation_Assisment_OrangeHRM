package org.example.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = {"org.example.StepDefinition"},
                plugin = {"pretty",
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"}
        )

public class Runners extends AbstractTestNGCucumberTests {
}
