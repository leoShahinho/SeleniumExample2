package Chatbot;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;


public class AmazonPrime extends BaseTest {


    @Test(dataProvider = "AmazonPrimeActivo")

    public void AmazonPrimeActivo(String userName, String password, String pathToEvidence) throws InterruptedException {


        startTest("AmazonPrimeActivo", "This is a test for Amazon Prime active");

        String resonse1 ="Veo que sigues teniendo dudas sobre Amazon Prime. ¿La última consulta que me hiciste sobre este servicio quedó resuelta?";
        String resonse2 ="tienes Amazon Prime activado";
        String resonse3 ="¿Qué quieres saber sobre este servicio?";
        String resonse4 ="Si lo que necesitas es más información sobre Amazon Prime, te recomiendo ";
        String resonse5 ="consultar las preguntas frecuentes";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(10000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(resonse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(resonse2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(resonse3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(resonse4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(resonse5);

        chatbotPage.SendMessage("Tengo Amazon Prime activo?");

        boolean dudasMsg = chatbotPage.NewMessageCheck(resonse1,msgnum1);

        if (dudasMsg != false){
            waitForElementToBeVisible(By.xpath("//button[@title='Sí, quiero preguntarte otra cosa']")).click();}
        else

            chatbotPage.NewMessageCheck(resonse2,msgnum2);
        chatbotPage.NewMessageCheck(resonse3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        WebElement masInfo = waitForElementToBeVisible(By.xpath("//button[@title='Más información']"));
        masInfo.click();

        chatbotPage.NewMessageCheck(resonse4,msgnum4);
        chatbotPage.NewMessageCheck(resonse5,msgnum5);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        WebElement noGracias = waitForElementToBeVisible(By.xpath("//button[@title=\"Nada más, gracias\"]"));
        noGracias.click();

        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");


    }
    @DataProvider(name = "AmazonPrimeActivo")
    public Object[][] credentials_AmazonPrimeActivo1() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(10);
        return loginData;

    }


    @Test(dataProvider = "AmazonPrimeInactivo")
    public void AmazonPrimeInactivo(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("AmazonPrimeInactivo", "This is a test");

        String resonse1 ="Veo que sigues teniendo dudas sobre Amazon Prime. ¿La última consulta que me hiciste sobre este servicio quedó resuelta?";
        String resonse2 ="Veo que no tienes contratado ninguno de los packs que tienen acceso exclusivo a Amazon Prime: Serielovers, Serielovers Clásico, Familylovers, Hogar Ilimitable o TV Plus x2.";
        String resonse3 ="¿Quieres contratar alguno de estos packs y así poder disfrutar, entre otras cosas, de Amazon Prime?";
        String resonse4 ="¡Genial! Esta gestión es mejor que la haga un humano. ¿Quieres que te atienda en cuanto esté disponible?";
        String resonse5 ="Tómate el tiempo que necesites. Mientras, puedes ";
        String resonse6 ="consultar aquí las preguntas frecuentes";
        String resonse7 =" y así saber más sobre el tema.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(resonse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(resonse2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(resonse3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(resonse4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(resonse5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(resonse6);
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(resonse7);

        chatbotPage.SendMessage("Tengo Amazon Prime activo?");

        boolean dudasMsg = chatbotPage.NewMessageCheck(resonse1,msgnum1);

        if (dudasMsg != false){
            waitForElementToBeVisible(By.xpath("//button[@title='Sí, quiero preguntarte otra cosa']")).click();}
        else

            chatbotPage.NewMessageCheck(resonse2,msgnum2);
        chatbotPage.NewMessageCheck(resonse3,msgnum3);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        WebElement buenaIdea = waitForElementToBeVisible(By.xpath("//button[@title='¡Buena idea!']"));
        buenaIdea.click();
        chatbotPage.NewMessageCheck(resonse4,msgnum4);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        WebElement enOtroMomento = waitForElementToBeVisible(By.xpath("//button[@title=\"En otro momento\"]"));
        enOtroMomento.click();
        chatbotPage.NewMessageCheck(resonse5,msgnum5);
        chatbotPage.NewMessageCheck(resonse6,msgnum6);
        chatbotPage.NewMessageCheck(resonse7,msgnum7);
        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

    }
    @DataProvider(name = "AmazonPrimeInactivo")
    public Object[][] credentials_AmazonPrimeInactivo() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(9);
        return loginData;

    }


    @Test(dataProvider = "AmazonPrimeME")
    public void AmazonPrimeME(String userName, String password, String pathToEvidence) throws Exception{

        startTest("AmazonPrimeME", "This is a test");

        String resonse1 ="Veo que sigues teniendo dudas sobre Amazon Prime. ¿La última consulta que me hiciste sobre este servicio quedó resuelta?";
        String resonse2 ="Veo que no tienes Amazon Prime activado con Vodafone.";
        String resonse3 ="¿Qué quieres saber sobre este servicio?";
        String resonse4 ="Si lo que necesitas es más información sobre Amazon Prime, te recomiendo ";
        String resonse5 ="consultar las preguntas frecuentes";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatME();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(10000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(resonse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(resonse2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(resonse3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(resonse4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(resonse5);

        chatbotPage.SendMessage("Tengo Amazon Prime activo?");

        boolean dudasMsg = chatbotPage.NewMessageCheck(resonse1,msgnum1);

        if (dudasMsg != false){
            waitForElementToBeVisible(By.xpath("//button[@title='Sí, quiero preguntarte otra cosa']")).click();}
        else

            chatbotPage.NewMessageCheck(resonse2,msgnum2);
        chatbotPage.NewMessageCheck(resonse3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        WebElement masInfo = waitForElementToBeVisible(By.xpath("//button[@title='Más información']"));
        masInfo.click();

        chatbotPage.NewMessageCheck(resonse4,msgnum4);
        chatbotPage.NewMessageCheck(resonse5,msgnum5);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        WebElement noGracias = waitForElementToBeVisible(By.xpath("//button[@title=\"Nada más, gracias\"]"));
        noGracias.click();

        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");


    }
    @DataProvider(name = "AmazonPrimeME")
    public Object[][] credentials_AmazonPrimeME() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(25);
        return loginData;

    }

}




