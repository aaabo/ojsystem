package com.example.ojsystem.clustering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kmeans {

    public static List<Cluster> run(List<Point> points, int k) {
        // 初始化质心点
        List<Cluster> clusters = initCentroides(points, k);

        while (!checkConvergence(clusters)) { // 所有分类是否全部收敛
            // 1.计算距离对每个点进行分类
            // 2.判断质心点是否改变,未改变则该分类已经收敛
            // 3.重新生成质心点
            initClusters(clusters); //清空属于该质点的 点

            classifyPoint(points, clusters);// 计算距离进行分类

            recalcularCentroides(clusters); // 重新计算质心点

        }

        // 计算目标函数值
//        Double ofv = calcularObjetiFuncionValue(clusters);
//        KmeansModel kmeansModel = new KmeansModel(clusters, ofv, k, type);
            return clusters;

    }

    /**
     * 初始化k个质心点
     *
     * @param points 点集
     * @param k      K值
     * @return List<Cluster>
     */
    private static List<Cluster> initCentroides(List<Point> points, Integer k) {
        List<Cluster> centroides = new ArrayList<Cluster>();

        // 求出数据集的范围(找出所有点的基础题最小、最大和编程题最小、最大坐标。)
        Float max_BasicScore = Float.MIN_VALUE;
        Float max_ProgrammingScore = Float.MIN_VALUE;
        Float min_BasicScore = Float.MAX_VALUE;
        Float min_ProgrammingScore = Float.MAX_VALUE;
        for (Point point : points) {
            max_BasicScore = max_BasicScore < point.getBasicScore() ? point.getBasicScore() : max_BasicScore;
            max_ProgrammingScore = max_ProgrammingScore < point.getProgrammingScore() ? point.getProgrammingScore() : max_ProgrammingScore;
            min_BasicScore = min_BasicScore > point.getBasicScore() ? point.getBasicScore() : min_BasicScore;
            min_ProgrammingScore = min_ProgrammingScore > point.getProgrammingScore() ? point.getProgrammingScore() : min_ProgrammingScore;
        }
        //System.out.println("min_BasicScore" + min_BasicScore + ",max_BasicScore:" + max_BasicScore + ",min_ProgrammingScore" + min_ProgrammingScore + ",max_ProgrammingScore" + max_ProgrammingScore);

        // 在范围内初始化k个质心点 3个质心点
        // 随机初始化k个中心点  3个质心点
        for (int i = 0; i < k; i++) {
            float basicScore=0;
            float programmingScore=0;
            String theme="";
            if(i==0){
                basicScore=min_BasicScore;
                programmingScore=min_ProgrammingScore;
                theme="基础和编程都较差";
            }else if(i==1){
                basicScore=min_BasicScore;
                programmingScore=max_ProgrammingScore;
                theme="基础和编程相比较差";
            }else if(i==2){
                basicScore=max_BasicScore;
                programmingScore=min_ProgrammingScore;
                theme="基础和编程相比较好";
            }else if(i==3){
                basicScore=max_BasicScore;
                programmingScore=max_ProgrammingScore;
                theme="基础和编程都不错";
            }
            Cluster c = new Cluster();
            Point centroide = new Point(); // 初始化的随机中心点
            centroide.setBasicScore(basicScore);
            centroide.setProgrammingScore(programmingScore);
            c.setCentroid(centroide);
            c.setTheme(theme);
            centroides.add(c);
        }

        return centroides;
    }

    /**
     * 重新计算质心点
     *
     * @param clusters
     */
    private static void recalcularCentroides(List<Cluster> clusters) {
        for (Cluster c : clusters) {
            if (c.getPoints().isEmpty()) {
                c.setConvergence(true);
                continue;
            }
            // 求均值,作为新的质心点
            Float basicScore;
            Float programmingScore;
            Float sum_basicScore = 0f;
            Float sum_programmingScore = 0f;
            for (Point point : c.getPoints()) {
                sum_basicScore += point.getBasicScore();
                sum_programmingScore += point.getProgrammingScore();
            }
            basicScore = sum_basicScore / c.getPoints().size();
            programmingScore = sum_programmingScore / c.getPoints().size();
            Point newCentroide = new Point(); // 新的质心点
            newCentroide.setBasicScore(basicScore);
            newCentroide.setProgrammingScore(programmingScore);

            if (newCentroide.equals(c.getCentroid())) { // 如果质心点不再改变 则该分类已经收敛
                c.setConvergence(true);
            } else {
                c.setCentroid(newCentroide);
            }
        }
    }

    /**
     * 计算距离,对点集进行分类
     *
     * @param points   点集
     * @param clusters 质心点集合
     */
    private static void classifyPoint(List<Point> points, List<Cluster> clusters) {
        for (Point point : points) {
            Cluster masCercano = clusters.get(0); // 该点计算距离后所属的分类 先赋值为第一个质心点
            Double minDistancia = Double.MAX_VALUE; // 最小距离
            for (Cluster cluster : clusters) {  //循环全部的质心点
                Double distancia = point.calculateDistance(cluster.getCentroid()); // 点和每个分类质心点的距离
                if (minDistancia > distancia) { // 得到该点和k个质心点最小的距离
                    minDistancia = distancia;
                    masCercano = cluster; // 得到最近的质心点 实际上距离质心点最近
                }
            }
            masCercano.getPoints().add(point); // 将该点添加到距离最近的分类中
        }
    }

    //清空属于该质点的 点
    private static void initClusters(List<Cluster> clusters) {
        for (Cluster cluster : clusters) {
            cluster.initPoint();
        }
    }

    /**
     * 检查收敛
     *
     * @param clusters
     * @return
     */
    private static boolean checkConvergence(List<Cluster> clusters) {
        for (Cluster cluster : clusters) {
            if (!cluster.isConvergence()) {
                return false;
            }
        }
        return true;
    }



}
