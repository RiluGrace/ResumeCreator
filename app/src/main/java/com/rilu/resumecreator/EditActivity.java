package com.rilu.resumecreator;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.rilu.resumecreator.R;

import com.rilu.resumecreator.PojoClass.ResumeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "type";
    public static final String TYPE_PROJECT = "project";
    public static final String TYPE_EDUCATION = "education";
    public static final String TYPE_EXPERIENCE = "experience";

    private int id = -1;
    private String institute = "", course = "", cgpa = "", year = "";

    public static final String FIELD_ID = "id";
    public static final String FIELD_INSTITUTE = "institute";
    public static final String FIELD_COURSE = "course";
    public static final String FIELD_CGPA = "cgpa";
    public static final String FIELD_YEAR = "year";

    boolean subtitleEnabled = true;

   // @BindView(R.id.input_institute)
    EditText institute1;

   // @BindView(R.id.input_course)
    EditText course1;

 //   @BindView(R.id.input_cgpa)
    EditText cgpa1;

 //   @BindView(R.id.input_year)
    EditText year1;

    TextInputLayout institute2;
    TextInputLayout course2;
    TextInputLayout cgpa2;
    TextInputLayout year2;

    public static Intent setData(Intent intent, int id, ResumeEvent resumeEvent) {
        intent.putExtra(FIELD_ID, id);
        intent.putExtra(FIELD_INSTITUTE, resumeEvent.getTitle());
        intent.putExtra(FIELD_COURSE, resumeEvent.getDetail());
        intent.putExtra(FIELD_CGPA, resumeEvent.getSubtitle());
        intent.putExtra(FIELD_YEAR, resumeEvent.getPassYear());
        return intent;
    }

    public static Intent getProjectIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_PROJECT);
        return intent;
    }

    public static Intent getEducationIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_EDUCATION);
        return intent;
    }

    public static Intent getExperienceIntent(Context context) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_EXPERIENCE);
        return intent;
    }

    public static ResumeEvent getEvent(Intent intent) {
        String institute = intent.getStringExtra(FIELD_INSTITUTE);
        String course = intent.getStringExtra(FIELD_COURSE);
        String cgpa = intent.getStringExtra(FIELD_CGPA);
        String year = intent.getStringExtra(FIELD_YEAR);
        return new ResumeEvent(institute, course, cgpa, year);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        switch (intent.getStringExtra(EXTRA_TYPE)) {
            case TYPE_PROJECT:
            //    setContentView(R.layout.activity_edit_project);
                subtitleEnabled = false;
                getSupportActionBar().setTitle("Project");
                break;
            case TYPE_EDUCATION:
                setContentView(R.layout.activity_edit_education);
                getSupportActionBar().setTitle("Education");
                break;
            case TYPE_EXPERIENCE:
              //  setContentView(R.layout.activity_edit_experience);
                getSupportActionBar().setTitle("Experience");
                break;
        }
        institute1 = findViewById(R.id.input_institute);
        course1 = findViewById(R.id.input_course);
        cgpa1 = findViewById(R.id.input_cgpa);
        year1 = findViewById(R.id.input_year);
//
        institute2 = findViewById(R.id.input_layout_institute);
        course2 = findViewById(R.id.input_layout_course);
        cgpa2 = findViewById(R.id.input_layout_cgpa);
        year2 = findViewById(R.id.input_layout_year);



        institute1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                institute = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        course1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                course = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cgpa1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cgpa = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        year1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                year = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if (intent.hasExtra(FIELD_ID)) {
            id = intent.getIntExtra(FIELD_ID, -1);
            institute = intent.getStringExtra(FIELD_INSTITUTE);
            course = intent.getStringExtra(FIELD_COURSE);
            cgpa = intent.getStringExtra(FIELD_CGPA);
            year = intent.getStringExtra(FIELD_YEAR);
            institute1.setText(institute);
            course1.setText(course);
            cgpa1.setText(cgpa);
            year1.setText(year);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            if (validInput()) {
                setResult(RESULT_OK, getResultIntent());
                finish();
                return true;
            } else {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validInput() {
        boolean result = true;
        if (TextUtils.isEmpty(institute1.getText())) {
           institute2.setError("This field is required");
            result = false;
        }
        if (TextUtils.isEmpty(course1.getText())) {
           course2.setError("This field is required");
            result = false;
        }
        if (TextUtils.isEmpty(cgpa1.getText())) {
             cgpa2.setError("This field is required");
            result = false;
        }
        if (subtitleEnabled && TextUtils.isEmpty(year1.getText())) {
           year2.setError("This field is required");
            result = false;
        }
        return result;
    }

    private Intent getResultIntent() {
        Intent intent = new Intent();
        if (id != -1) {
            intent.putExtra(FIELD_ID, id);
        }
        intent.putExtra(FIELD_INSTITUTE, institute);
        intent.putExtra(FIELD_COURSE, course);
        intent.putExtra(FIELD_CGPA, cgpa);
        intent.putExtra(FIELD_YEAR, year);
        return intent;
    }
}



