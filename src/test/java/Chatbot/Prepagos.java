package Chatbot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.Pages.ChatbotPage;

import org.openqa.selenium.*;

import static Chatbot.ExtentReport.ExtentTestManager.startTest;

public class Prepagos extends BaseTest {


    @Test(dataProvider = "CambioTarifaM")
    public void CambioTarifaM(String userName, String password, String pathToEvidence) throws InterruptedException {

        startTest("CambioTarifaM", "Client: "+userName+"/"+password);

        String response0 = "¿En qué te puedo ayudar con tu tarifa?";
        String response1 = "Tarifa actual";
        String response2 = "Vodafone Prepago M";
        String response3 = "¿Te gustaría cambiar a otro tipo de tarifas prepago, como las YU o VF Fácil? Elige una y te explico:";
        String response4 = "En nuestra web tienes los detalles de las ";
        String response5 = "tarifas YU";
        String response6 = " para que elijas la que mejor encaja contigo.";
        String response7 = "Para hacer el cambio, marca en tu móvil el código #USSD y sigue las instrucciones del menú:";
        String response8 = "525# + tecla de llamada";
        String response9 = "Te recuerdo que puedes hacer hasta 6 cambios de tarifa gratuitamente. ¡Disfruta de tu nueva tarifa!";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password, pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum0 = chatbotPage.GetNumOfOldMsgs(response0);
        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);
        int msgnum7 = chatbotPage.GetNumOfOldMsgs(response7);
        int msgnum8 = chatbotPage.GetNumOfOldMsgs(response8);
        int msgnum9 = chatbotPage.GetNumOfOldMsgs(response9);


        chatbotPage.SendMessage("Necesito cambiar mi tarifa");
        takeScreenShot(pathToEvidence+"\\Screenshot.png");

        chatbotPage.NewMessageCheck(response0,msgnum0);
        WebElement info_tarifa = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Cambiar de tarifa')]"));
        info_tarifa.click();
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        WebElement SeeMore = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Sí, Vodafone YU')]"));
        SeeMore.click();

