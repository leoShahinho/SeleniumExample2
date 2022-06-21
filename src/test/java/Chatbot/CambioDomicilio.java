package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class CambioDomicilio extends BaseTest {

    @Test(dataProvider = "CambioDomicilio")
    public void CambioDomicilio(String userName, String password, String pathToEvidence) throws Exception  {

        startTest("CambioDomicilio", "Client: "+userName+"/"+password);

        String response1 = "Antes de realizar un traslado te recomiendo ";
        String response2 = "consultar las condiciones de cambio de domicilio";
        String response3 = "Recuerda que puedes pedir el cambio de domicilio de los servicios contratados en cualquier tienda Vodafone " +
                          "o con la ayuda de uno de nuestros agentes. ¿Qué quieres hacer?";
        String response4 = "¡Genial! ";
        String response5 = "Localiza la tienda más cercana y pide tu cita";
        String response6 = " para no tener que esperar.";


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);


        chatbotPage.SendMessage("Voy a cambiar de casa y quiero cambiar mi dirección con vosotros");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement localizarTienda = waitForElementToBeVisible(By.xpath("//button[@title=\"Localizar tienda\"]"));
        localizarTienda.click();

        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

    }
    @DataProvider(name = "CambioDomicilio")
    public Object[][] credentials_CambioDomicilio() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(31);
        return loginData;

    }

}