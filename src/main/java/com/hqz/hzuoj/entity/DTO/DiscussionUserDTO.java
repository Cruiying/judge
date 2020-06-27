package com.hqz.hzuoj.entity.DTO;

import com.hqz.hzuoj.entity.model.Discussion;
import com.hqz.hzuoj.entity.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class DiscussionUserDTO implements Serializable {
    /**
     * 讨论
     */
    @ApiModelProperty("讨论")
    private Discussion discussion;
    /**
     * 用户
     */
    @ApiModelProperty("用户")
    private User user;

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DiscussionUserDTO{" +
                "discussion=" + discussion +
                ", user=" + user +
                '}';
    }
}
