package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Extras extends BaseTest {


    @Test(dataProvider = "HBO")
    public void HBO(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("HBO", "Client: "+userName+"/"+password);

        String response1 = "Con ";
        String response2 = "HBO Max";
        String response3 = " nunca te aburres, siempre hay algo interesante que ver. Dime ¿con qué está relacionada tu consulta exactamente?";
        String response4 = "Te recomiendo consultar ";
        String response5 = "las preguntas frecuentes";
        String response6 = " y así poder conocer más detalles sobre HBO Max.";



        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password, pathToEvidence+"\\1User.png");
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


        chatbotPage.SendMessage("Tengo HBO activo?");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        WebElement informacion = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Información')]"));
        informacion.click();

        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");


    }
    @DataProvider(name = "HBO")
    public Object[][] credentials_HBO() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData( 11);
        return loginData;

    }



    @Test(dataProvider = "SecureNet")
    public void SecureNet(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("SecureNet", "Client: "+userName+"/"+password);

        String response1 = "Veo que tienes Secure Net ";
        String response2 = "activado";
        String response3 = ". Si te interesa, puedo contarte más cosas sobre el servicio o ayudarte a desactivarlo. ¿Qué quieres hacer?";
        String response4 = "Puedes ";
        String response5 = "desactivarlo desde Productos y Servicios";
        String response6 = ". Elige tu móvil y busca el apartado de ";
        String response7 = "Vodafone Secure Net";
        String response8 = " para gestionarlo.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 user.png");
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
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);
        int msgnum8 = chatbotPage.GetNumOfOldMsgs(response8);

        chatbotPage.SendMessage("Como doy de baja ese antivirus de Secure Net");
        Thread.sleep(5000);

        chatbotPage.NewMessageCheck(response1, msgnum1);
        chatbotPage.NewMessageCheck(response2, msgnum2);
        chatbotPage.NewMessageCheck(response3, msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement desactivarSN = waitForElementToBeVisible(By.xpath("//button[@title=\"Desactivar Secure Net\"]"));
        desactivarSN.click();

        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);
        chatbotPage.NewMessageCheck(response7,msgnum7);
        chatbotPage.NewMessageCheck(response8,msgnum8);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "SecureNet")
    public Object[][] credentials_SecureNet() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(46);
        return loginData;

    }



    @Test(dataProvider = "InfoDisneyPlus")
    public void InfoDisneyPlus(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("InfoDisneyPlus", "Client: "+userName+"/"+password);

        String response1 = "Te lo tengo que decir porque te estás perdiendo algo increíble: no tienes activado Disney+, y viene de manera ";
        String response2 = "gratuita con tu Hogar Ilimitable";
        String response3 = "Cuéntame, ¿en qué te puedo ayudar exactamente con Disney+?";
        String response4 = "Muy bien. Pues como querrás saberlo todo, te dejo las ";
        String response5 = "preguntas frecuentes sobre Disney+";


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 user.png");
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


        chatbotPage.SendMessage("Quiero activar Disney+");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);


        WebElement InfoPltf = waitForElementToBeVisible(By.xpath("//button[@title=\"Información sobre la plataforma\"]"));
        InfoPltf.click();

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name = "InfoDisneyPlus")
    public Object[][] credentials_InfoDisneyPlus() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(47);
        return loginData;

    }

}