package com.alexfu.targetfragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alexfu on 9/1/13.
 */
public class TwoFragment extends Fragment implements View.OnClickListener {
  public static final String TAG = "com.alexfu.targetfragmentexample.TwoFragment";
  private String mId = "";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fragment target = getTargetFragment();
    if(target instanceof OneFragment) {
      mId = ((OneFragment) target).getCurrentId();
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_two, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    view.findViewById(R.id.button).setOnClickListener(this);
    TextView id = (TextView) view.findViewById(R.id.id);
    id.setText(getString(R.string.id, mId));
  }

  @Override
  public void onClick(View v) {
    getFragmentManager().popBackStack();
  }
}