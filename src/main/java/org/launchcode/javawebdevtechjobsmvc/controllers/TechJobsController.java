package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.ui.Model;

import java.util.HashMap;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

public class TechJobsController {
    public static HashMap<String, String > actionChoices=new HashMap<>();

    public TechJobsController(){
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

    }

    public static String getActionChoices(Model model){
        model.addAttribute("actions", actionChoices);
        model.addAttribute("columns", columnChoices);
        return "actions";
    }
}
