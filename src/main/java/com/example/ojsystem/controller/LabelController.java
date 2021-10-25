package com.example.ojsystem.controller;

import com.example.ojsystem.entity.Label;
import com.example.ojsystem.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService exerciseLabelService;
    /**
     * 获取标签信息并添加
     * 输入label
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/addLabelInfo",method = RequestMethod.POST)
    public Object addLabelInfo(HttpServletRequest request){
        int i=0;
        Label exerciseLabel=new Label();
        exerciseLabel.setFirstPoint(request.getParameter("firstPoint"));
        exerciseLabel.setSecondPoint(request.getParameter("secondPoint"));
        i=exerciseLabelService.addLabelInfo(exerciseLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 获取全部标签信息
     * 输入无
     * 成功输出List<Label>
     */
    @RequestMapping(value="/queryLabelInfo",method = RequestMethod.POST)
    public Object queryLabelInfo(HttpServletRequest request){

        return exerciseLabelService.queryLabelInfo();

    }

    /**
     * 获取习题标签所有一级分类信息
     * 输入无
     * 成功输出List<String>
     */
    @RequestMapping(value="/queryLabelFirstPointInfo",method = RequestMethod.POST)
    public Object queryLabelFirstPointInfo(HttpServletRequest request){
        return exerciseLabelService.queryLabelFirstPointInfo();
    }
    /**
     * 获取习题标签所有二级分类信息
     * 输入无
     * 成功输出List<Label>
     */
    @RequestMapping(value="/queryLabelSecondPointInfo",method = RequestMethod.POST)
    public Object queryLabelSecondPointInfo(HttpServletRequest request){

        return exerciseLabelService.queryLabelSecondPointInfo(request.getParameter("firstPoint"));
    }

    /**
     * 修改对应的标签信息
     * 输入label
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/modifyLabelInfo",method = RequestMethod.POST)
    public Object modifyLabelInfo(HttpServletRequest request){

        int i=0;
        Label exerciseLabel=new Label();
        exerciseLabel.setLabelId(Integer.valueOf(request.getParameter("labelId")));
        exerciseLabel.setFirstPoint(request.getParameter("firstPoint"));
        exerciseLabel.setSecondPoint(request.getParameter("secondPoint"));
        i=exerciseLabelService.modifyLabelInfo(exerciseLabel);
        if(i>0){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * 删除对应的标签信息
     * 输入label
     * 成功输出true 失败输出false
     */
    @RequestMapping(value="/deleteLabelInfo",method = RequestMethod.POST)
    public Object deleteLabelInfo(HttpServletRequest request){
        int i=0;
        i=exerciseLabelService.deleteLabelInfo(Integer.valueOf(request.getParameter("labelId")));
        if(i>0){
            return true;
        }
        else{
            return false;
        }
    }
}
