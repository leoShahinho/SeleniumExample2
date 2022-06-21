package Chatbot;

import SetupsAndPages.BaseTest;
import SetupsAndPages.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import SetupsAndPages.Pages.ChatbotPage;
import org.testng.internal.reflect.MethodMatcherException;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Averias extends BaseTest {




    @Test(dataProvider = "Averias")
    public void Averias(String userName, String password, String pathToEvidence) throws Exception {

        startTest("Averias", "Client: "+userName+"/"+password);

        String textMsg1 = "Nuestro equipo técnico sigue trabajando en la ";
        String textMsg2 = "Avería de móvil";
        String textMsg3 = " que abriste el 14/06/2022 12:57h. Puedes ";
        String textMsg4 = "ver los detalles";
        String textMsg5 = " para estar al tanto o revisarla con nuestros expertos.";
        String textMsg6 = "Si fuera necesario, uno de nuestros expertos se pondrá en contacto contigo pronto.";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName, password, pathToEvidence+"\\1 user.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1 = chatbotPage.GetNumOfOldMsgs(textMsg1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(textMsg2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(textMsg3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(textMsg4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(textMsg5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(textMsg6);

        chatbotPage.SendMessage("Quiero saber el estado de mis averías");
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(textMsg1, msgnum1);
        chatbotPage.NewMessageCheck(textMsg2, msgnum2);
        chatbotPage.NewMessageCheck(textMsg3, msgnum3);
        chatbotPage.NewMessageCheck(textMsg4, msgnum4);
        chatbotPage.NewMessageCheck(textMsg5, msgnum5);
        chatbotPage.NewMessageCheck(textMsg6, msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
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

        String Response1Text = "Esto hay que arreglarlo lo antes posible. ";
        String Response2Text = "Resuelve todas tus averías";
        String Response3Text = ", selecciona el servicio afectado y sigue los pasos.";
        String Response4Text = "Y no te preocupes porque si no conseguimos arreglarlo, un humano se hará cargo de tu caso lo antes posible y te ayudará personalmente.";
        String Response6Text = "Sí";
        String Response7Text = "No";

        startTest("ProactividadAverias", "Client: "+userName+"/"+password);

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
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(Response6Text);
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(Response6Text);

        chatbotPage.SendMessage("Tengo problemas con mi línea de internet");
        chatbotPage.NewMessageCheck(Response1Text, msgnum1);
        chatbotPage.NewMessageCheck(Response2Text, msgnum2);
        chatbotPage.NewMessageCheck(Response3Text, msgnum3);
        chatbotPage.NewMessageCheck(Response4Text, msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        Thread.sleep(15000);
        chatbotPage.SendMessage("Hola");

        chatbotPage.NewMessageCheck(Response6Text, msgnum6);
        chatbotPage.NewMessageCheck(Response7Text, msgnum7);


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

        String textResponse1op1 = "¡Vaya! Así que algo no va bien...\n" +
                "¿Con qué está relacionado tu problema?";
        String textResponse1op2 = "Esto no puede quedar sin resolver.\n" +
                "¿Con qué está relacionado tu problema?";
        String textResponse2op1 = "Creo que para esta gestión vendría bien la intervencion de un humano. ¿Quieres que se haga cargo del tema lo antes posible?";
        String textResponse2op2 = "Para este asunto podemos contar con un humano. ¿Quieres que se haga cargo de tu consulta?";
        String textResponse3 = "Chatear con un humano";
        String textResponse4 = "En otro momento";

        startTest("Reclamaciones", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(15000);

        int msgnum1op1 = chatbotPage.GetNumOfOldMsgs(textResponse1op1);
        int msgnum1op2 = chatbotPage.GetNumOfOldMsgs(textResponse1op2);
        int msgnum2op1 = chatbotPage.GetNumOfOldMsgs(textResponse2op1);
        int msgnum2op2 = chatbotPage.GetNumOfOldMsgs(textResponse2op2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(textResponse3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(textResponse4);


        chatbotPage.SendMessage("Quiero que me devolváis el dinero que me habeis cobrado de más");

        chatbotPage.CheckNewRealtiveMsg(textResponse1op1,textResponse1op2, msgnum1op1, msgnum1op2);
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        WebElement OtroAsunto = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Otro asunto')]"));
        OtroAsunto.click();

        chatbotPage.CheckNewRealtiveMsg(textResponse2op1,textResponse2op2,msgnum2op1,msgnum2op2);

        chatbotPage.NewMessageCheck(textResponse3,msgnum3);
        chatbotPage.NewMessageCheck(textResponse4,msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

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

        startTest("SimNueva", "Client: "+userName+"/"+password);

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

        startTest("SimDuplicada", "Client: "+userName+"/"+password);

        String textResponse1 = "Si necesitas un duplicado o cambio de tu SIM, lo más rápido es ir a una tienda Vodafone para que te activen la nueva y desactiven la antigua. ";
        String textResponse2 = "Localiza tu tienda más cercana";
        String textResponse3 = " y pide tu cita.";
        String textResponse4 = "También puedes solicitarlo ";
        String textResponse5 = "llamando al 22123";
        String textResponse6 = ", este proceso de activación tardará unas 72h. Te recomiendo consultar antes las ";
        String textResponse7 = "condiciones para pedir un duplicado";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password, pathToEvidence+"\\1User.png");
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
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(textResponse7);

        chatbotPage.SendMessage("Necesito un duplicado de mi tarjeta");

        chatbotPage.NewMessageCheck(textResponse1,msgnum1);
        chatbotPage.NewMessageCheck(textResponse2,msgnum2);
        chatbotPage.NewMessageCheck(textResponse3,msgnum3);
        chatbotPage.NewMessageCheck(textResponse4,msgnum4);
        chatbotPage.NewMessageCheck(textResponse5,msgnum5);
        chatbotPage.NewMessageCheck(textResponse6,msgnum6);
        chatbotPage.NewMessageCheck(textResponse7,msgnum7);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

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

        startTest("BajaInternet", "Client: "+userName+"/"+password);

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


        String response1 = "Vale, puedes ";
        String response2 = "ir a la sección Mis Pedidos";
        String response3 = " para hacer el seguimiento y consultar los detalles como el número o la dirección.";
        String response4 = "Y si te surgen más dudas, te recomiendo ";
        String response5 = "consultar las preguntas frecuentes";
        String response6 = ",en las que encontrarás información relacionada con los pedidos.";

        startTest("ConsultaPedidos", "Client: "+userName+"/"+password);

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
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);

        chatbotPage.SendMessage("Tengo algún pedido");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

    }
    @DataProvider(name="ConsultaPedidos")
    public Object[][] CredentialsConsultaPedidos()
    {
        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(43);
        return loginData;
    }

}