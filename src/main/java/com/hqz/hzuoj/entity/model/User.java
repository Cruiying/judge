package com.hqz.hzuoj.entity.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author Cruiying
 * @since 2020-06-22 21:17:32
 */
public class User implements Serializable {
    private static final long serialVersionUID = 834351229857989194L;

    @ApiModelProperty("${column.comment}")
    private Integer userId;
    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
    private String username;
    /**
    * 密码
    */
    @ApiModelProperty("密码")
    private String password;
    /**
    * 邮箱
    */
    @ApiModelProperty("邮箱")
    private String email;
    /**
    * 状态(0表示停用，1表示启用)
    */
    @ApiModelProperty("状态(0表示停用，1表示启用)")
    private Boolean status;
    /**
    * 注册时间
    */
    @ApiModelProperty("注册时间")
    private Date registerTime;
    /**
    * 性别
    */
    @ApiModelProperty("性别")
    private String gender;
    /**
    * 头像地址
    */
    @ApiModelProperty("头像地址")
    private String img;
    /**
    * 积分
    */
    @ApiModelProperty("积分")
    private Integer rating;
    /**
    * 学校
    */
    @ApiModelProperty("学校")
    private String school;
    /**
    * 个性签名
    */
    @ApiModelProperty("个性签名")
    private String signature;
    /**
    * 通过数量
    */
    @ApiModelProperty("通过数量")
    private Integer acceptedTotal;
    /**
    * 提交数量
    */
    @ApiModelProperty("提交数量")
    private Integer submitTotal;
    /**
    * 挑战数量
    */
    @ApiModelProperty("挑战数量")
    private Integer challengeTotal;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAcceptedTotal() {
        return acceptedTotal;
    }

    public void setAcceptedTotal(Integer acceptedTotal) {
        this.acceptedTotal = acceptedTotal;
    }

    public Integer getSubmitTotal() {
        return submitTotal;
    }

    public void setSubmitTotal(Integer submitTotal) {
        this.submitTotal = submitTotal;
    }

    public Integer getChallengeTotal() {
        return challengeTotal;
    }

    public void setChallengeTotal(Integer challengeTotal) {
        this.challengeTotal = challengeTotal;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", registerTime=" + registerTime +
                ", gender='" + gender + '\'' +
                ", img='" + img + '\'' +
                ", rating=" + rating +
                ", school='" + school + '\'' +
                ", signature='" + signature + '\'' +
                ", acceptedTotal=" + acceptedTotal +
                ", submitTotal=" + submitTotal +
                ", challengeTotal=" + challengeTotal +
                '}';
    }
}
