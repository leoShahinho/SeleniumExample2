package Chatbot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class DesvioLlamadasME extends BaseTest {
//any ME user applicable

		@Test(dataProvider = "DesvioLlamadasME")
	 	public void DesvioLlamadasME(String userName, String password, String pathToEvidence) throws Exception {

			startTest("DesvioLlamadasME", "");

			String response1 = "Vale, ¿quieres hacer la gestión para el móvil, el fijo o en los dos?";
			String response2 = "Vale, el desvío del móvil puedes gestionarlo desde ";
			String response3 = "Opciones de llamada.";
			String response4 = "Además, para conocer los tipos de desvío de llamadas, el coste... puedes revisar ";
			String response5 = "nuestras consultas frecuentes del móvil.";
			String response6 = "Y la misma información para el fijo, puedes verla en ";
			String response7 = "nuestras consultas frecuentes del fijo.";


			ChatbotPage chatbotPage = new ChatbotPage(driver);
	        chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
	        chatbotPage.CloseErrorBanner();
	        chatbotPage.OpenChatME();
	        chatbotPage.SwichIFrame();
	        chatbotPage.SendMessage("Hola");
	        Thread.sleep(8000);

			int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
			int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
			int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
			int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
			int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
			int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);
			int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);

			chatbotPage.SendMessage("Cómo activo el desvio de llamadas?");

			chatbotPage.NewMessageCheck(response1,msgnum1);
	        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

			WebElement enLosDos = waitForElementToBeVisible(By.xpath("//button[contains(@title,'En los dos')]"));
			enLosDos.click();

			chatbotPage.NewMessageCheck(response2,msgnum2);
			chatbotPage.NewMessageCheck(response3,msgnum3);
			chatbotPage.NewMessageCheck(response4,msgnum4);
			chatbotPage.NewMessageCheck(response5,msgnum5);
			chatbotPage.NewMessageCheck(response6,msgnum6);
			chatbotPage.NewMessageCheck(response7,msgnum7);

			takeScreenShot(pathToEvidence+"\\Screenshot2.png");

			chatbotPage.EndConv();

			takeScreenShot(pathToEvidence+"\\Screenshot3.png");


		}
	    @DataProvider(name = "DesvioLlamadasME")
		public Object[][] credentials_DesvioLlamadasME() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(26);
		return loginData;

	}
		}