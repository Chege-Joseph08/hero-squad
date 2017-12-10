import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

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
      String cause = request.queryParams("cause");
      Squad newSquad = new Squad(name, cause);
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


//Individual squad object route
    get("/squads/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
          model.put("squad", squad);
          model.put("template", "templates/squad.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


//new hero route(form)
    get("squads/:id/heroes/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
        model.put("squad", squad);
        model.put("template", "templates/HeroForm.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


//all hero objects
    post("/heroes", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
      String name = request.queryParams("name");
      int age =  Integer.parseInt(request.queryParams("age"));
      String power = request.queryParams("power");
      String weakness = request.queryParams("weakness");
      Hero newHero = new Hero(name, age, power, weakness);

      squad.addHero(newHero);

      model.put("squad", squad);
      model.put("template", "templates/heroSuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


//individual hero object
    get("/heroes/:id", (request, response) -> {
           HashMap<String, Object> model = new HashMap<String, Object>();
           Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
           model.put("hero", hero);
           model.put("template", "templates/hero.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());



  }

}
