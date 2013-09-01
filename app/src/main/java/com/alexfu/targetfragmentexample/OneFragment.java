package com.alexfu.targetfragmentexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by alexfu on 9/1/13.
 */
public class OneFragment extends Fragment implements View.OnClickListener {
  public static final String TAG = "com.alexfu.targetfragmentexample.OneFragment";
  private static final Random RAND = new Random(2048);
  private static final String[] POSTFIX = new String[]{"A", "B"};

  private String mCurrentId = "";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int randomInt = generateRandomInt();
    mCurrentId = randomInt + POSTFIX[randomInt%2];
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_one, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    view.findViewById(R.id.button).setOnClickListener(this);
    TextView id = (TextView) view.findViewById(R.id.id);
    id.setText(getString(R.string.id, mCurrentId));
  }

  @Override
  public void onClick(View v) {
    Fragment fragment = new TwoFragment();
    fragment.setTargetFragment(this, -1);

    getFragmentManager()
        .beginTransaction()
        .replace(R.id.frame, fragment, TwoFragment.TAG)
        .addToBackStack(null)
        .commit();
  }

  private int generateRandomInt() {
    return Math.abs(RAND.nextInt());
  }

  public String getCurrentId() {
    return mCurrentId;
  }
}