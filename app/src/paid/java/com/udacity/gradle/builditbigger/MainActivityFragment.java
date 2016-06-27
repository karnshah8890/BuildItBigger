package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btnFetchJoke = (Button) getView().findViewById(R.id.btn_tell_joke);
// Register the onClick listener with the implementation above
        btnFetchJoke.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressbar);
                progressBar.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).tellJoke(progressBar);
            }
        });

    }
}
