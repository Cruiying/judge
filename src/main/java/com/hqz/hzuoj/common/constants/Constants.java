package com.hqz.hzuoj.common.constants;

import org.springframework.stereotype.Component;

/**
 * 系统常量类配置
 * @author Cruiying
 * @date 2020/6/28 9:47
 */
@Component
public class Constants {

    /**
     * 验证码过期时间 此处为五分钟
     */
    Integer CODE_EXPIRE_TIME = 5;

    /**
     * jwtToken过期时间
     */
    Long TOKEN_EXPIRE_TIME = 30 * 24 * 60 * 60 * 1000L;

    /**
     * token请求头名称
     */
    String TOKEN_HEADER_NAME = "X-Token";

    /**
     * 表单重复提交间隔时间 单位 S
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    int FORM_REPEAT_TIME = 10;

    public interface Level {
        /** 等级字段 **/
        final String LEVEL_CODE = "LEVEL_CODE";
    }

    public static class Tag {
        /** 标签字段 **/
        final String TAG_CODE = "TAG_CODE";
    }

    public static class  Problem {
        /** 公开类型 */
        public interface Public {
            /** 管理员 **/
            final Integer ADMIN = -1;
            /** 公开 **/
            final Integer PUBLIC = 0;
            /** 比赛 **/
            final Integer CONTEST = 1;
        }
    }

    public static class Contest {
        /** 赛制类型 **/
        public interface Type {
            /** IO类型 **/
            final String OI = "OI";
            /** ACM类型 **/
            final String ACM = "ACM";
            /** IOI类型 **/
            final String IOI = "IOI";
            /** 乐多类型 **/
            final String LEDUO = "LEDUO";
            /** CF类型 **/
            final String CF = "CF";
        }
        /** 比赛状态 **/
        public interface Status {
            /** 未开始 **/
            final Integer NOT_START = -1;
            /** 进行中 **/
            final Integer START = 0;
            /** 已结束 **/
            final Integer END = 1;
        }
        /** 比赛公开类型  **/
        public interface Public {
            /** 私有比赛（需要密码可访问） **/
            final Integer PRIVATE = 0;
            /** 公开比赛（任何人都可以报名） **/
            final Integer PUBLIC = 1;
            /** 管理员才能访问看见 **/
            final Integer ADMIN = -1;
        }
        /** 比赛报名状态 **/
        public interface Register {
            /** 报名未开始 **/
            final Integer NOT_START = -1;
            /** 报名中 **/
            final Integer START = 0;
            /** 已经结束 **/
            final Integer END = 1;
        }
        /** 比赛Rating计算状态 **/
        public interface Rating {
            /** 未开始 **/
            final Integer NOT_START = -1;
            /** 计算中 **/
            final Integer START = 0;
            /** 计算完成 **/
            final Integer END = 1;
        }
        /** 比赛排名状态 **/
        public interface Rank {
            /** 未开始 **/
            final Integer NOT_START = -1;
            /** 计算中 **/
            final Integer START = 0;
            /** 计算完成 **/
            final Integer END = 1;
        }
        /** 比赛是否计算Rating **/
        public interface IsRating {
            /** 计算 **/
            final Integer YES = 1;
            /** 不计算 **/
            final Integer NO = 0;
        }
        /** 比赛排名是否封榜 **/
        public interface IsRank {
            /** 封榜 **/
            final Integer YES = 1;
            /** 不封榜 **/
            final Integer NO = 0;
        }
    }
    public static class Discussion {
        /** 讨论置顶状态 **/
        public interface Top {
            /** 置顶 **/
            final Integer YES = 1;
            /** 不置顶 **/
            final Integer NO = 0;
        }
    }

    public static class Solution {
        /** 题解审核状态 **/
        public interface Status {

            /** 审核中 **/
            final Integer PENDING = -1;
            /** 通过 **/
            final Integer PASS = 0;
            /** 未通过 **/
            final Integer NOT_PASS = 1;
        }
    }

    public static class Submit {
        /** 用户查看测评类型 **/
        public interface Public {
            final Integer PRIVATE = 0;
            final Integer PUBLIC = 1;
            final Integer CONTENT = 2;
        }
        /** 用户提交测评类型 **/
        public interface Type {
            /** 题库中提交 **/
            final Integer PROBLEM = 0;
            /** 比赛中提交 **/
            final Integer CONTENT = 1;
        }
    }

}
