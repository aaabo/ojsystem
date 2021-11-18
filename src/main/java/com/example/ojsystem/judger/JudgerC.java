package com.example.ojsystem.judger;

import com.example.ojsystem.entity.ExerciseAnswer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.*;
import java.util.List;

/**
 * @author zk
 *
 */

public class JudgerC       //执行前 启动docker容器 82092ddcabb6 ！！！！！！！！！！
{

    protected static String sudoCmd = "echo \"yang2109121\" | sudo -S ";    //root运行docker
    protected static String CodeResult="SystemError!";      //返回结果, 若返回systemError则无对应测试用例输入

    static ExerciseAnswer[] exerciseAnswer;


    private static void runCmds(String[] cmds) throws IOException, InterruptedException
    {
        Process process = Runtime.getRuntime().exec(cmds);  //运行容器(编译c文件，若报错 信息存入error.txt)
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        while((line = input.readLine()) != null)
        {
            System.out.println("容器："+line);   //容器名称
        }
        process.waitFor();
        System.out.println(process.exitValue());
        readErrFile();
        String ifError=readErrFile();      //读取编译报错文件
        System.out.println(ifError+"\nerror文件长度:"+ifError.length());   //报错文件内容
        System.out.println("running可执行文件");
        File test=new File("/home/zk/docker/gcc_docker/myapp"); //可执行文件
        long compileStart=System.currentTimeMillis();
        while (!test.exists()&&ifError.length()==0){    //等待可执行文件的存在
            long compileEnd=System.currentTimeMillis();
            if(compileEnd-compileStart>5000)
                break;
        }

        if(test.exists()) {     //可执行文件存在，判断代码
            System.out.println("file exists");
            //Runtime.getRuntime().exec("chmod 777 /home/zk/docker/gcc_docker/myapp");    //可执行文件加权
            String result = null; //代码运行结果
            int limitTime = 3;    //代码单次运行时间限制
            float solved=exerciseAnswer.length;     //测试用例通过率undefined
            for(int i=0;i<exerciseAnswer.length;i++)
            {
                String in=exerciseAnswer[i].getExerciseAnswerInput();       //测试用例输入数据
                String answer=exerciseAnswer[i].getExerciseAnswerOutput();  //测试用例对应答案

                try {
                    System.out.println("running...");
                    long startTime = System.currentTimeMillis();  //开始时间
                    String[] cmd = new String[]{"/bin/bash","-c","docker exec charming_shamir echo "+in+" | timeout 3 /home/zk/docker/gcc_docker/myapp"}; //运行可执行文件
                    Process ps = Runtime.getRuntime().exec(cmd); //执行程序
                    ps.waitFor();
                    while(ps.exitValue()==126){    //重试 126下的程序
                        ps=Runtime.getRuntime().exec(cmd);
                        ps.waitFor();
                    }
                    System.out.println("程序结束返回值："+ps.exitValue());  //查看程序结束原因 见：https://tldp.org/LDP/abs/html/exitcodes.html

                    BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));   //读取运行结果
                    StringBuffer sb = new StringBuffer();
                    String line2;
                    while ((line2 = br.readLine()) != null) {
                        sb.append(line2);
                    }
                    result = sb.toString();   //运行结果

                    long endTime = System.currentTimeMillis();    //执行结束时间
                    long runningTime = (endTime - startTime);     //运行耗时ms

                    ps.destroy();
                    System.out.println(result + " --- " + answer); //打印结果

                    System.out.println("i:"+i+" length:"+exerciseAnswer.length);
                    if (answer.equals(result)) {
                        System.out.println("答案正确--耗时" + runningTime + "ms");
                        CodeResult = "accept";
                    } else if (runningTime <= limitTime * 1000) {
                        System.out.println("答案错误--耗时" + runningTime + "ms");
                        CodeResult = "wrong answer"+","+i/solved;
                        break;
                    } else {
                        System.out.println("运行超时--耗时" + runningTime + "ms");
                        CodeResult = "time-limit exceeded"+","+i/solved;
                        break;
                    }
                    //System.out.println("开始时间："+startTime+"  结束时间:"+endTime);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            test.delete();  //删除可执行文件
            if (!test.exists()) System.out.println("delete success！");
            else System.out.println("delete failed!!!!!!!!!!!!");

        }else if(ifError.length()!=0){
            System.out.println("编译错误！！！");
            CodeResult="compile error";
        }else {
            if(readErrFile().length()!=0){      //??error文件未读出  unknow...
                CodeResult="compile error";
                System.out.println();
            }
            else {
                System.out.println("系统错误");
                CodeResult = "not compile";
            }
        }
    }

    public static String start(String code,List<ExerciseAnswer> exerciseAnswerList)
    {
//        String code=("#include <stdio.h> \n" +
//                "void main(){int i=0,k=0,n=2,m=0;scanf(\"%d%d\",&n,&k);scanf(\"%d\",&i);\n"+
//                "m=n;\n"+
//                "while(m--)\n"+
//                "n+=1;\n"+
//                "printf(\"%d %d %d\",n,k,i);}"); //用户输入代码
        exerciseAnswer=new ExerciseAnswer[exerciseAnswerList.size()];
        for(int i=0;i<exerciseAnswerList.size();i++){
            exerciseAnswer[i]=exerciseAnswerList.get(i);
        }

        String input=""; //输入测试用例
        if(code!=null) {
            createCfile(code);
            try {
                testcExecuteCommand();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CodeResult;
    }

    private static void testcExecuteCommand() throws IOException, InterruptedException        //容器启动命令+答案+
    {
        String cmds[] = {"/bin/bash", "-c",sudoCmd+"docker restart 1b368c20ac15"};   //root下运行docker (gcc -o myapp main.c > error.txt 2>&1)
        System.out.println("Running docker...");
        JudgerC.runCmds(cmds);    //(运行容器，编译文件)
    }
    private static void createCfile(String code){       //代码写入.c文件
        File f=new File("/home/zk/docker/gcc_docker/main.c");
        //Boolean r=false;
        if(!f.exists()){
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                Writer w = new FileWriter(f);
                w.write(code);
                w.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static String readErrFile(){    //读取error文件（编译错误信息重定向文件）
        FileInputStream fis=null;
        String s=null;
        try{
            fis=new FileInputStream("/home/zk/docker/gcc_docker/error.txt");
            byte[] data=new byte[4096];
            int i=0,n= fis.read();
            while (n!=-1){
                data[i]=(byte) n;
                i++;
                n=fis.read();
            }
            s=new String(data,0,i);
            return s;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                assert fis != null;
                fis.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
//    public Connection getConnection() { // 建立返回值为Connection的方法
//        try { // 加载数据库驱动类
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("数据库驱动加载成功");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try { // 通过访问数据库的URL获取数据库连接对象
//            con = DriverManager.getConnection("jdbc:mysql:"
//                    + "//127.0.0.1:3306/ojsystem", "root", "root123");
//            System.out.println("数据库连接成功");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con; // 按方法要求返回一个Connection对象
//    }
}