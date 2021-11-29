package com.example.ojsystem.clustering;

import com.example.ojsystem.entity.User;

public class Point {
    private Float basicScore;     // 基础题，就是选择填空题
    private Float programmingScore;   // 编程题
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getBasicScore() {
        return basicScore;
    }

    public void setBasicScore(Float basicScore) {
        this.basicScore = basicScore;
    }

    public Float getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(Float programmingScore) {
        this.programmingScore = programmingScore;
    }


    @Override
    public String toString() {
        return "Point{" +
                "basicScore=" + basicScore +
                ", programmingScore=" + programmingScore +
                ", user=" + user +
                '}';
    }

    /**
     * 计算距离 欧拉距离公式
     *
     * @param centroid 质心点
     * @return
     */
    public Double calculateDistance(Point centroid) {

        return  Math.sqrt(Math.pow((centroid.getBasicScore() - getBasicScore()), 2) + Math.pow((centroid.getProgrammingScore() - getProgrammingScore()), 2));
    }

    @Override
    public boolean equals(Object obj) {
        Point other = (Point) obj;
        if (getBasicScore().equals(other.getBasicScore()) && getProgrammingScore().equals(other.getProgrammingScore())) {
            return true;
        }
        return false;
    }
}
