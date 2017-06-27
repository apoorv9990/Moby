package com.moby.apply.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.moby.apply.MobiApplyApplication;
import com.moby.apply.R;
import com.moby.apply.presenters.RegistrationPresenter;
import com.moby.apply.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by patel on 6/26/2017.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationPresenter.RegistrationView{

    @BindView(R.id.edit_name)
    EditText nameEditText;

    @BindView(R.id.edit_email)
    EditText emailEditText;

    @BindView(R.id.edit_password)
    EditText passwordEditText;

    @BindView(R.id.edit_phone)
    EditText phoneEditText;

    @BindView(R.id.edit_summary)
    EditText summaryEditText;

    @BindView(R.id.links_parent_layout)
    LinearLayout linksParentLayout;

    @BindView(R.id.edit_add_link)
    EditText addLinkEditText;

    @BindView(R.id.button_add_link)
    Button addLinkButton;

    @Inject
    RegistrationPresenter mPresenter;

    private List<String> links;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        ((MobiApplyApplication)getApplication()).getCoreComponent().inject(this);
        mPresenter.attachView(this);
        setPresenter(mPresenter);
    }

    @OnClick(R.id.button_add_link)
    public void onAddLinkClicked() {

        if(StringUtils.isNullOrEmpty(addLinkEditText.getText().toString())) {
            Toast.makeText(this, "Please enter link", Toast.LENGTH_SHORT).show();
            return;
        }

        linksParentLayout.setVisibility(View.VISIBLE);

        if(links == null) {
            links = new ArrayList<>();
        }

        links.add(addLinkEditText.getText().toString());

        addLinkEditText();

        for(int index = 0; index < links.size(); index++) {
            ((EditText) linksParentLayout.getChildAt(index)).setText(links.get(index));
        }

        addLinkEditText.setText("");
    }

    public void addLinkEditText() {
        EditText linkEditText = new EditText(this);

        int mediumSpacing = getResources().getDimensionPixelSize(R.dimen.spacing_m);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = mediumSpacing;

        linkEditText.setLayoutParams(params);

        linkEditText.setPadding(mediumSpacing, mediumSpacing, mediumSpacing, mediumSpacing);
        linkEditText.setBackgroundResource(R.drawable.rounded_primary_border_view);
        linkEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        linkEditText.setImeOptions(EditorInfo.IME_ACTION_NEXT);

        linksParentLayout.addView(linkEditText);
    }
}
