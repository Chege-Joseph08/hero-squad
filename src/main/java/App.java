import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

     ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);

//index route
    get("/", (request, response) -> {
      	Map<String, Object> model = new HashMap<String, Object>();
      	model.put("template", "templates/index.vtl");
      	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
	

	//POST squads
    post("/squads", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String reason = request.queryParams("reason");
      Squad newSquad = new Squad(name, reason);
      model.put("template", "templates/squadSuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


//new squad route (form)
    get("/squads/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/squadForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//all squad objects' route
    get("/squads", (response,request) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("template", "templates/squads.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());


  
  }
}