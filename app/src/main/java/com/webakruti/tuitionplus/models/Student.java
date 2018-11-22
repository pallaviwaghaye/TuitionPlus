package com.webakruti.tuitionplus.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Student {

    public static class Studentcourse {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("student_id")
        @Expose
        private String studentId;
        @SerializedName("course_id")
        @Expose
        private String courseId;
        @SerializedName("joinclass")
        @Expose
        private String joinclass;
        @SerializedName("course_fee")
        @Expose
        private String courseFee;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("discount_para")
        @Expose
        private String discountPara;
        @SerializedName("discount_amt")
        @Expose
        private String discountAmt;
        @SerializedName("discount_name")
        @Expose
        private String discountName;
        @SerializedName("course_fee_with_discount")
        @Expose
        private String courseFeeWithDiscount;
        @SerializedName("tax")
        @Expose
        private String tax;
        @SerializedName("tax_amt")
        @Expose
        private String taxAmt;
        @SerializedName("sub_total")
        @Expose
        private String subTotal;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("term")
        @Expose
        private String term;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("studentcoursesfeemng")
        @Expose
        private List<Studentcoursesfeemng> studentcoursesfeemng = null;
        @SerializedName("course")
        @Expose
        private Course course;



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getJoinclass() {
            return joinclass;
        }

        public void setJoinclass(String joinclass) {
            this.joinclass = joinclass;
        }

        public String getCourseFee() {
            return courseFee;
        }

        public void setCourseFee(String courseFee) {
            this.courseFee = courseFee;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountPara() {
            return discountPara;
        }

        public void setDiscountPara(String discountPara) {
            this.discountPara = discountPara;
        }

        public String getDiscountAmt() {
            return discountAmt;
        }

        public void setDiscountAmt(String discountAmt) {
            this.discountAmt = discountAmt;
        }

        public String getDiscountName() {
            return discountName;
        }

        public void setDiscountName(String discountName) {
            this.discountName = discountName;
        }

        public String getCourseFeeWithDiscount() {
            return courseFeeWithDiscount;
        }

        public void setCourseFeeWithDiscount(String courseFeeWithDiscount) {
            this.courseFeeWithDiscount = courseFeeWithDiscount;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getTaxAmt() {
            return taxAmt;
        }

        public void setTaxAmt(String taxAmt) {
            this.taxAmt = taxAmt;
        }

        public String getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(String subTotal) {
            this.subTotal = subTotal;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public List<Studentcoursesfeemng> getStudentcoursesfeemng() {
            return studentcoursesfeemng;
        }

        public void setStudentcoursesfeemng(List<Studentcoursesfeemng> studentcoursesfeemng) {
            this.studentcoursesfeemng = studentcoursesfeemng;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

    }

    public static class Studentpayment {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("student_id")
        @Expose
        private String studentId;
        @SerializedName("student_course_fee_id")
        @Expose
        private String studentCourseFeeId;
        @SerializedName("paid_amt")
        @Expose
        private String paidAmt;
        @SerializedName("receipt_no")
        @Expose
        private String receiptNo;
        @SerializedName("cancelled")
        @Expose
        private String cancelled;
        @SerializedName("canclenote")
        @Expose
        private Object canclenote;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getStudentCourseFeeId() {
            return studentCourseFeeId;
        }

        public void setStudentCourseFeeId(String studentCourseFeeId) {
            this.studentCourseFeeId = studentCourseFeeId;
        }

        public String getPaidAmt() {
            return paidAmt;
        }

        public void setPaidAmt(String paidAmt) {
            this.paidAmt = paidAmt;
        }

        public String getReceiptNo() {
            return receiptNo;
        }

        public void setReceiptNo(String receiptNo) {
            this.receiptNo = receiptNo;
        }

        public String getCancelled() {
            return cancelled;
        }

        public void setCancelled(String cancelled) {
            this.cancelled = cancelled;
        }

        public Object getCanclenote() {
            return canclenote;
        }

        public void setCanclenote(Object canclenote) {
            this.canclenote = canclenote;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class Studentparents implements Serializable {
        public Studentparents() {
        }

        public Studentparents(Integer id, String studentId, String fname, Object mname, String lname, String relation, String gender, String mobile, Object altmobile, Object email, String address, String city, String state, String country, String pincode, String createdAt, String updatedAt) {
            this.id = id;
            this.studentId = studentId;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.relation = relation;
            this.gender = gender;
            this.mobile = mobile;
            this.altmobile = altmobile;
            this.email = email;
            this.address = address;
            this.city = city;
            this.state = state;
            this.country = country;
            this.pincode = pincode;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        @SerializedName("id")
        private Integer id;
        @SerializedName("student_id")
        private String studentId;
        @SerializedName("fname")
        private String fname;
        @SerializedName("mname")
        private Object mname;
        @SerializedName("lname")
        private String lname;
        @SerializedName("relation")
        private String relation;
        @SerializedName("gender")
        private String gender;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("altmobile")
        private Object altmobile;
        @SerializedName("email")
        private Object email;
        @SerializedName("address")
        private String address;
        @SerializedName("city")
        private String city;
        @SerializedName("state")
        private String state;
        @SerializedName("country")
        private String country;
        @SerializedName("pincode")
        private String pincode;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public Object getMname() {
            return mname;
        }

        public void setMname(Object mname) {
            this.mname = mname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getAltmobile() {
            return altmobile;
        }

        public void setAltmobile(Object altmobile) {
            this.altmobile = altmobile;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public static class Studentcoursesfeemng {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("student_course_id")
        @Expose
        private String studentCourseId;
        @SerializedName("payment_mode")
        @Expose
        private String paymentMode;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("paid_amt")
        @Expose
        private String paidAmt;
        @SerializedName("remaining_amt")
        @Expose
        private String remainingAmt;
        @SerializedName("term")
        @Expose
        private String term;
        @SerializedName("due_date")
        @Expose
        private String dueDate;
        @SerializedName("paid_date")
        @Expose
        private Object paidDate;
        @SerializedName("user_id")
        @Expose
        private Object userId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("studentpayments")
        @Expose
        private List<Studentpayment> studentpayments = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getStudentCourseId() {
            return studentCourseId;
        }

        public void setStudentCourseId(String studentCourseId) {
            this.studentCourseId = studentCourseId;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPaidAmt() {
            return paidAmt;
        }

        public void setPaidAmt(String paidAmt) {
            this.paidAmt = paidAmt;
        }

        public String getRemainingAmt() {
            return remainingAmt;
        }

        public void setRemainingAmt(String remainingAmt) {
            this.remainingAmt = remainingAmt;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public Object getPaidDate() {
            return paidDate;
        }

        public void setPaidDate(Object paidDate) {
            this.paidDate = paidDate;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public List<Studentpayment> getStudentpayments() {
            return studentpayments;
        }

        public void setStudentpayments(List<Studentpayment> studentpayments) {
            this.studentpayments = studentpayments;
        }

    }

    public static class Course {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("course_name")
        @Expose
        private String courseName;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("duration_type")
        @Expose
        private String durationType;
        @SerializedName("teacher")
        @Expose
        private Object teacher;
        @SerializedName("coursefee")
        @Expose
        private String coursefee;
        @SerializedName("tax")
        @Expose
        private String tax;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("discountpara")
        @Expose
        private String discountpara;
        @SerializedName("discountamt")
        @Expose
        private String discountamt;
        @SerializedName("totalfee")
        @Expose
        private String totalfee;
        @SerializedName("imgurl")
        @Expose
        private Object imgurl;
        @SerializedName("deleted")
        @Expose
        private String deleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getDurationType() {
            return durationType;
        }

        public void setDurationType(String durationType) {
            this.durationType = durationType;
        }

        public Object getTeacher() {
            return teacher;
        }

        public void setTeacher(Object teacher) {
            this.teacher = teacher;
        }

        public String getCoursefee() {
            return coursefee;
        }

        public void setCoursefee(String coursefee) {
            this.coursefee = coursefee;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountpara() {
            return discountpara;
        }

        public void setDiscountpara(String discountpara) {
            this.discountpara = discountpara;
        }

        public String getDiscountamt() {
            return discountamt;
        }

        public void setDiscountamt(String discountamt) {
            this.discountamt = discountamt;
        }

        public String getTotalfee() {
            return totalfee;
        }

        public void setTotalfee(String totalfee) {
            this.totalfee = totalfee;
        }

        public Object getImgurl() {
            return imgurl;
        }

        public void setImgurl(Object imgurl) {
            this.imgurl = imgurl;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public static class User {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("fname")
        @Expose
        private String fname;
        @SerializedName("mname")
        @Expose
        private Object mname;
        @SerializedName("lname")
        @Expose
        private String lname;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("username")
        @Expose
        private Object username;
        @SerializedName("designation")
        @Expose
        private Object designation;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("mobile2")
        @Expose
        private Object mobile2;
        @SerializedName("whatsapp_no")
        @Expose
        private Object whatsappNo;
        @SerializedName("address")
        @Expose
        private Object address;
        @SerializedName("otp")
        @Expose
        private Object otp;
        @SerializedName("otp_expire")
        @Expose
        private Object otpExpire;
        @SerializedName("active")
        @Expose
        private String active;
        @SerializedName("user_types")
        @Expose
        private String userTypes;
        @SerializedName("is_deleted")
        @Expose
        private String isDeleted;
        @SerializedName("generate")
        @Expose
        private Object generate;
        @SerializedName("createdby")
        @Expose
        private Object createdby;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public Object getMname() {
            return mname;
        }

        public void setMname(Object mname) {
            this.mname = mname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public Object getDesignation() {
            return designation;
        }

        public void setDesignation(Object designation) {
            this.designation = designation;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMobile2() {
            return mobile2;
        }

        public void setMobile2(Object mobile2) {
            this.mobile2 = mobile2;
        }

        public Object getWhatsappNo() {
            return whatsappNo;
        }

        public void setWhatsappNo(Object whatsappNo) {
            this.whatsappNo = whatsappNo;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getOtp() {
            return otp;
        }

        public void setOtp(Object otp) {
            this.otp = otp;
        }

        public Object getOtpExpire() {
            return otpExpire;
        }

        public void setOtpExpire(Object otpExpire) {
            this.otpExpire = otpExpire;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getUserTypes() {
            return userTypes;
        }

        public void setUserTypes(String userTypes) {
            this.userTypes = userTypes;
        }

        public String getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(String isDeleted) {
            this.isDeleted = isDeleted;
        }

        public Object getGenerate() {
            return generate;
        }

        public void setGenerate(Object generate) {
            this.generate = generate;
        }

        public Object getCreatedby() {
            return createdby;
        }

        public void setCreatedby(Object createdby) {
            this.createdby = createdby;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }

    public class Batch {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("batchtype")
        @Expose
        private String batchtype;
        @SerializedName("course_id")
        @Expose
        private String courseId;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("start_date")
        @Expose
        private String startDate;
        @SerializedName("end_date")
        @Expose
        private String endDate;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("deleted")
        @Expose
        private String deleted;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("course")
        @Expose
        private Course_ course;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getBatchtype() {
            return batchtype;
        }

        public void setBatchtype(String batchtype) {
            this.batchtype = batchtype;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Course_ getCourse() {
            return course;
        }

        public void setCourse(Course_ course) {
            this.course = course;
        }

    }

    public class Studentbatch {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("student_id")
        @Expose
        private String studentId;
        @SerializedName("course_id")
        @Expose
        private String courseId;
        @SerializedName("batch_id")
        @Expose
        private String batchId;
        @SerializedName("who_assinged")
        @Expose
        private String whoAssinged;
        @SerializedName("created_at")
        @Expose
        private Object createdAt;
        @SerializedName("updated_at")
        @Expose
        private Object updatedAt;
        @SerializedName("batch")
        @Expose
        private Batch batch;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getWhoAssinged() {
            return whoAssinged;
        }

        public void setWhoAssinged(String whoAssinged) {
            this.whoAssinged = whoAssinged;
        }

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Batch getBatch() {
            return batch;
        }

        public void setBatch(Batch batch) {
            this.batch = batch;
        }

    }

    public class Course_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("course_name")
        @Expose
        private String courseName;
        @SerializedName("company_id")
        @Expose
        private String companyId;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("duration_type")
        @Expose
        private String durationType;
        @SerializedName("teacher")
        @Expose
        private Object teacher;
        @SerializedName("coursefee")
        @Expose
        private String coursefee;
        @SerializedName("tax")
        @Expose
        private String tax;
        @SerializedName("discount")
        @Expose
        private String discount;
        @SerializedName("discountpara")
        @Expose
        private String discountpara;
        @SerializedName("discountamt")
        @Expose
        private String discountamt;
        @SerializedName("totalfee")
        @Expose
        private String totalfee;
        @SerializedName("imgurl")
        @Expose
        private Object imgurl;
        @SerializedName("deleted")
        @Expose
        private String deleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getDurationType() {
            return durationType;
        }

        public void setDurationType(String durationType) {
            this.durationType = durationType;
        }

        public Object getTeacher() {
            return teacher;
        }

        public void setTeacher(Object teacher) {
            this.teacher = teacher;
        }

        public String getCoursefee() {
            return coursefee;
        }

        public void setCoursefee(String coursefee) {
            this.coursefee = coursefee;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscountpara() {
            return discountpara;
        }

        public void setDiscountpara(String discountpara) {
            this.discountpara = discountpara;
        }

        public String getDiscountamt() {
            return discountamt;
        }

        public void setDiscountamt(String discountamt) {
            this.discountamt = discountamt;
        }

        public String getTotalfee() {
            return totalfee;
        }

        public void setTotalfee(String totalfee) {
            this.totalfee = totalfee;
        }

        public Object getImgurl() {
            return imgurl;
        }

        public void setImgurl(Object imgurl) {
            this.imgurl = imgurl;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("registration_id")
    @Expose
    private String registrationId;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("mname")
    @Expose
    private String mname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("username")
    @Expose
    private Object username;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("altmobile")
    @Expose
    private Object altmobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("imgurl")
    @Expose
    private String imgurl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("date_adminssion")
    @Expose
    private String dateAdminssion;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("is_deleted")
    @Expose
    private String isDeleted;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("studentparents")
    private Studentparents studentparents;
    @SerializedName("studentcourses")
    private List<Studentcourse> studentcourses = null;
    @SerializedName("studentbatches")
    private List<Studentbatch> studentbatches = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getAltmobile() {
        return altmobile;
    }

    public void setAltmobile(Object altmobile) {
        this.altmobile = altmobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDateAdminssion() {
        return dateAdminssion;
    }

    public void setDateAdminssion(String dateAdminssion) {
        this.dateAdminssion = dateAdminssion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Studentparents getStudentparents() {
        return studentparents;
    }

    public void setStudentparents(Studentparents studentparents) {
        this.studentparents = studentparents;
    }

    public List<Studentcourse> getStudentcourses() {
        return studentcourses;
    }

    public List<Studentbatch> getStudentbatches() {
        return studentbatches;
    }

    public void setStudentbatches(List<Studentbatch> studentbatches) {
        this.studentbatches = studentbatches;
    }





}