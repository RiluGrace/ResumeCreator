package com.rilu.resumecreator.PojoClass;

import android.os.Parcel;

public class Education extends ResumeEvent {
    public Education() {
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(new ResumeEvent(in));
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public Education(ResumeEvent event) {
        super(event);
    }


    public String getInstitute() {
        return getTitle();
    }

    public void setInstitute(String school) {
        setTitle(school);
    }

    public String getCourse() {
        return getDetail();
    }

    public void setCourse(String location) {
        setDetail(location);
    }

    public String getCgpa() {
        return getSubtitle();
    }

    public void setCgpa(String degree) {
        setSubtitle(degree);
    }

    public String getYear() {
        return getPassYear();
    }

    public void setYear(String year) {
        setPassYear(year);
    }

}
