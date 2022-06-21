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

		startTest("DeudaPartis", "Client: "+userName+"/"+password);

		String deuda = "120,00 €.";
		String response1Option1 = "Hola Urr. Veo que tienes una\n" + "deuda pendiente de ";
		String response1Option2 = "Veo que sigue pendiente la deuda de la que hablamos de ";
		String response2 = deuda;
		String response3 = "Puedes entrar en la ";
		String response4 = "sección de pagos";
		String response5 = " para abonarla de manera rápida y así podremos restablecer tus servicios en cuatro horas aproximadamente.";
		String response6 = "También te dejo ";
		String response7 = "información sobre otros métodos de pago";
		String response8 = " y el tiempo de restablecimiento de cada uno.";
		String response9 = "En el caso de que hayas pagado y tengas alguna duda un humano puede ayudarte. ¿Qué quieres hacer?";

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();

		int msgnum1Option1 = chatbotPage.GetNumOfOldMsgs(response1Option1);
		int msgnum1Option2 = chatbotPage.GetNumOfOldMsgs(response1Option2);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
		int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
		int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);
		int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);
		int msgnum8 = chatbotPage.GetNumOfOldMsgs(response8);
		int msgnum9 = chatbotPage.GetNumOfOldMsgs(response9);

		chatbotPage.skipLastConversationInquery();

		chatbotPage.CheckNewRealtiveMsg(response1Option1,response1Option2,msgnum1Option1,msgnum1Option2);
		chatbotPage.NewMessageCheck(response2,msgnum2);
		chatbotPage.NewMessageCheck(response3,msgnum3);
		chatbotPage.NewMessageCheck(response4,msgnum4);
		chatbotPage.NewMessageCheck(response5,msgnum5);
		chatbotPage.NewMessageCheck(response6,msgnum6);
		chatbotPage.NewMessageCheck(response7,msgnum7);
		chatbotPage.NewMessageCheck(response8,msgnum8);
		chatbotPage.NewMessageCheck(response9,msgnum9);

		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		waitForElementToBeVisible(By.xpath("//button[@title=\"No, gracias\"]")).click();

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");


	}
	@DataProvider(name = "DeudaPartis")
	public Object[][] credentials_DeudaPartis() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(34);
		return loginData;

	}



	@Test(dataProvider = "DeudaMicros")
	public void DeudaMicros(String userName, String password, String pathToEvidence) throws Exception{

		startTest("DeudaMicros", "Client: "+userName+"/"+password);

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

		int msgnum = chatbotPage.GetNumOfOldMsgs("Acabo de comprobar que tienes una deuda de 577,78 € con nosotros.");
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