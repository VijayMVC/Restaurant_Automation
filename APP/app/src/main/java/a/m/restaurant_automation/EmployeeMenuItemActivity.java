package a.m.restaurant_automation;

import a.m.restaurant_automation.manager.MenuItemsFragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class EmployeeMenuItemActivity extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    TabItem appetizerItem, mainCourseItem, beverageItem, dessertItem;
    PagerAdapter pagerAdapter;
    public NavController navController;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu_item);

        floatingActionButton = findViewById(R.id.floatingButton_addMenuItem);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);

        appetizerItem = findViewById(R.id.appetizerItem);
        mainCourseItem = findViewById(R.id.mainCourseItem);
        beverageItem = findViewById(R.id.beverageItem);
        dessertItem = findViewById(R.id.dessertItem);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount());
        mViewPager.setAdapter(pagerAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        
        
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private class PagerAdapter extends FragmentPagerAdapter{
        private int tabNumber;

       public PagerAdapter(@NonNull FragmentManager fm,int behavior, int mTabs) {
           super(fm,behavior);
           this.tabNumber = mTabs;
       }

       @NonNull
       @Override
       public Fragment getItem(int position) {
           switch (position){
               case 0:
                   return new MenuItemsFragment(1);
               case 1:
                   return new MenuItemsFragment(2);
               case 2:
                   return new MenuItemsFragment(3);
               case 3:
                   return new MenuItemsFragment(4);

               default:
                   return null;

           }
       }

       @Override
       public int getCount() {
           return tabNumber;
       }
   }
}
