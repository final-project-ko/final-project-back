package com.ohgiraffers.finalproject.QNA.dto;



import java.time.LocalDate;

public class QnADTO {

    private int inquiryCode;
    private String inquiryTitle;
    private String inquiryContent;
    private LocalDate inquiryDate;
    private String userId;
    private String inquiryReply;
    private String replyText;

    public QnADTO() {
    }

    public QnADTO(int inquiryCode, String inquiryTitle, String inquiryContent, LocalDate inquiryDate, String userCode, String inquiryReply, String replyText) {
        this.inquiryCode = inquiryCode;
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
        this.inquiryDate = inquiryDate;
        this.userId = userCode;
        this.inquiryReply = inquiryReply;
        this.replyText = replyText;
    }

    public int getInquiryCode() {
        return inquiryCode;
    }

    public void setInquiryCode(int inquiryCode) {
        this.inquiryCode = inquiryCode;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(String inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInquiryReply() {
        return inquiryReply;
    }

    public void setInquiryReply(String inquiryReply) {
        this.inquiryReply = inquiryReply;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    @Override
    public String toString() {
        return "QnADTO{" +
                "inquiryCode=" + inquiryCode +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryContent='" + inquiryContent + '\'' +
                ", inquiryDate=" + inquiryDate +
                ", userCode=" + userId +
                ", inquiryReply='" + inquiryReply + '\'' +
                ", replyText='" + replyText + '\'' +
                '}';
    }
}
