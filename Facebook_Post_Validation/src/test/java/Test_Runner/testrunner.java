package Test_Runner;


import java.io.File;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-reports/CucumberTestReport.json",
        retryCount = 0,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-reports/cucumber-usage.json",
        usageReport = false,
        pdfPageSize = "A4 Landscape",
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target/cucumber-reports/extended-report")

@CucumberOptions(features={"Features"},
glue={"Step_Defination"},
monochrome = true,
tags =      {"~@Ignore"},
plugin =    {
        "pretty", "json:target/cucumber.json","html:target/cucumber-pretty","html:target/cucumber-reports/cucumber-html-report",
        "json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/rerun.txt"}
)

//plugin={""html:target/cucumber-html-report"","json:target/cucumber.json","pretty:target/cucumber-pretty.txt","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json","junit:target/cucumber-results.xml"}

public class testrunner{
	 
	    public static void teardown() {

	    }

	    }

