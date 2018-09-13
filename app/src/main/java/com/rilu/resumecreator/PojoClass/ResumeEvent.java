package com.rilu.resumecreator.PojoClass;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ResumeEvent  implements Parcelable {
    private String institute;
    private String course;
    private String cgpa;
    private String year;
//    private Date fromDate;
//    private Date toDate;

    public ResumeEvent() {
    }

    public ResumeEvent(String institute, String course, String cgpa, String year) {
        this.institute = institute;
        this.course = course;
        this.cgpa = cgpa;
        this.year = year;
//        this.fromDate = fromDate;
//        this.toDate = toDate;
    }

    protected ResumeEvent(Parcel in) {
        institute = in.readString();
        course = in.readString();
        cgpa = in.readString();
        year = in.readString();
//        fromDate = (Date) in.readSerializable();
//        toDate = (Date) in.readSerializable();
    }

    public static final Creator<ResumeEvent> CREATOR = new Creator<ResumeEvent>() {
        @Override
        public ResumeEvent createFromParcel(Parcel in) {
            return new ResumeEvent(in);
        }

        @Override
        public ResumeEvent[] newArray(int size) {
            return new ResumeEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(institute);
        dest.writeString(course);
        dest.writeString(cgpa);
        dest.writeString(year);
//        dest.writeSerializable(fromDate);
//        dest.writeSerializable(toDate);
    }

    public ResumeEvent(ResumeEvent resumeEvent) {
        cloneThis(resumeEvent);
    }

    public void cloneThis(ResumeEvent resumeEvent) {
        this.institute = resumeEvent.institute;
        this.course = resumeEvent.course;
        this.cgpa = resumeEvent.cgpa;
        this.year = resumeEvent.year;
//        this.fromDate = resumeEvent.fromDate;
//        this.toDate = resumeEvent.toDate;
    }




    public String getTitle() { return institute; }

    public void setTitle(String title) {
        this.institute = title;
    }

    public String getDetail() {
        return course;
    }

    public void setDetail(String detail) {
        this.course = detail;
    }

    public String getSubtitle() {
        return cgpa;
    }

    public void setSubtitle(String subtitle) {
        this.cgpa = subtitle;
    }

    public String getPassYear() {
        return year;
    }

    public void setPassYear(String passYear) {
        this.year = passYear;
    }

//    public Date getFromDate() {
//        return fromDate;
//    }
//
//    public void setFromDate(Date fromDate) {
//        this.fromDate = fromDate;
//    }
//
//    public Date getToDate() {
//        return toDate;
//    }
//
//    public void setToDate(Date toDate) {
//        this.toDate = toDate;
//    }
}
