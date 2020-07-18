package com.demoPurpose.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.demoPurpose.R;
import com.demoPurpose.common.ICallback;
import com.demoPurpose.fragment.AccountFragment;
import com.demoPurpose.fragment.HelpCenterFragment;
import com.demoPurpose.fragment.HomeFragment;
import com.demoPurpose.fragment.NotificationFragment;
import com.demoPurpose.fragment.PrivacyFragment;
import com.demoPurpose.fragment.ProfileFragment;
import com.demoPurpose.fragment.SavedPagesFragment;
import com.demoPurpose.fragment.SearchFragment;
import com.demoPurpose.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView;

public class HomePageActivity extends SuperAppCompatActivity implements ICallback, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        showHomeFragment();
    }

    @Override
    public void setupControlReferences() {

    }

    @Override
    public void attachEventListeners() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_setting:
                showSettingsFragment();
                break;
            case R.id.nav_help_center:
                showHelpCenterFragment();
                break;
            case R.id.nav_saved_pages:
                showSavedPagesFragment();
                break;
            case R.id.nav_setting_and_privacy:
                showSettingsAndPrivacyFragment();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private OnNavigationItemSelectedListener onNavigationItemSelectedListener = new OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    showHomeFragment();
                    break;
                case R.id.bottom_search:
                    showSearchFragment();
                    break;
                case R.id.bottom_notification:
                    showNotificationFragment();
                    break;
                case R.id.bottom_account:
                    showAccountFragment();
                    break;
            }
            return true;
        }
    };

    /**
     * Displaying home fragment
     */
    private void showHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        Fragment fragment = homeFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying home fragment
     */
    private void showSettingsFragment() {
        SettingsFragment settingsFragment = SettingsFragment.newInstance();
        Fragment fragment = settingsFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying saved pages fragment
     */
    private void showSavedPagesFragment() {
        SavedPagesFragment savedPagesFragment = SavedPagesFragment.newInstance();
        Fragment fragment = savedPagesFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying Setting and privacy fragment
     */
    private void showSettingsAndPrivacyFragment() {
        PrivacyFragment privacyFragment = PrivacyFragment.newInstance();
        Fragment fragment = privacyFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying home fragment
     */
    private void showHelpCenterFragment() {
        HelpCenterFragment helpCenterFragment = HelpCenterFragment.newInstance();
        Fragment fragment = helpCenterFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }


    /**
     * Displaying home fragment
     */
    private void showProfileFragment() {
        ProfileFragment profileFragment = ProfileFragment.newInstance();
        Fragment fragment = profileFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying Search fragment
     */
    private void showSearchFragment() {
        SearchFragment searchFragment = SearchFragment.newInstance();
        Fragment fragment = searchFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying Notification fragment
     */
    private void showNotificationFragment() {
        NotificationFragment notificationFragment = NotificationFragment.newInstance();
        Fragment fragment = notificationFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }

    /**
     * Displaying Account fragment
     */
    private void showAccountFragment() {
        AccountFragment accountFragment = AccountFragment.newInstance();
        Fragment fragment = accountFragment;
        showFragmentWithoutAddToBackStack(R.id.nav_host_fragment, fragment);
    }
}