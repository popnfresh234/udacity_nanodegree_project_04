package com.dmtaiwan.alexander.jokedisplaylibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeDisplayActivityFragment extends Fragment {

    public JokeDisplayActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_display, container, false);
        if (getActivity().getIntent() != null) {
            TextView jokeTextView = (TextView) rootView.findViewById(R.id.joke_text_view);
            jokeTextView.setText(getActivity().getIntent().getStringExtra(Utilities.JOKE));
        }
        return rootView;
    }
}
