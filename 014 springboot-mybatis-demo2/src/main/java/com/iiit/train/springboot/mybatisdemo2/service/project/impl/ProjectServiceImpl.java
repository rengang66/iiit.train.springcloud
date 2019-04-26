package com.iiit.train.springboot.mybatisdemo2.service.project.impl;

import com.iiit.train.springboot.mybatisdemo2.mapper.ProjectMapper;
import com.iiit.train.springboot.mybatisdemo2.model.Project;
import com.iiit.train.springboot.mybatisdemo2.service.project.ProjectService;
import com.iiit.train.springboot.mybatisdemo2.utils.StringUtils;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By Donghua.Chen on  2018/1/9
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    public static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectMapper projectMapper;


    @Override
    public Integer addProjectInfo(Project project) {
        return projectMapper.addProjectSelective(project);
    }

    @Transactional
    @Override
    public void readMmpFileToDB(File file) {
        try{
            MPPReader mppRead = new MPPReader();
            ProjectFile pf = mppRead.read(file);
            System.out.println(file.getName());
            List<Task> tasks = pf.getChildTasks();
            System.out.println("tasks.size() : " + tasks.size());
            List<Project> proList = new LinkedList<>();
            Project pro = new Project();
            pro.setBatchNum(StringUtils.UUID());//生成批次号UUID

            getChildrenTask(tasks.get(0), pro ,proList, 0);
        }catch (MPXJException e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void getChildrenTask(Task task, Project project, List<Project> list, int levelNum){
        if(task.getResourceAssignments().size() == 0){
            levelNum ++;//批次号需要增加
            List<Task> tasks = task.getChildTasks();
            for (int i = 0; i < tasks.size(); i++) {
                if(tasks.get(i).getResourceAssignments().size() == 0){
                    System.out.println("+++++" + tasks.get(i));
                    Project pro = new Project();
                    if (project.getProjId() != null){//说明不是第一次读取了
                        pro.setParentId(project.getProjId());//将上一级目录的Id赋值给下一级
                    }
                    pro.setBatchNum(project.getBatchNum());
                    pro.setImportTime(new Date());
                    pro.setLevel(levelNum);
                    pro.setTaskName(tasks.get(i).getName());
                    this.addProjectInfo(pro);
                    pro.setProjId(pro.getProjId());
                    getChildrenTask(tasks.get(i), pro,list,levelNum);
                }else{
                    getChildrenTask(tasks.get(i), project, list, levelNum);
                }
            }
        }else{
            if (project.getProjId() != null){

                getResourceAssignment(task, project, list, levelNum);
            }
        }
    }

    public void getResourceAssignment(Task task, Project project, List<Project> proList, int levelNum){
        List<ResourceAssignment> list = task.getResourceAssignments();
        ResourceAssignment rs = list.get(0);
        System.out.println("task = [" + task.getName());
        Project pro = new Project();
        pro.setTaskName(task.getName());
        pro.setParentId(project.getProjId());
        pro.setLevel(levelNum);
        pro.setImportTime(new Date());
        pro.setBatchNum(project.getBatchNum());
        pro.setDurationDate(rs.getCreateDate().toString());
        pro.setStartDate(rs.getStart());
        pro.setEndDate(rs.getFinish());
        String resource = null;
        if(list.size() > 1){
            System.out.println("resource = ");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getResource() != null){
                    if(i < list.size() - 1){
                        resource = list.get(i).getResource().getName() + ",";
                    }else{
                        resource = list.get(i).getResource().getName();
                    }
                }
            }
        }else{

            if(list.size() > 0 && list.get(0).getResource() != null){
                resource = list.get(0).getResource().getName();
            }
        }
        pro.setResource(resource);
        this.addProjectInfo(pro);
        pro.setProjId(pro.getProjId());
        proList.add(pro);

    }
}
