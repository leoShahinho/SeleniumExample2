package Chatbot;

import org.testng.annotations.Test;

import SetupsAndPages.BaseTest;
import SetupsAndPages.ChatbotPage;

import org.testng.Assert;
import org.openqa.selenium.*;

public class Retired extends BaseTest {
	//need to edit
	 @Test//TC2
	    public void Calls() throws InterruptedException {

	        ChatbotPage chatbotPage = new ChatbotPage(driver);
	        chatbotPage.Login("39408729T@nuevomivf.es","Prueba2468", ".\\Screenshots\\CallsOOB\\1 User.png");
	        chatbotPage.CloseErrorBanner();
	        chatbotPage.OpenChatPartis();
	        chatbotPage.SwichIFrame();
	        chatbotPage.SendMessage("Hola");
	        Thread.sleep(10000);
		    int msgnum = chatbotPage.GetNumOfOldMsgs("Para el 697817541 tienes una tarifa ilimitada de llamadas a fijos y móviles nacionales.");
		    int msgnum2 = chatbotPage.GetNumOfOldMsgs("Bono internacional Europa,");

		    chatbotPage.SendMessage("Qué consumo de llamadas tengo?");


		    chatbotPage.NewMessageCheck("Para el 697817541 tienes una tarifa ilimitada de llamadas a fijos y móviles nacionales.", msgnum);

	        WebElement ConsultarBono = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Consultar bono')])[last()]"));
	        ConsultarBono.click();
	        Thread.sleep(10000);

	        chatbotPage.NewMessageCheck("Bono internacional Europa", msgnum2);


	        takeScreenShot(".\\Screenshots\\CallsOOB\\Screenshot.png");

	        int msgnum3 = chatbotPage.GetNumOfOldMsgs("Desde el 01/3/2022 tienes un consumo de 7,48 € en llamadas fuera de tu tarifa.");

		    WebElement VerGastoExtra = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Ver gasto extra')])[last()]"));
	        VerGastoExtra.click();
	        Thread.sleep(10000);

	        chatbotPage.NewMessageCheck("Desde el 01/2/2022 tienes un consumo de 7,48 € en llamadas fuera de tu tarifa.", msgnum3);

	        takeScreenShot(".\\Screenshots\\CallsOOB\\Screenshot2.png");

	        chatbotPage.EndConv();

	    }

	    @Test//TC3
	    public void Fixed_Cons() throws InterruptedException{

	        ChatbotPage chatbotPage = new ChatbotPage(driver);
	        chatbotPage.Login("27762187Z@nuevomivf.es","Prueba2468", ".\\Screenshots\\Fixed consumption\\1 User.png");
	        chatbotPage.CloseErrorBanner();
	        chatbotPage.OpenChatPartis();
	        chatbotPage.SwichIFrame();
	        chatbotPage.SendMessage("Hola");
	        Thread.sleep(10000);
	        chatbotPage.SendMessage("Qué consumo de fijo tengo?");

	        int msgnum = chatbotPage.GetNumOfOldMsgs("consumo extra de llamadas de 2,84 €");
	        chatbotPage.NewMessageCheck("consumo extra de llamadas de 2,84 €", msgnum);

	        takeScreenShot(".\\Screenshots\\Fixed consumption\\Screenshot2.png");
	    }

	    @Test//TC1
	    public void SMS_Cons() throws InterruptedException {

	        ChatbotPage chatbotPage = new ChatbotPage(driver);
	        chatbotPage.Login("05142306N@nuevomivf.es","Prueba2468", ".\\Screenshots\\SMS Consumption\\1 User.png");
	        chatbotPage.CloseErrorBanner();
	        chatbotPage.OpenChatPartis();
	        chatbotPage.SwichIFrame();
	        chatbotPage.SendMessage("Hola");
	        Thread.sleep(10000);
	        chatbotPage.SendMessage("Qué consumo de Mensajes tengo?");

	        int msgnum = chatbotPage.GetNumOfOldMsgs("el consumo de mensajes del 690954061 es de 1,8€.");
	        chatbotPage.NewMessageCheck("el consumo de mensajes del 690954061 es de 1,8€ €.", msgnum);

	        takeScreenShot(".\\Screenshots\\SMS Consumption\\Screenshot2.png");

	        chatbotPage.EndConv();
	    }

