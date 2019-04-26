package com.iiit.train.springboot.mybatisdemo2.mapper;

import com.iiit.train.springboot.mybatisdemo2.model.Project;

/**
 * ProjectMapper类
 * Created By Donghua.Chen on  2018/1/9
 */
public interface ProjectMapper {

    /**
     * 插入project数据
     * @param project
     * @return
     */
    int addProjectSelective(Project project);
}
