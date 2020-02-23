package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;
import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.jobListHeads;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("actions", actionChoices);
        return "search";
    }

        @RequestMapping(value="results")
        public String displaySearchResults(Model model, @RequestParam String searchTerm, @RequestParam String searchType){
            ArrayList<Job> jobs;
            if (searchTerm.toLowerCase().equals("all")){
                jobs = JobData.findAll();

            } else {
                jobs = JobData.findByColumnAndValue(searchType, searchTerm);
                //model.addAttribute("title", "Jobs with Keyword "+searchTerm+ " in "+ searchType+ " Category "+":");
            }
            model.addAttribute("jobs", jobs);
            model.addAttribute("jobHeader", jobListHeads);
            model.addAttribute("columns", columnChoices);
            model.addAttribute("searchType", searchType);
            model.addAttribute("actions", actionChoices);

            return "search";
        }
    @RequestMapping(value="results/moresearch")
    public String moreSearch(Model model, @RequestParam String searchTerm, @RequestParam String searchType){
        ArrayList<Job> jobs;
        if (searchTerm.toLowerCase().equals("all")){
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("jobHeader", jobListHeads);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("actions", actionChoices);

        return "search";
    }
    }


