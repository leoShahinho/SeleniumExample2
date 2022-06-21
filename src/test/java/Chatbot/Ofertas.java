package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Ofertas extends BaseTest {

    @Test(dataProvider = "LineaAdicional")
    public void LineaAdicional(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("LineaAdicional", "Client: "+userName+"/"+password);

        String response1 = "Así que quieres añadir una línea nueva... ¿Qué tipo de línea te interesa?";
        String response2 = "Estás de suerte, ¡tenemos una oferta para ti! Puedes ";
        String response3 = "contratar tu línea adicional";
        String response4 = " entrando en la App, donde encontrarás información sobre nuestras tarifas y los pasos para activarla.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);

        chatbotPage.SendMessage("Quiero comprar una línea adicional");
        chatbotPage.NewMessageCheck(response1, msgnum1);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement LineasContrato = waitForElementToBeVisible(By.xpath("//button[@title=\"Línea de contrato\"]"));
        LineasContrato.click();

        chatbotPage.NewMessageCheck(response2, msgnum2);
        chatbotPage.NewMessageCheck(response3, msgnum3);
        chatbotPage.NewMessageCheck(response4, msgnum4);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();
    }
    @DataProvider(name = "LineaAdicional")
    public Object[][] credentials_LineaAdicional() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(29);
        return loginData;

    }




    @Test(dataProvider = "OneNumber_Partis")
    public void OneNumber_Partis(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("OneNumber_Partis", "Client: "+userName+"/"+password);

        String response1 = "Con ";
        String response2 = "OneNumber,";
        String response3 = " puedes conectar varios dispositivos con tu número móvil, sin cambiar la SIM para tener todo el contenido sincronizado.\n" + "Descubre ";
        String response4 = "cómo configurar el servicio y dispositivos compatibles.";
        String response5 = "Dime si necesitas algo más de OneNumber:";
        String response6 = "Para activarlo ve a ";
        String response7 = "Productos y servicios";
        String response8 = ", y en la pestaña ";
        String response9 = "Mi Tarifa";
        String response10 = " ve a ";
        String response11 = " y pulsa activar.";
        String response12 = "Verás cuánto cuesta durante la activación, dependiendo del dispositivo que quieras incluir.";


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password,pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1  = chatbotPage.GetNumOfOldMsgs(response1 );
        int msgnum2  = chatbotPage.GetNumOfOldMsgs(response2 );
        int msgnum3  = chatbotPage.GetNumOfOldMsgs(response3 );
        int msgnum4  = chatbotPage.GetNumOfOldMsgs(response4 );
        int msgnum5  = chatbotPage.GetNumOfOldMsgs(response5 );
        int msgnum6  = chatbotPage.GetNumOfOldMsgs(response6 );
        int msgnum7  = chatbotPage.GetNumOfOldMsgs(response7 );
        int msgnum8  = chatbotPage.GetNumOfOldMsgs(response8 );
        int msgnum9  = chatbotPage.GetNumOfOldMsgs(response9 );
        int msgnum10 = chatbotPage.GetNumOfOldMsgs(response10);
        int msgnum11 = chatbotPage.GetNumOfOldMsgs(response11);
        int msgnum12 = chatbotPage.GetNumOfOldMsgs(response12);

        chatbotPage.SendMessage("Necesito informacion sobre OneNumber");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement activa_OneNumber = waitForElementToBeVisible(By.xpath("(//button[@title=\"Cómo activarlo\"])[last()]"));
        activa_OneNumber.click();

        chatbotPage.NewMessageCheck(response6 ,msgnum6 );
        chatbotPage.NewMessageCheck(response7 ,msgnum7 );
        chatbotPage.NewMessageCheck(response8 ,msgnum8 );
        chatbotPage.NewMessageCheck(response9 ,msgnum9 );
        chatbotPage.NewMessageCheck(response10,msgnum10);
        chatbotPage.NewMessageCheck(response11,msgnum11);
        chatbotPage.NewMessageCheck(response12,msgnum12);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "OneNumber_Partis")
    public Object[][] credentials_OneNumber_Partis() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(30);
        return loginData;

    }




    @Test(dataProvider = "Renon")
    public void Renon(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("Renon", "Client: "+userName+"/"+password);

        String response1 = "Como los descuentos están pensados para ti necesitas atención personalizada.";
        String response2 = "Para eso tengo que ponerte en contacto con un humano. ¿Quieres que te atienda cuando esté disponible?";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);

        chatbotPage.SendMessage("Tienes algún descuento para mi?");

        chatbotPage.NewMessageCheck(response1, msgnum1);
        chatbotPage.NewMessageCheck(response2, msgnum2);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement ahoraNo = waitForElementToBeVisible(By.xpath("//button[@title=\"Ahora no\"]"));
        ahoraNo.click();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");


    }
    @DataProvider(name = "Renon")
    public Object[][] credentials_Renon() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(27);
        return loginData;

    }




    @Test(dataProvider = "CTimposible")
    public void CTimposible(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("CTimposible", "Client: "+userName+"/"+password);

        String reponse1 = "Cualquier compra de ";
        String reponse2 = "nuestro catálogo";
        String reponse3 = " hay que asociarla a una línea móvil y tú no tienes ninguna disponible. Si quieres, puedo pasarte con un humano que te ayude.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(reponse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(reponse2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(reponse3);

        chatbotPage.SendMessage("Quiero saber que terminal me puedo comprar");

        chatbotPage.NewMessageCheck(reponse1,msgnum1);
        chatbotPage.NewMessageCheck(reponse2,msgnum2);
        chatbotPage.NewMessageCheck(reponse3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement enOtroMomento = waitForElementToBeVisible(By.xpath("//button[@title=\"No, en otro momento\"]"));
        enOtroMomento.click();

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name = "CTimposible")
    public Object[][] credentials_CTimposible() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(39);
        return loginData;

    }




    @Test(dataProvider = "CTposible")
    public void CTposible(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("CTposible", "Client: "+userName+"/"+password);

        String response1 = "Pues estás en el sitio correcto. ";
        String response2 = "Visita  nuestro catálogo";
        String response3 = ", en el que encontrarás desde móviles, ordenadores pasando por TVs y patinetes, " +
                "elige lo que quieras y llévatelo al mejor precio. No olvides asociar la compra a una de tus líneas.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum1 =  chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 =  chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 =  chatbotPage.GetNumOfOldMsgs(response3);

        chatbotPage.SendMessage("Quiero saber que terminal me puedo comprar");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");


    }
    @DataProvider(name = "CTposible")
    public Object[][] credentials_CTposible() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(38);
        return loginData;

    }

}