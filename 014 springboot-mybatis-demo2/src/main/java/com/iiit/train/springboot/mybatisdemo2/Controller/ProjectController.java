package com.iiit.train.springboot.mybatisdemo2.Controller;

import com.iiit.train.springboot.mybatisdemo2.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;

/**
 * Created By Donghua.Chen on  2018/1/9
 */
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/add/project-file", method = RequestMethod.POST)
    public ResponseEntity addProjectFile(){

        File file = new File("C:\\Users\\donghua.chen\\Desktop\\开办新公司.mpp");
        projectService.readMmpFileToDB(file);
        return ResponseEntity.ok("导入成功!!");
    }
}
