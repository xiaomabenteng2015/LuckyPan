package com.example.walle.luckpan.bean;

import java.util.List;

/**
 * Created by packy1991 on 2018/9/16.
 */

public class HouDongMyPrizeEntity {


    /**
     * status_code : 200
     * message : success
     * data : {"need_qq":0,"items":[{"name":"2元现金红包","created_at":"2018-09-16 01:25:45"},{"name":"+2积分","created_at":"2018-09-16 01:25:43"},{"name":"+2积分","created_at":"2018-09-16 01:25:42"},{"name":"小黄鸭","created_at":"2018-09-16 01:19:33"},{"name":"小黄鸭","created_at":"2018-09-16 01:18:12"},{"name":"+2积分","created_at":"2018-09-16 01:18:07"},{"name":"+2积分","created_at":"2018-09-16 01:18:00"},{"name":"2元现金红包","created_at":"2018-09-16 01:17:53"},{"name":"+2积分","created_at":"2018-09-16 01:17:42"},{"name":"+2积分","created_at":"2018-09-16 01:15:59"},{"name":"2元现金红包","created_at":"2018-09-16 01:12:11"},{"name":"+2积分","created_at":"2018-09-16 01:10:42"},{"name":"2元现金红包","created_at":"2018-09-16 01:10:31"},{"name":"+2积分","created_at":"2018-09-16 01:06:40"},{"name":"+2积分","created_at":"2018-09-16 01:05:39"}]}
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
         * need_qq : 0
         * items : [{"name":"2元现金红包","created_at":"2018-09-16 01:25:45"},{"name":"+2积分","created_at":"2018-09-16 01:25:43"},{"name":"+2积分","created_at":"2018-09-16 01:25:42"},{"name":"小黄鸭","created_at":"2018-09-16 01:19:33"},{"name":"小黄鸭","created_at":"2018-09-16 01:18:12"},{"name":"+2积分","created_at":"2018-09-16 01:18:07"},{"name":"+2积分","created_at":"2018-09-16 01:18:00"},{"name":"2元现金红包","created_at":"2018-09-16 01:17:53"},{"name":"+2积分","created_at":"2018-09-16 01:17:42"},{"name":"+2积分","created_at":"2018-09-16 01:15:59"},{"name":"2元现金红包","created_at":"2018-09-16 01:12:11"},{"name":"+2积分","created_at":"2018-09-16 01:10:42"},{"name":"2元现金红包","created_at":"2018-09-16 01:10:31"},{"name":"+2积分","created_at":"2018-09-16 01:06:40"},{"name":"+2积分","created_at":"2018-09-16 01:05:39"}]
         */

        private int need_qq;
        private List<ItemsBean> items;

        public int getNeed_qq() {
            return need_qq;
        }

        public void setNeed_qq(int need_qq) {
            this.need_qq = need_qq;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * name : 2元现金红包
             * created_at : 2018-09-16 01:25:45
             *  status : 1 发放状态 0:未发放，1：已发放
             */

            private String name;
            private String created_at;
            private int status;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

        }
    }
}
