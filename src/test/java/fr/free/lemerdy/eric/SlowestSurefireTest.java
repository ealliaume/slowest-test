package fr.free.lemerdy.eric;

import static org.fest.assertions.Assertions.assertThat;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.common.io.Resources;

public class SlowestSurefireTest {
	@Test
    public void should_read_single_surefire_test_report() throws URISyntaxException
    {
		SlowestSurefireReports slowestSurefireReports = new SlowestSurefireReports();
		List<TestReport> testReports = slowestSurefireReports.slowestTests();
		
		assertThat(testReports.size()).isEqualTo(7);
		assertThat(testReports.get(0).time).isEqualTo(0.014d);
		assertThat(testReports.get(0).classname).isEqualTo("CoffeeMachineOrderTest");
		assertThat(testReports.get(0).name).isEqualTo("for_a_chocolate_with_exact_price_with_2_sugar_should_order_chocolate_with_2_sugar_and_a_stick");
    }
	
	@Test
	public void should_read_test_dir() {
      URL resource = Resources.getResource("surefire-reports");
      Assert.assertNotNull(resource);
    }
}