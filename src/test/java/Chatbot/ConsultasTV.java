package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class ConsultasTV extends BaseTest {


	@Test(dataProvider = "MandoTele")
	public void MandoTele(String userName, String password, String pathToEvidence) throws InterruptedException {

		startTest("MandoTele", "");

		String response1 = "Dime qué te gustaría hacer exactamente:";
		String response2 = "conocer cómo funciona tu mando";
		String response3 = ":\n" + "1. Elige el modelo que tienes\n" + "2. Pincha en los distintos botones del mando, algunos te sorprenderán.";

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");
		Thread.sleep(10000);

		int msgnum = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);


		chatbotPage.SendMessage("Necesito el mando de la tele");
		chatbotPage.NewMessageCheck(response1, msgnum);
		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		WebElement VerComoFunciona = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Ver cómo funciona')])[last()]"));
		VerComoFunciona.click();

		chatbotPage.NewMessageCheck(response2, msgnum2);
		chatbotPage.NewMessageCheck(response3, msgnum3);

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");

		chatbotPage.EndConv();

		takeScreenShot(pathToEvidence+"\\Screenshot3.png");

	}
	@DataProvider(name = "MandoTele")
	public Object[][] credentials_MandoTele() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(14);
		return loginData;

	}



	@Test(dataProvider = "TV_Multi_Partis")
	public void TV_Multi_Partis(String userName, String password, String pathToEvidence) throws InterruptedException{

		startTest("TV_Multi_Partis", "");

		String response1 = "Veo que tienes TV Multidispositivo activo y vinculado a cain.carmona@hotmail.com.";
		String response2 = "¿Qué quieres hacer?";
		String response3 = "Si quieres saber más o tienes otra consulta, te dejo las ";
		String response4 = "preguntas frecuentes";
		String response5 = " donde podrás solucionar todas tus dudas.";

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1User.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
		int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);

		chatbotPage.SendMessage("Hola");
		Thread.sleep(10000);

		chatbotPage.SendMessage("Tengo TV Multidispositivo?");

		chatbotPage.NewMessageCheck(response1,msgnum1);
		chatbotPage.NewMessageCheck(response2,msgnum2);

		WebElement otraDuda = waitForElementToBeVisible(By.xpath("//button[@title=\"Otra duda\"]"));
		otraDuda.click();

		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		chatbotPage.NewMessageCheck(response3,msgnum3);
		chatbotPage.NewMessageCheck(response4,msgnum4);
		chatbotPage.NewMessageCheck(response5,msgnum5);

		chatbotPage.EndConv();

		takeScreenShot(pathToEvidence+"\\Screenshot2.png");

	}
	@DataProvider(name = "TV_Multi_Partis")
	public Object[][] credentials_TV_Multi_Partis() {

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(12);
		return loginData;

	}



	@Test(dataProvider = "BajaPackTV")
	public void BajaPackTV(String userName, String password, String pathToEvidence) throws InterruptedException {

		startTest("AmazonPrimeActivo", "");

		String response1 = "Vale, ¿qué es lo que quieres dar de baja de Vodafone TV?";
		String response2 = "En ese caso, aquí puedes ";
		String response3 = "dar de baja uno o varios paquetes";
		String response4 = " seleccionando el que quieras eliminar.";

		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);

		Thread.sleep(10000);

		chatbotPage.SendMessage("Quiero dar de baja un paquete de Television");

		chatbotPage.NewMessageCheck(response1,msgnum1);
		takeScreenShot(pathToEvidence+"\\Screenshot1.png");

		WebElement UnPack = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Uno o varios paquetes')]"));
		UnPack.click();
		takeScreenShot(pathToEvidence+"\\Screenshot2.png");

		chatbotPage.NewMessageCheck(response2,msgnum2);
		chatbotPage.NewMessageCheck(response3,msgnum3);
		chatbotPage.NewMessageCheck(response4,msgnum4);

		chatbotPage.EndConv();
		takeScreenShot(pathToEvidence+"\\Screenshot3.png");

	}
	@DataProvider(name="BajaPackTV")
	public Object[][] CredentialsBajaPackTV()
	{
		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(13);
		return loginData;
	}



	@Test(dataProvider = "AveriaDisneyPlus")
	public void AveriaDisneyPlus(String userName, String password, String pathToEvidence) throws InterruptedException{


		startTest("AmazonPrimeActivo", "");

		String response1 = "Vale, para ayudarte mejor, ¿tu problema tiene que ver con alguno de los siguientes?";
		String response2 = "Vale, te cuento. Todavía estamos trabajando para tener la app de Disney+ en el decodificador de Vofadone TV. Te avisaremos en cuanto esté.";
		String response3 = "descargar la app de Disney+ en tu propia Smart TV, móvil o tablet";
		String response4 = "Y si sigue dándote problemas, puedes abrir una incidencia con Disney+ y estudiaremos tu caso. ¿Quieres hacerlo?";
		String response5 = "Vale, te cuento cómo abrir una incidencia con Disney+.";
		String response6 = "Averías";


		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");
		Thread.sleep(10000);

		int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
		int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
		int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
		int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
		int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
		int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);

		chatbotPage.SendMessage("No puedo activar Disney+");

		chatbotPage.NewMessageCheck(response1,msgnum1);

		WebElement noAparece = waitForElementToBeVisible(By.xpath("//button[@title=\"No aparece Disney+ en la TV\"]"));
		noAparece.click();
		chatbotPage.NewMessageCheck(response2,msgnum2);
		takeScreenShot(pathToEvidence+"\\Screenshot1.png");
		chatbotPage.NewMessageCheck(response3,msgnum3);
		chatbotPage.NewMessageCheck(response4,msgnum4);
		takeScreenShot(pathToEvidence+"\\Screenshot2.png");
		WebElement abrirInc = waitForElementToBeVisible(By.xpath("//button[@title=\"Sí, abrir una incidencia\"]"));
		abrirInc.click();
		chatbotPage.NewMessageCheck(response5,msgnum5);
		chatbotPage.NewMessageCheck(response6,msgnum6);
		takeScreenShot(pathToEvidence+"\\Screenshot3.png");

	}
	@DataProvider(name="AveriaDisneyPlus")
	public Object[][] CredentialsAveriaDisneyPlus()
	{
		ChatbotPage chatbotPage = new ChatbotPage(driver);
		Object[][] loginData = chatbotPage.getCredentialsData(48);
		return loginData;
	}

}