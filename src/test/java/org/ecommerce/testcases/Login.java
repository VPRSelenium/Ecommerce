package org.ecommerce.testcases;

import org.ecommerce.base.BaseTest;
import org.ecommerce.base.DriverManager;
import org.ecommerce.pom.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends BaseTest {
	protected LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void initPage() {
		loginPage = new LoginPage(DriverManager.getDriver());
	}

	@Test(priority = 0, groups= {"regression","Master"})
	public void validLoginDetails() {

		loginPage.loginCredentials("standard_user", "secret_sauce");
	}

	@Test(priority = 1, groups= {"regression","Master"})
	public void invalidLoginDetails() {

		loginPage.loginCredentials("standard_user1", "secret_sauc1e");
	}

}
