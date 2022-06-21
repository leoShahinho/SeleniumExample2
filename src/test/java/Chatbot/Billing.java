package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;
import org.testng.Assert;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;


public class Billing extends BaseTest {

    @Test(dataProvider = "DifFacturaMayor")
    public void DifFacturaMayor(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("DifFacturaMayor", "Client: "+userName+"/"+password);

        String response1 = "Vamos a ver juntos tu consulta sobre facturas:";
        String response2 = "has gastado 15,00€ más";
        String response3 = "¿Quieres que te cuente cómo configurar estos servicios para que no se cobre ninguno más de ahora en adelante?";
        String response4 = "ver el detalle en la sección Mis Facturas.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);

        chatbotPage.SendMessage("Qué diferencia hay en mi factura de marzo?");
        chatbotPage.NewMessageCheck(response1, msgnum);
        chatbotPage.NewMessageCheck(response2, msgnum2);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        chatbotPage.NewMessageCheck(response3, msgnum3);
        chatbotPage.SendMessage("No gracias");
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        chatbotPage.NewMessageCheck(response4, msgnum4);
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");
        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot4.png");

    }
    @DataProvider(name = "DifFacturaMayor")
    public Object[][] credentials_DifFacturaMayor() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(5);
        return loginData;

    }




    @Test(dataProvider = "DifFacturaMenor")
    public void DifFacturaMenor(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("DifFacturaMenor", "Client: "+userName+"/"+password);

        String response1 = "Vamos a ver juntos tu consulta sobre facturas:";
        String response2 = "El importe de tu factura de febrero es";
        String response3 = "has gastado 15,00€ menos";


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);


        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);


        chatbotPage.SendMessage("Qué diferencia hay en mi factura de febrero?");
        chatbotPage.NewMessageCheck(response1, msgnum1);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        chatbotPage.NewMessageCheck(response1, msgnum2);
        chatbotPage.NewMessageCheck(response1, msgnum3);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

    }
    @DataProvider(name = "DifFacturaMenor")
    public Object[][] credentials_DifFacturaMenor() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(6);
        return loginData;

    }




    @Test(dataProvider = "DifFacturaMenor1eur")
    public void DifFacturaMenor1eur(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("DifFacturaMenor1eur", "Client: "+userName+"/"+password);

        String response1 = "Vamos a ver juntos tu consulta sobre facturas:";
        String response2 = "Por lo que veo, el importe de la factura de abril es ";
        String response3 = "129,50 €";
        String response4 = "menos de 1 euro";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);

        chatbotPage.SendMessage("Qué diferencia hay en mi factura de abril?");

        chatbotPage.NewMessageCheck(response1, msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name = "DifFacturaMenor1eur")
    public Object[][] credentials_DifFacturaMenor1eur() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(7);
        return loginData;

    }




    @Test(dataProvider = "DescargaFacMes")
    public void DescargaFacMes(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("DescargaFacMes", "Client: "+userName+"/"+password);


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum = chatbotPage.GetNumOfOldMsgs("Factura abril");

        chatbotPage.SendMessage("Quiero descargar mi factura de abril");

        //chatbotPage.NewMessageCheck("Factura abril", msgnum);
        //WebElement descargaFac = waitForElementToBeVisible(By.xpath("(//a[@title=\"Descargar factura\"])[last()]"));
        //takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        //descargaFac.click();
        //SwitchTab();
        //Thread.sleep(15000);
        //String URL = driver.getCurrentUrl();
        //Assert.assertTrue(URL.contains("https://channels-vf-es-prepro.brandembassy.com/vf-chatbot/1.0/attachments"));

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name = "DescargaFacMes")
    public Object[][] credentials_DescargaFacMes() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(3);
        return loginData;

    }




    @Test(dataProvider = "CicloFac")
    public void CicloFac(String userName, String password, String pathToEvidence) throws InterruptedException {


        startTest("CicloFac", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password,pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);
        int msgnum = chatbotPage.GetNumOfOldMsgs("Puedes ver tu factura en ");
        int msgnum2 = chatbotPage.GetNumOfOldMsgs("¿Qué es el ciclo de facturación?");
        int msgnum3 = chatbotPage.GetNumOfOldMsgs("Si tu consulta está relacionada con alguna gestión sobre tu ciclo de facturación, te recomiendo contar con la ayuda de un humano. ¿Quieres que te atienda cuando esté disponible?");


        chatbotPage.SendMessage("Quiero saber qué día me cobrais la factura");
        chatbotPage.NewMessageCheck("Puedes ver tu factura en ", msgnum);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        chatbotPage.NewMessageCheck("¿Qué es el ciclo de facturación?", msgnum2);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        Thread.sleep(10000);
        chatbotPage.NewMessageCheck("Si tu consulta está relacionada con alguna gestión sobre tu ciclo de facturación, te recomiendo contar con la ayuda de un humano. ¿Quieres que te atienda cuando esté disponible?", msgnum3);
        WebElement enOtroMomento = waitForElementToBeVisible(By.xpath("//button[@title=\"No, en otro momento\"]"));
        enOtroMomento.click();
        takeScreenShot(pathToEvidence+"\\Screenshot3.png");
        chatbotPage.EndConv();
    }
    @DataProvider(name = "CicloFac")
    public Object[][] credentials_CicloFac() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(2);
        return loginData;

    }



    @Test(dataProvider = "FacFutura")
    public void FacFutura(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("FacFutura", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password,pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum = chatbotPage.GetNumOfOldMsgs("¡Vaya! Todavía no tienes disponible tu primera factura.");
        int msgnum2 = chatbotPage.GetNumOfOldMsgs("Podré contarte algo sobre esa factura a partir del día");

        chatbotPage.SendMessage("Quiero descargar mi factura de MARZO de 2022");

        chatbotPage.NewMessageCheck("¡Vaya! Todavía no tienes disponible tu primera factura.", msgnum);
        chatbotPage.NewMessageCheck("Podré contarte algo sobre esa factura a partir del día 4 de abril .", msgnum2);

        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

    }
    @DataProvider(name = "FacFutura")
    public Object[][] credentials_FacFutura() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(1);
        return loginData;

    }




    @Test(dataProvider = "FacturaTerminal")
    public void FacturaTerminal(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("FacturaTerminal", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(10000);
        chatbotPage.SendMessage("Quiero descargar mi factura de terminal");

        //WebElement Descargar = waitForElementToBeVisible(By.xpath("(//a[@title=\"Descargar PDF\"])[last()]"));
        //takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        //Descargar.click();
        //SwitchTab();
        //String URL = driver.getCurrentUrl();
        //Assert.assertTrue(URL.contains("https://channels-vf-es-prepro.brandembassy.com/vf-chatbot/1.0/attachments"));
        //Thread.sleep(5000);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name = "FacturaTerminal")
    public Object[][] credentials_FacturaTerminal() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(8);
        return loginData;

    }




    @Test(dataProvider = "FacPasada")
    public void FacPasada(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("FacPasada", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);
        chatbotPage.SendMessage("Quiero descargar mi factura de octubre de 2020");


        int msgnum = chatbotPage.GetNumOfOldMsgs("La factura que me pides tiene más de 12 meses, así que no tengo acceso a ella, pero un humano te puede ayudar. ¿Quieres que se ponga en contacto contigo lo antes posible?");
        chatbotPage.NewMessageCheck("La factura que me pides tiene más de 12 meses, así que no tengo acceso a ella, pero un humano te puede ayudar. ¿Quieres que se ponga en contacto contigo lo antes posible?", msgnum);


        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement noGracias = waitForElementToBeVisible(By.xpath("//button[@title=\"No, gracias\"]"));
        noGracias.click();

        msgnum = chatbotPage.GetNumOfOldMsgs("¿Quieres consultar alguna otra factura?");
        chatbotPage.NewMessageCheck("¿Quieres consultar alguna otra factura?", msgnum);

        chatbotPage.SendMessage("No, gracias");

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "FacPasada")
    public Object[][] credentials_FacPasada() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(4);
        return loginData;

    }

}