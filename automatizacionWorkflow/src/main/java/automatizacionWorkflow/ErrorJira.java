package automatizacionWorkflow;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class ErrorJira {
static int x=1;
	public static void run(String Tipo,String error,String Clase, String Metodo) throws UnirestException {
		// The payload definition using the Jackson library
		JsonNodeFactory jnf = JsonNodeFactory.instance;
		ObjectNode payload = jnf.objectNode();
		{
		  ObjectNode fields = payload.putObject("fields");
		  {
		    fields.put("summary", Tipo);
		    ObjectNode issuetype = fields.putObject("issuetype");
		    {
		      issuetype.put("id", "10003");
		    }
		  }
		  fields.put("description","Clase: "+Clase +"\n Metodo: "+Metodo+"\n Error_Log: \n"+error);
		  ObjectNode project = fields.putObject("project");
		    {
		      project.put("id", "10000");
		    }
		 fields.put("customfield_10020", x);
		
		}

		// Connect Jackson ObjectMapper to Unirest
		Unirest.setObjectMapper(new ObjectMapper() {
		   private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
		           = new com.fasterxml.jackson.databind.ObjectMapper();

		   public <T> T readValue(String value, Class<T> valueType) {
		       try {
		           return jacksonObjectMapper.readValue(value, valueType);
		       } catch (IOException e) {
		           throw new RuntimeException(e);
		       }
		   }

		   public String writeValue(Object value) {
		       try {
		           return jacksonObjectMapper.writeValueAsString(value);
		       } catch (JsonProcessingException e) {
		           throw new RuntimeException(e);
		       }
		   }
		});

		// This code sample uses the  'Unirest' library:
		// http://unirest.io/java.html
		/*HttpResponse<JsonNode> response = Unirest.post("https://solucionesdigitales.atlassian.net/rest/api/2/issue")
		  .basicAuth("ccamargo@solucionesdigitales.com.mx", "yEe2i7CXex4axBIr12LVAD30")
		  .header("Accept", "application/json")
		  .header("Content-Type", "application/json")
		  .body(payload)
		  .asJson();

		System.out.println(response.getBody());*/
		
		HttpResponse<JsonNode> response = Unirest.post("https://axaxa.atlassian.net/rest/api/2/issue")
				  .basicAuth("alex21210@hotmail.es", "ndD7Le0YKcWGlonEbczL93AA")
				  .header("Accept", "application/json")
				  .header("Content-Type", "application/json")
				  .body(payload)
				  .asJson();


		if(response.getStatus()==400) {
			System.out.println("Ocurrio un Error al crear la incidencia");
			System.out.println(response.getStatus());
			System.out.println(response.getBody());
		}else {
			System.out.println("Se creo correctamente la incidencia:");
			System.out.println(response.getStatus());
			System.out.println(response.getBody());
		}
		
		
		//------------------------------------------------------------------------------------------------------------------

	/*HttpResponse<JsonNode> response1 = Unirest.get("https://solucionesdigitales.atlassian.net/rest/api/2/applicationrole")
			.basicAuth("ccamargo@solucionesdigitales.com.mx", "yEe2i7CXex4axBIr12LVAD30")
			  .header("Accept", "application/json")
			  .asJson();

			System.out.println(response1.getBody());	*/
	}
	
}
