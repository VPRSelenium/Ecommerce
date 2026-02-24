package org.ecommerce.testcases;

import org.ecommerce.base.BaseTest;
import org.ecommerce.base.DriverManager;
import org.ecommerce.pom.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login2 extends BaseTest {
	protected LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void initPage() {
		loginPage = new LoginPage(DriverManager.getDriver());
	}

	@Test(priority = 3, groups ={"smoke","Master"})
	public void validLoginDetails() {

		loginPage.loginCredentials("standard_user", "secret_sauce");

	}

}
