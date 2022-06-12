package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Roaming extends BaseTest {

    @Test(dataProvider = "RoamingME")
    public void RoamingME(String userName, String password, String pathToEvicence) throws Exception {

        startTest("RoamingME", userName+"/"+password);

        String response1 = "Para darte la información que necesitas, dime, ¿desde dónde usarías tu línea?";
        String response2 = "Puedes consultar tus dudas, ver la tarifa que tendrías en cada país y gestionar los permisos de Roaming ";
        String response3 = "desde la nueva sección de la App";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvicence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.ME_Error();
        chatbotPage.OpenChatME();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);

        chatbotPage.SendMessage("Tengo Roaming activo?");

        chatbotPage.NewMessageCheck(response1, msgnum1);
        takeScreenShot(pathToEvicence+"\\Screenshot1.png");

        WebElement outSpain = waitForElementToBeVisible(By.xpath("//button[@title=\"Desde fuera de España\"]"));
        outSpain.click();

        chatbotPage.NewMessageCheck(response2, msgnum2);
        chatbotPage.NewMessageCheck(response3, msgnum3);

        takeScreenShot(pathToEvicence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name="RoamingME")
    public Object[][] credentials_RoamingME() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData =chatbotPage.getCredentialsData(23);
        return loginData;
    }


    @Test(dataProvider = "RoamingPartis")
    public void RoamingPartis(String userName, String password, String pathToEvicence) throws InterruptedException {

        startTest("RoamingPartis", userName+"/"+password);

        String response1 = "Para darte la información que necesitas, dime, ¿desde dónde usarías tu línea?";
        String response2 = "Puedes consultar tus dudas, ver la tarifa que tendrías en cada país y gestionar los permisos de Roaming ";
        String response3 = "desde la nueva sección de la App";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password,pathToEvicence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);

        chatbotPage.SendMessage("Tengo Roaming activo?");

        chatbotPage.NewMessageCheck(response1, msgnum1);
        takeScreenShot(pathToEvicence+"\\Screenshot1.png");

        WebElement outSpain = waitForElementToBeVisible(By.xpath("//button[@title=\"Desde fuera de España\"]"));
        outSpain.click();

        chatbotPage.NewMessageCheck(response2, msgnum2);
        chatbotPage.NewMessageCheck(response3, msgnum3);

        takeScreenShot(pathToEvicence+"\\Screenshot2.png");

        chatbotPage.EndConv();
    }
    @DataProvider(name="RoamingPartis")
    public Object[][] credentials_RoamingPartis() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData =chatbotPage.getCredentialsData(36);
        return loginData;
    }

}