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
        return getInstitute();
    }

    public void setInstitute(String institute) {
        setInstitute(institute);
    }

    public String getCourse() {
        return getCourse();
    }

    public void setCourse(String course) {
        setCourse(course);
    }

    public String getCgpa() { return getCgpa(); }

    public void setCgpa(String cgpa) {
        setCgpa(cgpa);
    }

    public String getYear() {
        return getYear();
    }

    public void setYear(String year) {
        setCourse(year);
    }

}