	    @Test//TC4 [Issue]
	    public void TV_Cons() throws InterruptedException{

	        ChatbotPage chatbotPage = new ChatbotPage(driver);
	        chatbotPage.Login("03446858D@nuevomivf.es","Prueba2468", ".\\Screenshots\\TvOOB\\1 User.png");
	        chatbotPage.CloseErrorBanner();
	        chatbotPage.OpenChatPartis();
	        chatbotPage.SwichIFrame();
	        chatbotPage.SendMessage("Hola");
	        Thread.sleep(10000);
			int msgnum = chatbotPage.GetNumOfOldMsgs("Veo que tienes Serielovers Legacy, Documentales, Peques y Universal Clásico .");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("Además, has contratado películas fuera de los packs.");
			int msgnum3 = chatbotPage.GetNumOfOldMsgs("Por ahora no puedo enseñarte ese detalle. Inténtalo de nuevo próximamente.");

			chatbotPage.SendMessage("Quiero saber si tengo consumo de películas en la televisión");
	        chatbotPage.NewMessageCheck("Veo que tienes Serielovers Legacy, Documentales, Peques y Universal Clásico .", msgnum);
	        chatbotPage.NewMessageCheck("Además, has contratado películas fuera de los packs.", msgnum2);

	        WebElement VerDetalle = waitForElementToBeVisible(By.xpath("(//button[contains(@title,'Ver detalle')])[last()]"));
	        takeScreenShot(".\\Screenshots\\TvOOB\\Screenshot.png");

			VerDetalle.click();
	        chatbotPage.NewMessageCheck("Por ahora no puedo enseñarte ese detalle. Inténtalo de nuevo próximamente.", msgnum3);

	        takeScreenShot(".\\Screenshots\\TvOOB\\Screenshot2.png");
	    }

