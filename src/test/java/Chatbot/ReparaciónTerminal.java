package Chatbot;

import SetupsAndPages.ExcelDataConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import java.awt.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;


public class Reparaci�nTerminal extends BaseTest {

    @Test(dataProvider = "ReparacionTerminal")
    public void Reparaci�nTerminal(String userName, String password, String pathToEvicence) throws InterruptedException {

        startTest("ReparacionTerminal", userName+"/"+password);

        String response1 = "Vale, lo primero que necesito saber es el motivo de tu consulta. �Quieres reparar tu m�vil o conocer el estado de una reparaci�n?";
        String response2 = "De acuerdo, para llevarlo a reparar, te recomiendo ";
        String response3 = "reservar una cita previa";
        String response4 = " en tu tienda m�s cercana para que no tengas que esperar.";
        String response5 = "Recuerda descargar la ";
        String response6 = "factura del terminal";
        String response7 = " que compraste con nosotros para conocer el periodo de garant�a, lo necesitar�s.";
        String response8 = "�Quieres m�s informaci�n sobre reparaciones y garant�as de terminales?";
        String response9 = "Vale, te dejo los pasos a seguir e informaci�n ampliada sobre garant�as y coberturas en nuestras ";
        String response10 = "preguntas frecuentes";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvicence+"\\1 user.png");
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
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);
        int msgnum8 = chatbotPage.GetNumOfOldMsgs(response8);
        int msgnum9 = chatbotPage.GetNumOfOldMsgs(response9);
        int msgnum10 = chatbotPage.GetNumOfOldMsgs(response10);


        chatbotPage.SendMessage("Necesito reparar mi terminal");
        chatbotPage.NewMessageCheck(response1, msgnum1);
        takeScreenShot(pathToEvicence+"\\Screenshot1.png");

        WebElement RepararMovil = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Reparar m�vil')]"));
        RepararMovil.click();

        chatbotPage.NewMessageCheck(response2, msgnum2);
        chatbotPage.NewMessageCheck(response3, msgnum3);
        chatbotPage.NewMessageCheck(response4, msgnum4);

        takeScreenShot(pathToEvicence+"\\Screenshot2.png");

        chatbotPage.NewMessageCheck(response5, msgnum5);
        chatbotPage.NewMessageCheck(response6, msgnum6);
        chatbotPage.NewMessageCheck(response7, msgnum7);

        takeScreenShot(pathToEvicence+"\\Screenshot3.png");

        chatbotPage.NewMessageCheck(response8, msgnum8);

        WebElement siGracias = waitForElementToBeVisible(By.xpath("//button[contains(@title,'S�, gracias')]"));
        siGracias.click();

        chatbotPage.NewMessageCheck(response9, msgnum9);
        chatbotPage.NewMessageCheck(response10, msgnum10);

        chatbotPage.EndConv();

        takeScreenShot(pathToEvicence+"\\Screenshot4.png");

    }
    @DataProvider(name="ReparacionTerminal")
    public Object[][] credentials_Reparaci�nTerminal() {

            ChatbotPage chatbotPage = new ChatbotPage(driver);
            Object[][] loginData =chatbotPage.getCredentialsData(28);
            return loginData;
        }

}

