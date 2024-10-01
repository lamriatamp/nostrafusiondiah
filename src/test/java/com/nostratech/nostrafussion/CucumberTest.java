package com.nostratech.nostrafussion;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:com/nostratech/nostrafussion", glue = {
"com.nostratech.nostrafussion" })
public class CucumberTest extends AbstractTestNGCucumberTests {

}
