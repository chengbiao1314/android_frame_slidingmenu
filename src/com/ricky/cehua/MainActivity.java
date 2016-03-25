package com.ricky.cehua;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.ricky.cehua.fragment.FragmentOne;
import com.ricky.cehua.fragment.FragmentThree;
import com.ricky.cehua.fragment.FragmentTwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends SlidingFragmentActivity{

	public static SlidingMenu sm;
	
	private FragmentOne myFragmentOne;
	private FragmentTwo myFragmentTwo;
	private FragmentThree myFragmentThree;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setBehindContentView(R.layout.sliding_left_framelayout);
		setContentView(R.layout.sliding_home_framelayout);
		
		sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setShadowDrawable(R.drawable.sliding_menu_shadow);
		sm.setShadowWidthRes(R.dimen.sliding_menu_shadow_width);
		sm.setBehindWidthRes(R.dimen.sliding_menu_width);
		
		if(myFragmentOne == null)
			myFragmentOne = new FragmentOne();
		switchFragment(myFragmentOne);
	}
	
	public static void mytoggle(){
		sm.toggle();
	}
	
	public void switchFragment(Fragment fragment) {
		mytoggle();
		getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
	}
	
	public void sliding_menu_click(View view){
		switch(view.getId()){
			case R.id.sliding_menu_one:
				if(myFragmentOne == null)
					myFragmentOne = new FragmentOne();
				switchFragment(myFragmentOne);
				Toast.makeText(this, "have running...", 0).show();
				break;
			case R.id.sliding_menu_two:
				if(myFragmentTwo == null)
					myFragmentTwo = new FragmentTwo();
				switchFragment(myFragmentTwo);
				Toast.makeText(this, "have running...", 0).show();
				break;
			case R.id.sliding_menu_three:
				if(myFragmentThree == null)
					myFragmentThree = new FragmentThree();
				switchFragment(myFragmentThree);
				Toast.makeText(this, "have running...", 0).show();
				break;
			}
		}

}
