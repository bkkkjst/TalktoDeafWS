package TalktoDeaf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/callservice")
public interface TalktoDeafInterface {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//return กลับมาเป็นแบบไหน
	@Path("/getCategory")
	public String getCategory() throws Exception;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//return กลับมาเป็นแบบไหน
	@Path("/getCategoryName")
	public String getCategoryName() throws Exception;

}
