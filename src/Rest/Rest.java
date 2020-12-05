package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Model.Model;

@Path("book")
public class Rest {

	@GET
	@Path("/read/")
	@Produces("text/plain")
	public String getBookInfo(@QueryParam("bid") int bid) throws Exception{
		String result = Model.getInstance().getXMLforRest(bid);
		return result;
	}
}
