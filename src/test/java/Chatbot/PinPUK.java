package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;


public class PinPUK extends BaseTest {

    @Test(dataProvider = "PinPUK_Partis")
    public void PinPUK_Partis(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("PinPUK_Partis", "Client: "+userName+"/"+password);


        String MSISDN = "623351559";
        String pin = "0022";
        String PUK = "88528242";

        String response1 = "Tienes varios móviles con nosotros. Te dejo una lista para que me digas con cuál necesitas ayuda:";
        String response2 = "¿Qué necesitas?";
        String response3 = "Código PIN";
        String response4 = "PIN: "+pin+"";
        String response5 = "¿Quieres conocer tu código PUK?";
        String response6 = "El código PUK para tu tarjeta SIM:";
        String response7 = "PUK:";
        String response8 = " "+PUK+" ";

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
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);
        int msgnum8 = chatbotPage.GetNumOfOldMsgs(response8);

        chatbotPage.SendMessage("Necesito el codigo para desbloquear mi movil");

        chatbotPage.NewMessageCheck(response1,msgnum1);

        WebElement MSISDN_button = waitForElementToBeVisible(By.xpath("//button[@title=\'"+MSISDN+"']"));
        MSISDN_button.click();

        takeScreenShot(pathToEvidence+"\\Screenshot.png");

        chatbotPage.NewMessageCheck(response2,msgnum2);
        WebElement Pin_Button = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'PIN')])[last()]"));
        Pin_Button.click();

        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response5, msgnum5);
        WebElement VerPUK = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Sí, quiero')])[last()]"));
        VerPUK.click();

        chatbotPage.NewMessageCheck(response6, msgnum6);
        chatbotPage.NewMessageCheck(response7, msgnum7);
        chatbotPage.NewMessageCheck(response8, msgnum8);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

    }
    @DataProvider(name = "PinPUK_Partis")
    public Object[][] credentials_PinPUK_Partis() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(32);

        return loginData;

    }


    @Test(dataProvider = "PinPUK_Micros")
    public void PinPUK_Micros(String userName, String password, String pathToEvidence) throws Exception{

        startTest("PinPUK_Micros", "Client: "+userName+"/"+password);

        String MSISDN = "605317090";
        String pin = "8888";
        String PUK = "23215373";

        String response1 = "Tienes varios móviles con nosotros. Te dejo una lista para que me digas con cuál necesitas ayuda:";
        String response2 = "¿Qué necesitas?";
        String response3 = "Código PIN";
        String response4 = "PIN: "+pin+"";
        String response5 = "¿Quieres conocer tu código PUK?";
        String response6 = "El código PUK para tu tarjeta SIM:";
        String response7 = "PUK:";
        String response8 = " "+PUK+" ";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatME();
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

        chatbotPage.SendMessage("Necesito el codigo para desbloquear mi movil");

        chatbotPage.NewMessageCheck(response1,msgnum1);

        WebElement MSISDN_button = waitForElementToBeVisible(By.xpath("//button[@title=\'"+MSISDN+"']"));
        MSISDN_button.click();

        takeScreenShot(pathToEvidence+"\\Screenshot.png");

        chatbotPage.NewMessageCheck(response2,msgnum2);
        WebElement Pin_Button = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'PIN')])[last()]"));
        Pin_Button.click();

        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response5, msgnum5);
        WebElement VerPUK = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Sí, quiero')])[last()]"));
        VerPUK.click();

        chatbotPage.NewMessageCheck(response6, msgnum6);
        chatbotPage.NewMessageCheck(response7, msgnum7);
        chatbotPage.NewMessageCheck(response8, msgnum8);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");


    }
    @DataProvider(name = "PinPUK_Micros")
    public Object[][] credentials_PinPUK_Micros() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(22);
        System.out.println(loginData);
        return loginData;

    }

}