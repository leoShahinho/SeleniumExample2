package Chatbot;

import SetupsAndPages.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;
import org.testng.internal.reflect.MethodMatcherException;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Averias extends BaseTest {




    @Test(dataProvider = "Averias")
    public void Averias(String userName, String password, String pathToEvidence) throws Exception {

        startTest("Averias", "");

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);
        int msgnum = chatbotPage.GetNumOfOldMsgs("Avería de móvil");
        chatbotPage.SendMessage("Quiero saber el estado de mis averías");
        takeScreenShot(pathToEvidence+"\\Screenshot.png");
        chatbotPage.NewMessageCheck("Avería de móvil", msgnum);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        Thread.sleep(5000);
    }
    @DataProvider(name = "Averias")
    public Object[][] CredentialsAverias ()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(35);
        return loginData;

    }



    @Test(dataProvider = "ProactividadAverias")
    public void ProactividadAverias (String userName, String password, String pathToEvidence) throws Exception {

        String Response1Text = "resolver todas tus averías";
        String Response2Text = "Y no te preocupes porque en caso de que no consigamos arreglarlo, un humano se hará cargo de tu caso lo antes posible para ayudarte personalmente.";
        String Response3Text = "Sí";
        String Response4Text = "No";

        startTest("ProactividadAverias", "");

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(8000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(Response1Text);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(Response2Text);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(Response3Text);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(Response4Text);


        chatbotPage.SendMessage("Tengo problemas con mi línea de internet");
        chatbotPage.NewMessageCheck(Response1Text, msgnum1);
        chatbotPage.NewMessageCheck(Response2Text, msgnum2);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        Thread.sleep(15000);
        chatbotPage.SendMessage("Hola");
        chatbotPage.NewMessageCheck(Response3Text, msgnum3);
        chatbotPage.NewMessageCheck(Response4Text, msgnum4);

        Thread.sleep(5000);
        takeScreenShot(pathToEvidence+"\\Screenshot2.png");


    }
    @DataProvider(name="ProactividadAverias")
    public Object[][] CredentialsProactividadAverias()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(42);
        return loginData;
    }



    @Test(dataProvider = "Reclamaciones")
    public void Reclamaciones(String userName, String password, String pathToEvidence) throws InterruptedException{

        String textResponse2 = "Creo que para esta gestión vendría bien la intervencion de un humano. ¿Quieres que se haga cargo del tema lo antes posible?";

        startTest("Reclamaciones", "");

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum2 = chatbotPage.GetNumOfOldMsgs(textResponse2);

        chatbotPage.SendMessage("Quiero que me devolváis el dinero que me habeis cobrado de más");

        WebElement OtroAsunto = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Otro asunto')]"));
        OtroAsunto.click();

        chatbotPage.NewMessageCheck(textResponse2,msgnum2);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

    }
    @DataProvider(name="Reclamaciones")
    public Object[][] CredentialsReclamaciones()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(44);
        return loginData;
    }



    @Test(dataProvider ="SimNueva")
    public void SimNueva(String userName, String password, String pathToEvidence) throws InterruptedException{

        String textResponse1 = "Te puedo prestar esta ayuda con tu tarjeta SIM:";
        String textResponse2 = "Dime, ¿has hecho una portabilidad desde otro operador o has dado de alta una nueva línea en Vodafone?";
        String textResponse3 = "Estos son los 3 pasos para activar tu SIM cuando has hecho una portabilidad:";
        String textResponse4 = "confirmar el estado de la portabilidad";
        String textResponse5 = "1550";
        String textResponse6 = "Introduce la SIM y el PIN en tu teléfono.";

        startTest("SimNueva", "");

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(textResponse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(textResponse2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(textResponse3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(textResponse4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(textResponse5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(textResponse6);

        chatbotPage.SendMessage("Como pido una tarjeta SIM de sustitución?");

        chatbotPage.NewMessageCheck(textResponse1,msgnum1);

        WebElement ActivarTarjeta = waitForElementToBeVisible(By.xpath("//button[@title=\"Activar la tarjeta\"]"));
        ActivarTarjeta.click();

        chatbotPage.NewMessageCheck(textResponse2,msgnum2);

        WebElement Portabilidad = waitForElementToBeVisible(By.xpath("//button[@title=\"Portabilidad\"]"));
        Portabilidad.click();

        takeScreenShot(".\\Screenshots\\TC51. Client wants a new sim card (asks for substitute one)\\Screenshot1.png");


        chatbotPage.NewMessageCheck(textResponse3,msgnum3);
        chatbotPage.NewMessageCheck(textResponse4,msgnum4);
        chatbotPage.NewMessageCheck(textResponse5,msgnum5);
        chatbotPage.NewMessageCheck(textResponse6,msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "SimNueva")
    public Object[][] Credentials_SimNueva(){

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(51);
        return loginData;

    }




    @Test(dataProvider = "SimDuplicada")
    public void SimDuplicada(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("AmazonPrimeActivo", "");


        String textResponse1 = "Localiza tu tienda más cercana";
        String textResponse2 = "condiciones para pedir un duplicado";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password, pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(textResponse1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(textResponse2);

        chatbotPage.SendMessage("Necesito un duplicado de mi tarjeta");

        chatbotPage.NewMessageCheck(textResponse1,msgnum1);
        chatbotPage.NewMessageCheck(textResponse2,msgnum2);

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

    }
    @DataProvider(name="SimDuplicada")
    public Object[][] Credentials_SimDuplicada()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(50);
        return loginData;
    }



    @Test(dataProvider = "BajaInternet")
    public void BajaInternet(String userName, String password, String pathToEvidence) throws InterruptedException{


        String response1 = "¡Vaya! Entiendo que hay algún servicio que ya no quieres seguir disfrutando.";
        String response2 = "¿De cuál se trata?";
        String response3 = "Para poder seguir mejorando, ¿podrías decirme el motivo por el que quieres prescindir del servicio?";
        String response4 = "código de verificación";
        String response5 = "¿Quieres que te atienda en cuanto esté disponible?";

        startTest("AmazonPrimeActivo", "");

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

        chatbotPage.SendMessage("Me quiero dar de baja");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);

        WebElement Internet = waitForElementToBeVisible(By.xpath("//button[@title=\"Internet\"]"));
        Internet.click();

        chatbotPage.NewMessageCheck(response3,msgnum3);

        WebElement PorElPrecio = waitForElementToBeVisible(By.xpath("//button[@title=\"Por el precio\"]"));
        PorElPrecio.click();

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");


        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name="BajaInternet")
    public Object[][] Credentials_BajaInternet()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(41);
        return loginData;
    }



    @Test(dataProvider = "ConsultaPedidos")
    public void ConsultaPedidos(String userName, String password, String pathToEvidence) throws InterruptedException{


        String response1 = "ir a la sección Mis Pedidos";
        String response2 = "consultar las preguntas frecuentes";

        startTest("AmazonPrimeActivo", "");

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(10000);
        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        chatbotPage.SendMessage("Tengo algún pedido");
        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

    }
    @DataProvider(name="ConsultaPedidos")
    public Object[][] CredentialsConsultaPedidos()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(43);
        return loginData;
    }

}