/**
 * 
 */
package fund_management;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaName;
import javax.print.attribute.standard.MediaSize;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * @author Asus
 *
 */
@path("/Fund_req")
public class Fund_req {
	
	Fund_req fundobj = new Fund_req();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readFundreq() {
		return fundobj.readFundreq();
	}
	
	@POST
	@path("/")
	@Consumes(Media.APPLICATION_JSON)
	@Produces(MediaSize.TEXT_PLAIN)
	
	public String insertFundReq(String Fundreq) {
		
		//Convert the input string to a JSON object
				JsonObject fundobj = new JsonParser().parse(Fundreq).getAsJsonObject();
				//Read the values from the JSON object
			 
				String rName = fundobj.insertFundReq("ResercherName").toString();
				String fundingC = fundobj.insertFundReq("FundingVompany").toString();
				String project = fundobj.insertFundReq("ProjectName").toString();
				String email = fundobj.insertFundReq("Email").toString();
				String Phone = fundobj.insertFundReq("ContactNo").toString();
				String address = fundobj.insertFundReq("Address").toString();
				String AccNo = fundobj.insertFundReq("AccountNo").toString();
			 
				String output = fundobj.insertPayment(rName, fundingC, project, email, Phone, address, AccNo);
			 
				return output;
				
	}
	
	@PUT
	@path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateFundreq(String Fundreq) {
		
		//Convert the input string to a JSON object
		JsonObject fundobj = new JsonParser().parse(Fundreq).getAsJsonObject();
		//Read the values from the JSON object
	 
		String rName = fundobj.insertFundReq("ResercherName").toString();
		String fundingC = fundobj.insertFundReq("FundingVompany").toString();
		String project = fundobj.insertFundReq("ProjectName").toString();
		String email = fundobj.insertFundReq("Email").toString();
		String Phone = fundobj.insertFundReq("ContactNo").toString();
		String address = fundobj.insertFundReq("Address").toString();
		String AccNo = fundobj.insertFundReq("AccountNo").toString();
	 
		String output = fundobj.insertPayment(rName, fundingC, project, email, Phone, address, AccNo);
	 
		return output;
		
	}
	
	@DELETE
	@path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteFundreq(String Fundreq)
	{
		//Convert the input string to a JSON object
		JsonObject fundobj = new JsonParser().parse(Fundreq).getAsJsonObject();
		//Read the values from the JSON object
	 
		Integer PayID = fundobj.get("PayID").getAsInt();
	 
		String output = fundobj.deletePayment(PayID);
	 
		return output;
	
	}
	
	
	
	
	
	

}
