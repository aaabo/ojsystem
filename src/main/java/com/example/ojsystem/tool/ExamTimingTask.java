package com.example.ojsystem.tool;

import com.example.ojsystem.entity.Exam;
import com.example.ojsystem.entity.Test;
import com.example.ojsystem.service.ExamService;
import com.example.ojsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ExamTimingTask {
    @Autowired
    ExamService examService;
    @Autowired
    TestService testService;
    //3.添加定时任务  30秒
    @Scheduled(cron = "0/30 * * * * ?")
    //或直接指定时间间隔，例如：30秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        List<Exam> exams=examService.queryNotFinishedExamInfo();
        List<Test> tests=testService.queryNotFinishTestInfo();
        //考试
        for(int i=0;i<exams.size();i++){
            Exam exam=exams.get(i);
            String SexamStartTime=exam.getExamStartTime();
            String SexamEndTime=exam.getExamEndTime();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                //使用SimpleDateFormat的parse()方法生成Date
                Date examStartTime = sf.parse(SexamStartTime);
                Date examEndTime = sf.parse(SexamEndTime);
                Date datetime=new Date();
                if(exam.getExamStatus().equals("Pending")){
                    //   开始时间<=当前时间
                    if(examStartTime.compareTo(datetime)<=0){
                        Exam exam1=new Exam();
                        exam1.setExamStatus("Running");
                        exam1.setExamId(exam.getExamId());
                        examService.updateExamStatus(exam1);
                    }

                }else{
                    //   结束时间<=当前时间
                    if(examEndTime.compareTo(datetime)<=0){
                        Exam exam2=new Exam();
                        exam2.setExamStatus("Ended");
                        exam2.setExamId(exam.getExamId());
                        examService.updateExamStatus(exam2);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //测试
        for(int i=0;i<tests.size();i++){
            Test test=tests.get(i);
            String StestStartTime=test.getTestStartTime();
            String StestEndTime=test.getTestEndTime();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                //使用SimpleDateFormat的parse()方法生成Date
                Date testStartTime = sf.parse(StestStartTime);
                Date testEndTime = sf.parse(StestEndTime);
                Date datetime=new Date();
                if(test.getTestStatus().equals("Pending")){
                    //   开始时间<=当前时间
                    if(testStartTime.compareTo(datetime)<=0){
                        Test test1=new Test();
                        test1.setTestStatus("Running");
                        test1.setTestId(test.getTestId());
                        testService.modifyTestStatusByTestId(test1);
                    }

                }else{
                    //   结束时间<=当前时间
                    if(testEndTime.compareTo(datetime)<=0){
                        Test test2=new Test();
                        test2.setTestStatus("Ended");
                        test2.setTestId(test.getTestId());
                        testService.modifyTestStatusByTestId(test2);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }

}
