package com.example.ojsystem.tool;

import com.example.ojsystem.entity.Exam;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class ExcelToolController {
//    @Autowired
//    ExamChoiceQuestionService examChoiceQuestionService;
//    @RequestMapping(value = "/excel", method = RequestMethod.POST)
//    public Object upload(MultipartFile file, HttpServletRequest request) throws IOException {
//        int o=0;
//        InputStream in = null;
//        try {
//            //将file转InputStream
//            in = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        int examId=Integer.valueOf(request.getParameter("examId"));
//        String fileName = file.getOriginalFilename();
//        String fileExt = fileName.substring(fileName.lastIndexOf("."));
//        ArrayList<ExamChoiceQuestion> examChoiceQuestions=new ArrayList<ExamChoiceQuestion>();
//        if (fileExt.equals(".xls")) {
//            //将InputStream转XLSX对象（即表格对象）
//            HSSFWorkbook xssfWorkbook = new HSSFWorkbook(in);
//            //获取表格的第一页
//            HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//            //获取该页有多少数据
//            int rowNum = xssfSheet.getLastRowNum();
//            for (int i = 1; i <= rowNum; i++) {
//                //获取当前行
//                HSSFRow xssfRow = xssfSheet.getRow(i);
//
//                //由于学号是纯数字，默认纯数字是以double传的，写进据库会变成科学计数法格式的，需要改为以string传进来
//
//
//                //以此获得该行的所有单元格
//                String examChoiceQuestionTitle = xssfRow.getCell(0).toString();
//                String examChoiceQuestionStemA = xssfRow.getCell(1).toString();
//                String examChoiceQuestionStemB = xssfRow.getCell(2).toString();
//                String examChoiceQuestionStemC = xssfRow.getCell(3).toString();
//                String examChoiceQuestionStemD = xssfRow.getCell(4).toString();
//                String examChoiceQuestionCorrectOption = xssfRow.getCell(5).toString();
//                String examChoiceQuestionScore = xssfRow.getCell(6).toString();
//                ExamChoiceQuestion examChoiceQuestion = new ExamChoiceQuestion();
//                examChoiceQuestion.setExamChoiceQuestionTitle(examChoiceQuestionTitle);
//                examChoiceQuestion.setExamChoiceQuestionStemA(examChoiceQuestionStemA);
//                examChoiceQuestion.setExamChoiceQuestionStemB(examChoiceQuestionStemB);
//                examChoiceQuestion.setExamChoiceQuestionStemC(examChoiceQuestionStemC);
//                examChoiceQuestion.setExamChoiceQuestionStemD(examChoiceQuestionStemD);
//                examChoiceQuestion.setExamChoiceQuestionCorrectOption(examChoiceQuestionCorrectOption);
//                examChoiceQuestion.setExamChoiceQuestionScore(Integer.valueOf(examChoiceQuestionScore));
//                Exam exam=new Exam();
//                exam.setExamId(examId);
//                examChoiceQuestion.setExam(exam);
//                //将数据写入实体类
//                //将实体类插入数据库
//                o=examChoiceQuestionService.addChoiceQuestionExamInfo(examChoiceQuestion);
//                if(o==0){
//                    return false;
//                }
//            }
//            if(o!=0){
//                return true;
//            }
//        } else if (fileExt.equals(".xlsx")) {
//            //将InputStream转XLSX对象（即表格对象）
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
//            //获取表格的第一页
//            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//            //获取该页有多少数据
//            int rowNum = xssfSheet.getLastRowNum();
//
//            for (int i = 1; i <= rowNum; i++) {
//                //获取当前行
//                XSSFRow xssfRow = xssfSheet.getRow(i);
//                if(xssfRow.getLastCellNum()==9){
//                    //由于学号是纯数字，默认纯数字是以double传的，写进据库会变成科学计数法格式的，需要改为以string传进来
//                    //以此获得该行的所有单元格
//                    //去除空格后的字符串长度
//                    if(xssfRow.getCell(0).toString().replace(" ","").length()>0){
//                        String examChoiceQuestionTitle = xssfRow.getCell(0).toString();
//                        String examChoiceQuestionStemA = xssfRow.getCell(1).toString();
//                        String examChoiceQuestionStemB = xssfRow.getCell(2).toString();
//                        String examChoiceQuestionStemC = xssfRow.getCell(3).toString();
//                        String examChoiceQuestionStemD = xssfRow.getCell(4).toString();
//                        String examChoiceQuestionCorrectOption = xssfRow.getCell(5).toString();
//                        String examChoiceQuestionScore = xssfRow.getCell(6).toString();
//                        //有值但是 为空
//                        if(examChoiceQuestionTitle.replace(" ","").equals("")||examChoiceQuestionStemA.replace(" ","").equals("")||examChoiceQuestionStemB.replace(" ","").equals("")
//                                ||examChoiceQuestionStemC.replace(" ","").equals("")||examChoiceQuestionStemD.replace(" ","").equals("")||examChoiceQuestionCorrectOption.equals("")||examChoiceQuestionScore.equals("")){
//                            return 1;
//                        }
//                        ExamChoiceQuestion examChoiceQuestion = new ExamChoiceQuestion();
//                        examChoiceQuestion.setExamChoiceQuestionTitle(examChoiceQuestionTitle);
//                        examChoiceQuestion.setExamChoiceQuestionStemA(examChoiceQuestionStemA);
//                        examChoiceQuestion.setExamChoiceQuestionStemB(examChoiceQuestionStemB);
//                        examChoiceQuestion.setExamChoiceQuestionStemC(examChoiceQuestionStemC);
//                        examChoiceQuestion.setExamChoiceQuestionStemD(examChoiceQuestionStemD);
//                        examChoiceQuestion.setExamChoiceQuestionCorrectOption(examChoiceQuestionCorrectOption);
//                        examChoiceQuestion.setExamChoiceQuestionScore((Double.valueOf(examChoiceQuestionScore)).intValue());
//                        Exam exam=new Exam();
//                        exam.setExamId(examId);
//                        examChoiceQuestion.setExam(exam);
//                        examChoiceQuestions.add(examChoiceQuestion);
//                    }else{
//                        //字符串长度
//                        if(xssfRow.getCell(0).toString().length()>0){
//                            //有空格 结束
//                            break;
//                        }else{
//                            //去不去空格都为0 到了最后一个数据下面   结束
//
//                            break;
//                        }
//                    }
//                }else{
//                    //列数不正确有修改 请按照模板格式填写数据
//                    return 2;
//                }
//
//
//
//            }//for结束
//            //将实体类插入数据库
//            for(int i=0;i<examChoiceQuestions.size();i++){
//                examChoiceQuestionService.addChoiceQuestionExamInfo(examChoiceQuestions.get(i));
//            }
//        }
//        //成功
//        return 3;
//    }
}
