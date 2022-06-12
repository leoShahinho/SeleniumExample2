package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Permas_Partis extends BaseTest {
//need to edit the amount

    @Test(dataProvider = "Permas_Partis")
    public void Permas_Partis(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("Permas_Partis", "Client: "+userName+"/"+password);

        //String totalPermas = "89,45€.";
        //String penality = "74,35 €";

        //String response1 = "A día de hoy tienes varias permanencias con un importe total de "+totalPermas+"";
        String response2 = "Permanencia en servicio";
        String response3 = "Penalización:";
        //String response4 = penality;
        String response5 = "Fecha inicio y fin:";
        String response6 = "26/02/2021 al 26/02/2023";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password,pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(10000);

        //int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        //int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);


        chatbotPage.SendMessage("Qué permanencia tengo con vosotros?");
        //chatbotPage.NewMessageCheck(response1,msgnum1);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);
        //chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "Permas_Partis")
    public Object[][] credentials_Permas_Partis() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(33);
        System.out.println(loginData);
        return loginData;

    }

}