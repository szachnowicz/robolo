package com.ksm.robolo.roboloapp.rest;

import com.ksm.robolo.roboloapp.services.ProjectService;
import com.ksm.robolo.roboloapp.tos.ProjectStubTO;
import com.ksm.robolo.roboloapp.tos.ProjectTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

    private static final Logger logger = Logger.getLogger(ProjectController.class);

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping(path = "/all")
    @CrossOrigin
    public ResponseEntity<Iterable<ProjectTO>> getAllProjects() {
        Iterable<ProjectTO> projectTOS = projectService.getAllProjects();
        return projectTOS == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(projectTOS, HttpStatus.OK);
    }


    @GetMapping(path = "/stubs/all")
    @CrossOrigin
    public ResponseEntity<Iterable<ProjectStubTO>> getAllProjectStubs() {
        final Iterable<ProjectStubTO> allProjectsStubs = projectService.getAllProjectsStubs();


        return allProjectsStubs == null ?
                new ResponseEntity<Iterable<ProjectStubTO>>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(allProjectsStubs, HttpStatus.OK);

    }

    @GetMapping(path = "/{projectId}")
    @CrossOrigin
    public ResponseEntity<ProjectTO> getProject(@PathVariable String projectId) {
        ProjectTO projectTO = null;

        Long projectIdLong = Long.valueOf(projectId);
        projectTO = projectService.getProject(projectIdLong);


        return projectTO == null ? new ResponseEntity<ProjectTO>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<ProjectTO>(projectTO, HttpStatus.OK);
    }


    @GetMapping(path = "/byclient/{clientId}")
    @CrossOrigin
    public ResponseEntity<Iterable<ProjectStubTO>> getAllProjectsStubForClientId(@PathVariable String clientId) {
        List<ProjectStubTO> fromClientList = null;

        Long clientIdLong = Long.valueOf(clientId);
        fromClientList = projectService.getAllProjectStubsFromClient(clientIdLong);

        return fromClientList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(fromClientList, HttpStatus.OK);


    }


}