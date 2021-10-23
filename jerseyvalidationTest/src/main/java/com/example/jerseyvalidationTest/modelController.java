package com.example.jerseyvalidationTest;



import org.apache.commons.httpclient.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;



@Path("Modeltest")
public class modelController {


	@Path("test")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(String datapost,@Context HttpServletRequest httpRequest) {
		
		JSONObject response = new JSONObject();
		
		
		boolean result =     isJSONValid(datapost);
		
		if(result==true) {
			
			
			JSONObject tojson = new JSONObject(datapost);
			
			if(tojson.isEmpty()) {
				response.put("message", "Post data field  is empty");
				return Response.status(HttpStatus.SC_BAD_REQUEST).entity(response.toString()).build();
			}
			
			String name = tojson.getString("name");
			if(name.isEmpty()) {
				response.put("message", "Name can not be empty");
				return Response.status(HttpStatus.SC_BAD_REQUEST).entity(response.toString()).build();	
				
			}
			
			
			
			String id = String.valueOf(tojson.getInt("id"));
			
			if(id.isEmpty()) {
				
				response.put("message", "ID can not be empty");
				return Response.status(HttpStatus.SC_BAD_REQUEST).entity(response.toString()).build();		
				
			}
			
			if(name.contains("Eus")) {
				response.put("message", "Goes On Right Format");
				
			}else {
				response.put("message", "Name Format Should be like Eus with first Character");
				return Response.status(HttpStatus.SC_BAD_REQUEST).entity(response.toString()).build();	
			}
			
//			
//			JSONArray array = new JSONArray("Employee");
//			
//			
//			for(int i=0;i<array.length();i++) {
//				 array.get(i);
//				 System.out.println("list "+i+" "+ array[i]);
//			}
			
			response.put("message", "success response....!!!!");
			
			
			
			
		}else {
			response.put("message", "JSON Format Not valid");
			return Response.status(HttpStatus.SC_EXPECTATION_FAILED).entity(response.toString()).build();
		}
		
		
		
		
		
		
		
		return Response.status(HttpStatus.SC_OK).entity(response.toString()).build();
		
		
	}
	
	public boolean isJSONValid(String test) {

	    try {

	        new JSONObject(test);

	    } catch (JSONException ex) {

	        

	        try {

	            new JSONArray(test);

	        } catch (JSONException ex1) {

	            return false;

	        }

	    }

	    return true;

	}
	
	
}
