package com.rilu.resumecreator.PojoClass;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Resume  implements Parcelable {

    public PersonalInfo personalInfo;
    public List<Education> education;
//    public List<School> schools;
//    public List<Experience> experience;
    public String languages;
    public String skills;

    private Resume() {

    }

    protected Resume(Parcel in) {
        personalInfo = in.readParcelable(PersonalInfo.class.getClassLoader());
        education = in.createTypedArrayList(Education.CREATOR);
//        schools = in.createTypedArrayList(School.CREATOR);
//        experience = in.createTypedArrayList(Experience.CREATOR);
        languages = in.readString();
        skills = in.readString();
    }

    public static final Parcelable.Creator<Resume> CREATOR = new Parcelable.Creator<Resume>() {
        @Override
        public Resume createFromParcel(Parcel in) {
            return new Resume(in);
        }

        @Override
        public Resume[] newArray(int size) {
            return new Resume[size];
        }
    };

    static public Resume createNewResume() {
        Resume resume = new Resume();
        resume.personalInfo = new PersonalInfo();
        resume.education = new ArrayList<>();
//        resume.experience = new ArrayList<>();
//        resume.projects = new ArrayList<>();
        resume.languages = "";
        resume.skills = "";
        return resume;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(personalInfo, flags);
        dest.writeTypedList(education);
//        dest.writeTypedList(schools);
//        dest.writeTypedList(experience);
        dest.writeString(languages);
        dest.writeString(skills);
    }
}
