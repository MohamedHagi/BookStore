package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Model.Model;

@Path("/book")
public class Book {

	@GET
	@Path("/read/")
	@Produces("text/plain")
	public String getBookInfo(@QueryParam("bid") int bid) throws Exception{
		String result = Model.getInstance().getXMLforRest(bid);
		return result;
	}
	
	
	@GET
	@Path("/purchase/")
	@Produces("text/plain")
	public String getPurchaseInfo(@QueryParam("poid") int poid) {
		String result = "";
		try {
			result = Model.getInstance().getXMLForRestForPurchaseOrder(poid);
		} catch (ClassNotFoundException e) {
			result = "An error occurred";
		}catch(NullPointerException e) {
			result = "Sorry, value not found";
		}
		return result;
	}
}
