package com.byblosTestAuto;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, tags = { "@NotSkip" }, glue = {
		"com.byblosTestAuto.stepdefs" }, dryRun = false, strict = true, monochrome = true)
public class RunCukeTest {

}
