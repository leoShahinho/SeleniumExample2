package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

//Not reusable
public class Caller_ID extends BaseTest {

	@Test(dataProvider = "CallerIdPartis")
	public void CallerIdPartis(String userName, String password, String pathToEvidence) throws InterruptedException {

		startTest("CallerIdPartis", "");

		String response1 = "Identificador de llamadas";
		String response2 = "Activado";
		String response3 = "Número de teléfono:";
		//String response4 = "Con este servicio puedes ver los números que llaman a tu teléfono fijo y cuesta 2€ al mes.\n" +
		//		"Puedes darlo de baja ahora o hablar con \n" +
		//		" tu asesor si lo necesitas.";
		String response5 = "Chatear con tu asesor";
		String response6 = "consultar estado de mi petición";


		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");
		Thread.sleep(10000);

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		//int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
		int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
		int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);


		chatbotPage.SendMessage("Tengo servicio identificación de llamadas?");

		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		chatbotPage.NewMessageCheck(response1,msgnum1);
		chatbotPage.NewMessageCheck(response2,msgnum2);
		chatbotPage.NewMessageCheck(response3,msgnum3);
		//chatbotPage.NewMessageCheck(response4,msgnum4);
		chatbotPage.NewMessageCheck(response5,msgnum5);

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");


		WebElement Deactivate_Button = waitForElementToBeVisible(By.xpath("(//button[@title=\"Desactivar\"])[last()]"));
		Deactivate_Button.click();

		chatbotPage.NewMessageCheck(response6, msgnum6);

		takeScreenShot(pathToEvidence+"\\Screenshot3.png");


	}
	@DataProvider(name = "CallerIdPartis")
	public Object[][] credentials_CallerIdPartis() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(37);
		return loginData;

	}



	@Test(dataProvider = "CallerIdME")
	public void CallerIdME(String userName, String password, String pathToEvidence) throws InterruptedException {

		startTest("CallerIdME", "");

		String response1 = "Identificador de llamadas";
		String response2 = "Activado";
		String response3 = "Número de teléfono:";
		String response4 = "Con este servicio puedes ver los números que llaman a tu teléfono fijo y cuesta 2€ al mes.\n" +
				"Puedes darlo de baja ahora o hablar con \n" +
				" tu asesor si lo necesitas.";
		String response5 = "Chatear con tu asesor";
		String response6 = "consultar estado de mi petición";


		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatME();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");
		Thread.sleep(10000);

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
		int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
		int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);


		chatbotPage.SendMessage("Tengo servicio identificación de llamadas?");

		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		chatbotPage.NewMessageCheck(response1,msgnum1);
		chatbotPage.NewMessageCheck(response2,msgnum2);
		chatbotPage.NewMessageCheck(response3,msgnum3);
		chatbotPage.NewMessageCheck(response4,msgnum4);
		chatbotPage.NewMessageCheck(response5,msgnum5);

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");


		WebElement Deactivate_Button = waitForElementToBeVisible(By.xpath("(//button[@title=\"Desactivar\"])[last()]"));
		Deactivate_Button.click();

		chatbotPage.NewMessageCheck(response6, msgnum6);

		takeScreenShot(pathToEvidence+"\\Screenshot3.png");

	}
	@DataProvider(name = "CallerIdME")
	public Object[][] credentials_CallerIdME() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(24);
		return loginData;
	}


}