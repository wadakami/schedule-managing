package facebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.MediaAttachment;
import com.restfb.types.send.Message;
import com.restfb.types.send.SendResponse;
import com.restfb.types.webhook.WebhookEntry;
import com.restfb.types.webhook.WebhookObject;
import com.restfb.types.webhook.messaging.MessagingItem;

/**
 * Servlet implementation class WebhookServlet
 */
public class WebhookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WebhookServlet() {
        super();
    }
    //FB access token
    private String accessToken = "EAAgwhKk2kyMBAKsXTZBY0HoFTIdfkFxTPNvRDp6OgpQONgWd7VAHbEi4DLqFlfrZBNZCcRT0Fgdytg2Dg8Mt6JbFfiTAAIvZCthMh87oVljvxfXhtVHq7vVSiDLGfDZCRaDhgwt61U4T4NZCdrgNQQwH6qeluiZAa736RqYg95lAx6qHpQhuXMj";

    //URL verification
    private String verifyToken = "bot123";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String hubToken = request.getParameter("hub.verify_token");
	    String hubChallenge = request.getParameter("hub.challenge");

	    if(verifyToken.equals(hubToken)){
	        response.getWriter().write(hubChallenge);
            response.getWriter().flush();
            response.getWriter().close();
	    }else{
	        response.getWriter().write("incorrect token");
	    }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    final String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        //Convert java string to java object
	    JsonMapper mapper = new DefaultJsonMapper();
	    WebhookObject webhookObj = mapper.toJavaObject(body, WebhookObject.class);


	    message:
	        for(WebhookEntry entry: webhookObj.getEntryList()){
	        if(entry.getMessaging()!= null){
	            for(MessagingItem mItem : entry.getMessaging()){

	                String senderId = mItem.getSender().getId();
	                IdMessageRecipient recipent = new IdMessageRecipient(senderId);

	                //Receive text message
	                if(mItem.getMessage() != null && mItem.getMessage().getText() != null) {


	                    if(mItem.getMessage().getText().equals("test")) {

                            SendMessage(recipent, new Message("It's under construction."));

	                    } else if(mItem.getMessage().getText().equals("image")) {

	                        MediaAttachment image = new MediaAttachment(MediaAttachment.Type.IMAGE, "https://www.homepage-tukurikata.com/image/lion.jpg");
                            Message imageMessage = new Message(image);
                            SendMessage(recipent, imageMessage);

	                    } else if(mItem.getMessage().getText().equals("snap")) {

	                            MediaAttachment snap = new MediaAttachment(MediaAttachment.Type.IMAGE, "http://api.screenshotlayer.com/api/capture?access_key=44aa4cc18a537b97fe3f94d781996cbf&url=https://schedule-managing.herokuapp.com/secret/index&fullpage=1");

	                            System.out.println("before make new message");
	                            Message snapMessage = new Message(snap);

	                            System.out.println("before send message");
	                            SendMessage(recipent, snapMessage);

	                            System.out.println("before break");
	                            break message;

	                    }

	                }

	            }
	        }
	    }
	}
	//Go to Restfb Documentation
	void SendMessage(IdMessageRecipient recipient, Message message) {
	 // create a version 2.6 client

	    FacebookClient pageClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_12);
        System.out.println("before send response");

        try {
	    SendResponse resp = pageClient.publish("me/messages", SendResponse.class,
	         Parameter.with("recipient", recipient), // the id or phone recipient
	         Parameter.with("message", message)); // one of the messages from above
        System.out.println(resp);
        } catch(FacebookOAuthException e) {
            System.out.println(e);
        }
        System.out.println("after send response");

	}

}
