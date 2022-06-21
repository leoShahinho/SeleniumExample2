package SetupsAndPages.Pages;

import SetupsAndPages.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ChatbotPage extends BasePage {

    public String dataFile = System.getProperty("user.dir")+"\\Treceability and data.xlsx";;

    public ChatbotPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='ManualLoginComp_txt_username']")
    WebElement username;
    @FindBy(xpath = "//input[@id=\"ManualLoginComp_txt_password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"ManualLoginComp_btn_submitLogin\"]")
    WebElement submitBotton;
    @FindBy(xpath = "//img[@class=\"bubble-tray__icon\"]")
    WebElement chatBubble;
    @FindBy(xpath = "//button[@class=\"footer-content ng-star-inserted\"]")
    WebElement chatWindow;
    @FindBy(xpath = "//span[contains(.,\"Chatea con tu asesor\")]")
    WebElement chatWindowME;
    @FindBy(xpath = "//textarea[@name='reply-box']")
    WebElement replyBox;
    @FindBy(xpath = "//button[@class=\"ReplyBox_IconButton__3nhR7\"]")
    WebElement sendButton;
    @FindBy(xpath = "//button[@title=\"Sí, has resuelto mi consulta\"]")
    WebElement End_Conv_Button;
    @FindBy(xpath = "//button[@id=\"btn_retryClick\"]")
    WebElement closeErrorBanner;
    @FindBy(xpath = "//button[@id=\"btn_primaryClick\"]")
    WebElement closeErrorBanner2;
    @FindBy(xpath = "//a[@title=\"Conoce tus productos\"]")
    WebElement conoceTusProductos;


    public void Login(String user, String pass, String path) {
        waitForElementToBeVisible_WebElement(username);
        username.sendKeys(user);
        waitForElementToBeVisible_WebElement(password);
        password.sendKeys(pass);
        takeScreenShot(path);
        waitForElementToBeVisible_WebElement(submitBotton);
        submitBotton.click();
        Assert.assertTrue(waitForElementToBeVisible_WebElement(chatBubble).isDisplayed());
        System.out.println(user+" logged in successfully");

    }

    public Object[][] getCredentialsData( int testCaseRow){

        ExcelDataConfig excel = new ExcelDataConfig(dataFile);
        Object[][] data = new Object[1][3];
        data[0][0] = excel.getData("LoginCredentialsSit2",testCaseRow,1);
        data[0][1] = excel.getData("LoginCredentialsSit2",testCaseRow,3);
        data[0][2] = excel.getData("screenshotLocations",testCaseRow,2);
        return data;

    }

    public void CloseErrorBanner() throws InterruptedException {


        Thread.sleep(5000);
        int count = driver.findElements(By.xpath("//button[@id=\"btn_retryClick\"]")).size();
        if (count > 0)
        {
            closeErrorBanner.click();
            Thread.sleep(1000);
            submitBotton.click();
            count=0;
            Thread.sleep(5000);
            count = driver.findElements(By.xpath("//div[contains(text(),'Error')]")).size();
            System.out.println(count);
        }

       int count1 = driver.findElements(By.xpath("//button[@id=\"btn_primaryClick\"]")).size();
        if (count1 > 0)
        {
            closeErrorBanner2.click();
            Thread.sleep(1000);
            submitBotton.click();
            count1=0;
            Thread.sleep(5000);
            count1 = driver.findElements(By.xpath("//div[contains(text(),'Error')]")).size();
            System.out.println(count1);
        }
    }
    
    public void ME_Error() throws Exception {
    	Thread.sleep(15000);
    	int count = driver.findElements(By.xpath("//div[contains(text(),'Error')]")).size();
    	if (count>0)
    		closeErrorBanner2.click();
	}

    public void OpenChatPartis() {

        waitForElementToBeVisible_WebElement(chatBubble);
        chatBubble.click();
        waitForElementToBeVisible_WebElement(chatWindow);
        chatWindow.click();

    }

    public void OpenChatME() {

        waitForElementToBeVisible_WebElement(chatBubble);
        chatBubble.click();
        waitForElementToBeVisible_WebElement(chatWindowME);
        chatWindowME.click();

    }

    public void SwichIFrame() throws InterruptedException{

        WebElement chat_iframe = waitForElementToBeVisible(By.xpath("//*[@id=\"Iframe\"]"));
        String chatURL = chat_iframe.getAttribute("src");
        driver.get(chatURL);
        WebElement liveChat = waitForElementToBeVisible(By.tagName("iframe"));
        driver.switchTo().frame(liveChat);
        Thread.sleep(20000);
        waitForElementToBeVisible_WebElement(conoceTusProductos);
        System.out.println("Chat is opened successfully");

    }

    public void SendMessage(String text) throws InterruptedException{

        try{
        waitForElementToBeVisible_WebElement(replyBox);
        replyBox.sendKeys(text);
        waitForElementToBeVisible_WebElement(sendButton);
        sendButton.click();
        Thread.sleep(1000);}
        catch (ElementNotInteractableException ex){}

    }

    public boolean NewMessageCheck(String agentMsg , int msgnum) throws InterruptedException{

    	WebElement AgentMsg = waitForElementToBeVisible(By.xpath("(//*[text()='"+agentMsg+"'])["+(msgnum+1)+"]"));

    	if (AgentMsg!=null){
    	System.out.println(AgentMsg.getText());}

        return true;
    }
    
    public int GetNumOfOldMsgs(String agentMsg) {
		int size = driver.findElements(By.xpath("//*[text()='"+agentMsg+"']")).size();
    	return size;
	}

	public void CheckNewRealtiveMsg(String msgOption1, String msgOption2, int msgnumOp1, int msgnumOp2) throws InterruptedException {

        Thread.sleep(10000);
        if (driver.findElements(By.xpath("(//*[text()='"+msgOption1+"'])["+(msgnumOp1+1)+"]")).size()<0){
            NewMessageCheck(msgOption1,msgnumOp1);
            System.out.println("Relative msg is firstOption");
         }
        else if(driver.findElements(By.xpath("(//*[text()='"+msgOption2+"'])["+(msgnumOp2+1)+"]")).size()<0){
            NewMessageCheck(msgOption2,msgnumOp2);
            System.out.println("Relative msg is SecondOption");
        }
    }

    public void skipLastConversationInquery() throws InterruptedException {

        Thread.sleep(25000);
        if (driver.findElements(By.xpath("//button[@title='Sí, quiero preguntarte otra cosa']")).size()>0)
        {
            driver.findElement(By.xpath("//button[@title='Sí, quiero preguntarte otra cosa']")).click();
            System.out.println("Last conversation inquery skipped");
        }
        else if (driver.findElements(By.xpath("//button[@title='No, otra consulta']")).size()>0)
        {
            driver.findElement(By.xpath("//button[@title='No, otra consulta']")).click();
            System.out.println("Last conversation inquery skipped");

        }
        else
            System.out.println("No last conversation inquery from chatBot");
    }

    public void EndConv(){

        waitForElementToBeVisible_WebElement(End_Conv_Button);
        End_Conv_Button.click();
    }

}