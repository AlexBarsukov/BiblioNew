package com.work.retailapp.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.work.retailapp.R;
import com.work.retailapp.util.Utils;
import com.work.retailapp.util.Utils.AnimationType;
import com.work.retailapp.view.activities.ECartHomeActivity;

// TODO: Auto-generated Javadoc

/**
 * Fragment that appears in the "content_frame", shows a animal.
 */
public class ContactUsFragment extends Fragment {

    private Toolbar mToolbar;

    /**
     * Instantiates a new settings fragment.
     */
    public ContactUsFragment() {
        // Empty constructor required for fragment subclasses
    }

    public static Fragment newInstance() {
        // TODO Auto-generated method stub
        return new ContactUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_about, container,
                false);

        getActivity().setTitle("Contact Us");


        mToolbar = (Toolbar) rootView.findViewById(R.id.htab_toolbar);
        if (mToolbar != null) {
            ((ECartHomeActivity) getActivity()).setSupportActionBar(mToolbar);
        }

        if (mToolbar != null) {
            ((ECartHomeActivity) getActivity()).getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(true);

            mToolbar.setNavigationIcon(R.drawable.ic_drawer);

        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ECartHomeActivity) getActivity()).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });

        mToolbar.setTitleTextColor(Color.WHITE);

        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    Utils.switchContent(R.id.frag_container,
                            Utils.HOME_FRAGMENT,
                            ((ECartHomeActivity) (getContext())),
                            AnimationType.SLIDE_UP);

                }
                return true;
            }
        });

        rootView.findViewById(R.id.email).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        final Intent emailIntent = new Intent(
                                android.content.Intent.ACTION_SEND);
                        emailIntent.setType("text/plain");
                        emailIntent
                                .putExtra(
                                        android.content.Intent.EXTRA_EMAIL,
                                        new String[]{"mymail@gmail.com"});
                        emailIntent.putExtra(
                                android.content.Intent.EXTRA_SUBJECT,
                                "Hello There");
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                                "Add Message here");

                        emailIntent.setType("message/rfc822");

                        try {
                            startActivity(Intent.createChooser(emailIntent,
                                    "Send email using..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getActivity(),
                                    "No email clients installed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        return rootView;
    }
}
