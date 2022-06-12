package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Deuda extends BaseTest {


	@Test(dataProvider = "DeudaPartis")
	public void DeudaPartis(String userName, String password, String pathToEvidence) throws InterruptedException {

		startTest("DeudaPartis", "");

		String deuda = "120,00 €.";
		String response1 = "Hola Urr. Veo que tienes una\n" + "deuda pendiente de ";
		String response2 = deuda;

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);


		chatbotPage.SendMessage("Hola");

		chatbotPage.NewMessageCheck(response1,msgnum1);
		chatbotPage.NewMessageCheck(response2,msgnum2);

		//int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);

		//chatbotPage.SendMessage("Tengo deuda con vosotros?");
		//takeScreenShot(pathToEvidence+"\\Screenshot.png");
		//WebElement factura_emitida = waitForElementToBeVisible(By.xpath("//button[contains(.,\"Sí, es una factura pasada\")]"));
		//factura_emitida.click();
		//int msgnum = chatbotPage.GetNumOfOldMsgs("Acabo de comprobar que tienes una deuda de 262,67 € con nosotros.");
		//chatbotPage.NewMessageCheck("Acabo de comprobar que tienes una deuda de 262,67 € con nosotros.", msgnum);
		//msgnum = chatbotPage.GetNumOfOldMsgs("Puedes ir a la ");
		//chatbotPage.NewMessageCheck("Puedes ir a la ", msgnum);

		takeScreenShot(pathToEvidence+"\\Screenshot1.png");
	}
	@DataProvider(name = "DeudaPartis")
	public Object[][] credentials_DeudaPartis() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(34);
		return loginData;

	}



	@Test(dataProvider = "DeudaMicros")
	public void DeudaMicros(String userName, String password, String pathToEvidence) throws Exception{

		startTest("DeudaMicros", "");

		//String deuda = "577,78 €.";
		//String response1 = "Veo que sigue pendiente la deuda de la que hablamos de ";
		//String response2 = deuda;

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password,pathToEvidence+"\\1 User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatME();
		chatbotPage.SwichIFrame();

		//int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		//int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);

		chatbotPage.SendMessage("Hola");
		Thread.sleep(8000);

		//chatbotPage.NewMessageCheck(response1,msgnum1);
		//chatbotPage.NewMessageCheck(response2,msgnum2);

		chatbotPage.SendMessage("Como pago mi deuda con vosotros?");
		WebElement factura_emitida = waitForElementToBeVisible(By.xpath("//button[contains(.,\"Sí, es una factura pasada\")]"));
		factura_emitida.click();
		int msgnum = chatbotPage.GetNumOfOldMsgs("Acabo de comprobar que tienes una deuda de 144,89 € con nosotros.");
		chatbotPage.NewMessageCheck("Acabo de comprobar que tienes una deuda de 577,78 € con nosotros.", msgnum);
		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		msgnum = chatbotPage.GetNumOfOldMsgs("Puedes ir a la ");
		chatbotPage.NewMessageCheck("Puedes ir a la ", msgnum);

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");

	}
	@DataProvider(name = "DeudaMicros")
	public Object[][] credentials_DeudaMicros() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(21);
		return loginData;

	}

}