        chatbotPage.NewMessageCheck(response4,msgnum4);
        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);
        chatbotPage.NewMessageCheck(response7,msgnum7);
        chatbotPage.NewMessageCheck(response8,msgnum8);
        chatbotPage.NewMessageCheck(response9,msgnum9);

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "CambioTarifaM")
    public Object[][] credentials_CambioTarifaM() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(18);
        return loginData;

    }



    @Test(dataProvider = "CambioTarifaMega")
    public void CambioTarifaMega(String userName, String password, String pathToEvidence) throws InterruptedException{


        startTest("CambioTarifaMega", "Client: "+userName+"/"+password);

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum = chatbotPage.GetNumOfOldMsgs("¿En qué te puedo ayudar con tu tarifa?");
        int msgnum1 = chatbotPage.GetNumOfOldMsgs("Tienes varios móviles con nosotros. Elige uno de la lista y vemos juntos la tarifa que tiene.");
        int msgnum2 = chatbotPage.GetNumOfOldMsgs("Megayuser");
        int msgnum3= chatbotPage.GetNumOfOldMsgs("¿Te gustaría cambiar a otro tipo de tarifas prepago, como las S, M, L, XL o Vodafone Fácil?");
        int msgnum4 = chatbotPage.GetNumOfOldMsgs("tarifas prepago");
        int msgnum5 = chatbotPage.GetNumOfOldMsgs("Si quieres cambiar a otra tarifa, marca en el móvil el código #USSD y sigue las instrucciones: ");
        int msgnum6 = chatbotPage.GetNumOfOldMsgs("Te recuerdo que puedes hacer hasta 6 cambios de tarifa gratuitamente. ¡Disfruta de tu nueva tarifa!");


        chatbotPage.SendMessage("Necesito cambiar mi tarifa");

        chatbotPage.NewMessageCheck("¿En qué te puedo ayudar con tu tarifa?", msgnum);

        WebElement CambioTarifa = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Cambiar de tarifa')]"));
        CambioTarifa.click();
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck("Tienes varios móviles con nosotros. Elige uno de la lista y vemos juntos la tarifa que tiene.",msgnum1);

        WebElement MSISDN = waitForElementToBeVisible(By.xpath("//button[contains(@title,'617954521')]"));
        MSISDN.click();

        Thread.sleep(5000);
        chatbotPage.NewMessageCheck("Megayuser", msgnum2);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        chatbotPage.NewMessageCheck("¿Te gustaría cambiar a otro tipo de tarifas prepago, como las S, M, L, XL o Vodafone Fácil?",msgnum3);

        WebElement OtrasTarifas = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Sí, ver otras tarifas prepago')]"));
        OtrasTarifas.click();

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

        Thread.sleep(5000);
        chatbotPage.NewMessageCheck("tarifas prepago", msgnum4);
        chatbotPage.NewMessageCheck("Si quieres cambiar a otra tarifa, marca en el móvil el código #USSD y sigue las instrucciones: ",msgnum5);
        chatbotPage.NewMessageCheck("Te recuerdo que puedes hacer hasta 6 cambios de tarifa gratuitamente. ¡Disfruta de tu nueva tarifa!",msgnum6);

        takeScreenShot(pathToEvidence+"\\Screenshot4.png");

        chatbotPage.EndConv();


    }
    @DataProvider(name = "CambioTarifaMega")
    public Object[][] credentials_CambioTarifaMega() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(16);

        return loginData;

    }



    @Test(dataProvider = "Info_SVAs_PREPAGOS")
    public void Info_SVAs_PREPAGOS(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("Info_SVAs_PREPAGOS", "Client: "+userName+"/"+password);

        String response1 = "Te explico; puedes gestionar el contestador de tu móvil desde la sección ";
        String response2 = "Opciones de llamada";
        String response3 = ", eligiendo la línea en la que quieres hacer el cambio.";
        String response4 = "No tiene ningún coste para ti, pero sí para la persona que te deja un mensaje de voz.";
        String response5 = "Además, puedes escuchar los mensajes del contestador marcando el ";
        String response6 = "22177";
        String response7 = ". Y si quieres más información o saber, por ejemplo, cómo cambiar el idioma te recomiendo pasar por las ";
        String response8 = "consultas frecuentes";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 User.png");
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

        chatbotPage.SendMessage("Necesito activar el contestador");

        chatbotPage.NewMessageCheck(response1,msgnum1);
        chatbotPage.NewMessageCheck(response2,msgnum2);
        chatbotPage.NewMessageCheck(response3,msgnum3);
        chatbotPage.NewMessageCheck(response4,msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot1.png");

        chatbotPage.NewMessageCheck(response5,msgnum5);
        chatbotPage.NewMessageCheck(response6,msgnum6);
        chatbotPage.NewMessageCheck(response7,msgnum7);
        chatbotPage.NewMessageCheck(response8,msgnum8);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");

        WebElement siHecho = waitForElementToBeVisible(By.xpath("//button[@title=\"Sí, ¡hecho!\"]"));
        siHecho.click();

        chatbotPage.EndConv();

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");


    }
    @DataProvider(name = "Info_SVAs_PREPAGOS")
    public Object[][] credentials_Info_SVAs_PREPAGOS() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(17);

        return loginData;

    }



    @Test(dataProvider = "InfoTarifaPREPAGO")
    public void InfoTarifaPREPAGO(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("InfoTarifaPREPAGO", "Client: "+userName+"/"+password);

        String response = "¿En qué te puedo ayudar con tu tarifa?";
        String response0 = "Tienes varios móviles con nosotros. Elige uno de la lista y vemos juntos la tarifa que tiene.";
        String response1 = "Aquí tienes la información de tu tarjeta con los beneficios que tienes activos ";
        String response2 = "Megayuser";
        String response3 = "En este enlace a la App  podrás ver más información sobre tu tarifa: ";
        String response4 = "detalles de mi tarifa";
        String response5 = "Y si quieres compararla con otras tarifas y sus beneficios, puedes hacerlo en esta página: ";
        String response6 = "Encuentra la mejor tarifa prepago";


        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password,pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);

        int msgnum  = chatbotPage.GetNumOfOldMsgs(response);
        int msgnum0 = chatbotPage.GetNumOfOldMsgs(response0);
        int msgnum1 = chatbotPage.GetNumOfOldMsgs(response1);
        int msgnum2 = chatbotPage.GetNumOfOldMsgs(response2);
        int msgnum3 = chatbotPage.GetNumOfOldMsgs(response3);
        int msgnum4 = chatbotPage.GetNumOfOldMsgs(response4);
        int msgnum5 = chatbotPage.GetNumOfOldMsgs(response5);
        int msgnum6 = chatbotPage.GetNumOfOldMsgs(response6);

        chatbotPage.SendMessage("Necesito informacion sobre mi tarifa");
        takeScreenShot(pathToEvidence+"\\Screenshot.png");
        chatbotPage.NewMessageCheck(response,msgnum);
        WebElement info_tarifa = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Ver mi tarifa')]"));
        info_tarifa.click();
        chatbotPage.NewMessageCheck(response0,msgnum0);
        WebElement MSISDN = waitForElementToBeVisible(By.xpath("//button[contains(@title,'617954521')]"));
        MSISDN.click();
        takeScreenShot(pathToEvidence+"\\Screenshot1.png");
        chatbotPage.NewMessageCheck(response1, msgnum1);
        chatbotPage.NewMessageCheck(response2, msgnum2);

        takeScreenShot(pathToEvidence+"\\Screenshot2.png");
        WebElement SeeMore = waitForElementToBeVisible(By.xpath("//button[contains(@title,'Sí, ¿qué más tienes?')]"));
        SeeMore.click();

        chatbotPage.NewMessageCheck(response3, msgnum3);
        chatbotPage.NewMessageCheck(response4, msgnum4);

        takeScreenShot(pathToEvidence+"\\Screenshot3.png");

        chatbotPage.NewMessageCheck(response5, msgnum5);
        chatbotPage.NewMessageCheck(response6, msgnum6);

        chatbotPage.EndConv();
        takeScreenShot(pathToEvidence+"\\Screenshot4.png");
    }
    @DataProvider(name = "InfoTarifaPREPAGO")
    public Object[][] credentials_InfoTarifaPREPAGO() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(15);

        return loginData;

    }



    @Test(dataProvider = "PrepagoQTC")
    public void PrepagoQTC(String userName, String password, String pathToEvidence) throws InterruptedException{

        startTest("PrepagoQTC", "Client: "+userName+"/"+password);

        String response1 = "Vale, te dejo un enlace donde puedes revisarlos: ";

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        chatbotPage.Login(userName,password, pathToEvidence+"\\1 User.png");
        chatbotPage.CloseErrorBanner();
        chatbotPage.OpenChatPartis();
        chatbotPage.SwichIFrame();
        chatbotPage.SendMessage("Hola");
        Thread.sleep(5000);
        int msgnum = chatbotPage.GetNumOfOldMsgs(response1);
        chatbotPage.SendMessage("Qué tengo contratado?");

        chatbotPage.NewMessageCheck(response1, msgnum);
        takeScreenShot(pathToEvidence+"\\Screenshot.png");

        chatbotPage.EndConv();

    }
    @DataProvider(name = "PrepagoQTC")
    public Object[][] credentials_PrepagoQTC() {

        ChatbotPage chatbotPage = new ChatbotPage(driver);
        Object[][] loginData = chatbotPage.getCredentialsData(20);

        return loginData;

    }

}



