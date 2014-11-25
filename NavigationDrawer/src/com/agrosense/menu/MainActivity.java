package com.agrosense.menu;

import java.util.ArrayList;
import java.util.List;

import com.agrosense.graficos.FragmentThree;
import com.agrosense.graficos.clima;
import com.tutecentral.navigationdrawer.R;
import com.tutecentral.navigationdrawer.R.drawable;
import com.tutecentral.navigationdrawer.R.id;
import com.tutecentral.navigationdrawer.R.layout;
import com.tutecentral.navigationdrawer.R.menu;
import com.tutecentral.navigationdrawer.R.string;


import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
	public ArrayList<clima> Array_datos = new ArrayList<clima>();
	
	private String [] casanova = {"casanova","408BCFEB","408BD01A","408BCFCF","Hugo Casanova"};
	private String [] niceblue = {"niceblue","408BCFE1","408BCFF1","408BCFFE", "Nice Blue",};
	private String [] lastizas = {"lastizasoli","4099B451","408BCFD9","408BCFCA","Agricola Las Tizas"};
	private String [] donoso = {"donoso","4090C5A5","408BCFEA","408BD016", "Casa Donoso"};
	private String [] canepa = {"canepa","40681986","408BD029","408BD01C", "Canepa"};

	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		//se añaden los sitios
		dataList.add(new DrawerItem("Lab.Geospacial", R.drawable.ic_action_lab));
		dataList.add(new DrawerItem("Agricola Las Tizas", R.drawable.alastizas));
		dataList.add(new DrawerItem("Hugo Casanova", R.drawable.ic_action_casanova));
		dataList.add(new DrawerItem("Casa Donoso", R.drawable.ic_action_donoso));
		dataList.add(new DrawerItem("Nice Blue", R.drawable.niceblue));
		dataList.add(new DrawerItem("Canepa",R.drawable.canepa));
		
		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
		
		public void onDrawerClosed(View view) {
			getActionBar().setTitle(mTitle);
			invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
		}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			SelectItem(0);
		}

	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {
		case 0:
			fragment = new FragmentThree(casanova);
			break;
		case 1:
			fragment = new FragmentThree(lastizas);
			break;
		case 2:			
			fragment = new FragmentThree(casanova);
			break;
		case 3:
			fragment = new FragmentThree(donoso);
			break;
		case 4:
			fragment = new FragmentThree(niceblue);
			break;
		case 5:
			fragment = new FragmentThree(canepa);
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return false;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			SelectItem(position);

		}
	}

}
