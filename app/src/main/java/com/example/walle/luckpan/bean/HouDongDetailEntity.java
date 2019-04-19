package com.example.walle.luckpan.bean;

import java.util.List;

/**
 * Created by packy1991 on 2018/9/16.
 */

public class HouDongDetailEntity {

    /**
     * status_code : 200
     * message : ok
     * data : {"id":1,"title":"全民来找茬","rule":"规则测试","start_time":"2018-09-11 21:04:52","end_time":"2018-09-21 21:04:58","share_title":"测试分享标题","share_desc":"测试分享描述","share_img":"","share_url":"","sub_data":{"prizes":[{"id":1,"name":"8888元现金","image":""},{"id":2,"name":"小黄鸭","image":""},{"id":3,"name":"2元现金红包","image":""},{"id":4,"name":"+2积分","image":""}]}}
     */

    private String status_code;
    private String message;
    private DataBean data;

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * integral : 剩余积分
         * title : 抽奖啦
         * rule : 规则测试
         * start_time : 2018-09-11 21:04:52
         * end_time : 2018-09-21 21:04:58
         * share_title : 测试分享标题
         * share_desc : 测试分享描述
         * share_img :
         * share_url :
         * sub_data : {"prizes":[{"id":1,"name":"8888元现金","image":""},{"id":2,"name":"小黄鸭","image":""},{"id":3,"name":"2元现金红包","image":""},{"id":4,"name":"+2积分","image":""}]}
         */

        private int id;
        private int integral;
        private String title;
        private String rule;
        private String start_time;
        private String end_time;
        private String share_title;
        private String share_desc;
        private String share_img;
        private String share_url;
        private SubDataBean sub_data;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getShare_desc() {
            return share_desc;
        }

        public void setShare_desc(String share_desc) {
            this.share_desc = share_desc;
        }

        public String getShare_img() {
            return share_img;
        }

        public void setShare_img(String share_img) {
            this.share_img = share_img;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public SubDataBean getSub_data() {
            return sub_data;
        }

        public void setSub_data(SubDataBean sub_data) {
            this.sub_data = sub_data;
        }

        public static class SubDataBean {
            private List<PrizesBean> prizes;

            public List<PrizesBean> getPrizes() {
                return prizes;
            }

            public void setPrizes(List<PrizesBean> prizes) {
                this.prizes = prizes;
            }

            public static class PrizesBean {
                /**
                 * id : 1
                 * name : 8888元现金
                 * image :
                 */

                private int id;
                private String name;
                private String image;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }
    }
}