		@Test//TC10
		public void ImporteFac() throws InterruptedException{

			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("Y0259413X@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\ImporteFac\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			chatbotPage.SendMessage("Quiero saber el importe de mi factura de noviembre");

			int msgnum = chatbotPage.GetNumOfOldMsgs("Factura noviembre");
			chatbotPage.NewMessageCheck("Factura noviembre", msgnum);


			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\ImporteFac\\Screenshot1.png");

			chatbotPage.EndConv();

		}

		@Test
		public void FacElectro() throws InterruptedException{

			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("35879775M@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacElectro\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			int msgnum1 = chatbotPage.GetNumOfOldMsgs("estás recibiendo las facturas en papel");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("¡Genial! Ya lo he cambiado. La próxima\n" + "factura la recibirás en formato\n" + "electrónico.");
			int msgnum3 = chatbotPage.GetNumOfOldMsgs("La factura electrónica tiene la misma validez legal que las de papel y es mejor para el medio ambiente.");
			chatbotPage.SendMessage("Quiero activar la factura electrónica");

			chatbotPage.NewMessageCheck("estás recibiendo las facturas en papel", msgnum1);

			WebElement facturaElectro = waitForElementToBeVisible(By.xpath("//button[@title=\"Cambiar a factura electrónica\"]"));
			facturaElectro.click();

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacElectro\\Screenshot1.png");


			chatbotPage.NewMessageCheck("¡Genial! Ya lo he cambiado. La próxima\n" + "factura la recibirás en formato\n" + "electrónico.", msgnum2);

			chatbotPage.NewMessageCheck("La factura electrónica tiene la misma validez legal que las de papel y es mejor para el medio ambiente.", msgnum3);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacElectro\\Screenshot2.png");

			chatbotPage.EndConv();


		}

		@Test
		public void FacPapel() throws InterruptedException{
			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("26475852T@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacPapel\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			int msgnum1 = chatbotPage.GetNumOfOldMsgs("estás recibiendo las facturas en formato electrónico");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("Ya que hablamos de facturas, igual quieres aprovechar para hacer alguna gestión:");
			int msgnum3 = chatbotPage.GetNumOfOldMsgs("La factura electrónica tiene la misma validez legal que las de papel y es mejor para el medio ambiente.");
			int msgnum4 = chatbotPage.GetNumOfOldMsgs("¡Cambiado! A partir de ahora recibirás\n" +
					"las facturas en papel en ");
			chatbotPage.SendMessage("Quiero activar la factura en papel");

			chatbotPage.NewMessageCheck("estás recibiendo las facturas en formato electrónico", msgnum1);
			chatbotPage.NewMessageCheck("Ya que hablamos de facturas, igual quieres aprovechar para hacer alguna gestión:", msgnum2);

			WebElement facturaPapel = waitForElementToBeVisible(By.xpath("//button[@title=\"Cambiar a factura en papel\"]"));
			facturaPapel.click();

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacPapel\\screenshot1.png");

			chatbotPage.NewMessageCheck("La factura electrónica tiene la misma validez legal que las de papel y es mejor para el medio ambiente.",msgnum3);

			WebElement siPorfi = waitForElementToBeVisible(By.xpath("//button[@title=\"Sí, por favor\"]"));
			siPorfi.click();

			chatbotPage.NewMessageCheck("¡Cambiado! A partir de ahora recibirás\n" + "las facturas en papel en ", msgnum4);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacPapel\\screenshot2.png");

			chatbotPage.EndConv();

		}

		@Test
		public void FacPDF () throws InterruptedException{

			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("24389051N@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacPDF\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			int msgnum1 = chatbotPage.GetNumOfOldMsgs("¿Quieres que te mandemos a esa dirección las facturas o prefieres recibirlas en otra cuenta?");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("¿Me confirmas que quieres recibir la factura en PDF en 285804942@xxxx.es todos los meses?");
			int msgnum3 = chatbotPage.GetNumOfOldMsgs("Vas a recibir un email en tu correo electrónico. Si en la bandeja de entrada no aparece, revisa la de SPAM.");
			chatbotPage.SendMessage("Quiero recibir mi factura al mail en PDF");

			chatbotPage.NewMessageCheck("¿Quieres que te mandemos a esa dirección las facturas o prefieres recibirlas en otra cuenta?", msgnum1);

			WebElement keepIt = waitForElementToBeVisible(By.xpath("//button[@title=\"Mantener el mismo\"]"));

			keepIt.click();

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacPDF\\Screenshot1.png");

			chatbotPage.NewMessageCheck("¿Me confirmas que quieres recibir la factura en PDF en 285804942@xxxx.es todos los meses?",msgnum2);

			WebElement si = waitForElementToBeVisible(By.xpath("//button[@title=\"Sí\"]"));
			si.click();

			chatbotPage.NewMessageCheck("Vas a recibir un email en tu correo electrónico. Si en la bandeja de entrada no aparece, revisa la de SPAM.", msgnum3);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacPDF\\Screenshot2.png");


		}

		@Test
		public void FacAvisoSMS() throws InterruptedException{

			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("76565951D@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacAvisoSMS\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			int msgnum1 = chatbotPage.GetNumOfOldMsgs("El único móvil que tienes con nosotros es el 622426730. ¿Quieres que te mandemos allí un SMS cuando la factura esté lista?");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("¡Ya lo tienes en marcha!");
			chatbotPage.SendMessage("Quiero recibir aviso por SMS cuando esté lista mi factura");

			chatbotPage.NewMessageCheck("El único móvil que tienes con nosotros es el 622426730. ¿Quieres que te mandemos allí un SMS cuando la factura esté lista?", msgnum1);

			WebElement altaAvisoSMS = waitForElementToBeVisible(By.xpath("//button[@title=\"Alta aviso vía SMS\"]"));
			altaAvisoSMS.click();

			chatbotPage.NewMessageCheck("¡Ya lo tienes en marcha!", msgnum2);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacAvisoSMS\\Screenshot1.png");

		}

		@Test
		public void FacAvisoMail() throws InterruptedException{

			ChatbotPage chatbotPage = new ChatbotPage(driver);
			chatbotPage.Login("42618202F@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacAvisoMail\\1 user.png");
			chatbotPage.CloseErrorBanner();
			chatbotPage.OpenChatPartis();
			chatbotPage.SwichIFrame();
			chatbotPage.SendMessage("Hola");
			Thread.sleep(15000);
			int msgnum1 = chatbotPage.GetNumOfOldMsgs("¿Quieres recibir en ese correo los mails de factura disponible?");
			int msgnum2 = chatbotPage.GetNumOfOldMsgs("¡Activado!");
			chatbotPage.SendMessage("Quiero recibir aviso por mail cuando esté lista mi factura");

			chatbotPage.NewMessageCheck("¿Quieres recibir en ese correo los mails de factura disponible?", msgnum1);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacAvisoMail\\Screenshot1.png");

			WebElement siQuiero = waitForElementToBeVisible(By.xpath("//button[@title=\"Sí quiero\"]"));
			siQuiero.click();

			chatbotPage.NewMessageCheck("¡Activado!",msgnum2);

			takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacAvisoMail\\Screenshot2.png");



		}


		@Test//TC5
		public void FacDetalle() throws InterruptedException{


		ChatbotPage chatbotPage = new ChatbotPage(driver);
		chatbotPage.Login("70519107A@nuevomivf.es", "Prueba2468", System.getProperty("user.dir")+"\\Screenshots\\FacDetalle\\1 user.png");
		chatbotPage.CloseErrorBanner();
		chatbotPage.OpenChatPartis();
		chatbotPage.SwichIFrame();
		chatbotPage.SendMessage("Hola");
		Thread.sleep(15000);
		chatbotPage.SendMessage("Quiero saber el detalle de mi factura de noviembre");

		int msgnum = chatbotPage.GetNumOfOldMsgs("Por lo que veo, el importe de la factura de noviembre es");
		chatbotPage.NewMessageCheck("Por lo que veo, el importe de la factura de noviembre es", msgnum);

		takeScreenShot(System.getProperty("user.dir")+"\\Screenshots\\FacDetalle\\Screenshot1.png");

		chatbotPage.EndConv();
	}

}

