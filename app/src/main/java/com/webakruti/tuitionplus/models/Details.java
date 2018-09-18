package com.webakruti.tuitionplus.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 9/4/2018.
 */

public class Details {

        @SerializedName("status")
        private Boolean status;
        @SerializedName("student")
        private Student student;
        @SerializedName("user")
        private Student.User user;

    public Student.User getUser() {
        return user;
    }

    public void setUser(Student.User user) {
        this.user = user;
    }

    public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }



}
