package com.webakruti.tuitionplus.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 8/30/2018.
 */

public class Login {

        @SerializedName("success")
        private Success success;

        public Success getSuccess() {
            return success;
        }

        public void setSuccess(Success success) {
            this.success = success;
        }


    public class Success {

        @SerializedName("token")
        private String token;
        @SerializedName("userId")
        private Integer userId;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }
}
