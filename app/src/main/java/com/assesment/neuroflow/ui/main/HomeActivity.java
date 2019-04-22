package com.assesment.neuroflow.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.assesment.neuroflow.R;
import com.assesment.neuroflow.data.User;
import com.assesment.neuroflow.ui.main.fragments.AllUsersFragment;
import com.assesment.neuroflow.ui.main.fragments.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private User user;
    private List<User> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appbar);
        viewPager = findViewById(R.id.viewPager);
        loadData();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllUsersFragment().newInstance(usersList), "All Users" );

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void loadData(){


        user = new User("Ryan", 63, Long.valueOf("1546341851000"));
        int imageId = getResourceId(this, "ryan", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('m');
        usersList.add(user);

        user = new User("Melissa", 91, Long.valueOf("1540341851000"));
        imageId = getResourceId(this, "mels", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('f');
        usersList.add(user);

        user = new User("Sam", 86, Long.valueOf("1536442851000"));
        imageId = getResourceId(this, "sam", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('m');
        usersList.add(user);

        user = new User("Joey", 78, Long.valueOf("1546442992000"));
        imageId = getResourceId(this, "joey", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('m');
        usersList.add(user);

        user = new User("Jess", 93, Long.valueOf("1540341751000"));
        imageId = getResourceId(this, "jess", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('f');
        usersList.add(user);

        user = new User("Carly", 89, Long.valueOf("1540341651000") );
        imageId = getResourceId(this, "carly", "drawable", getPackageName());
        user.setImage(imageId);
        user.setGender('f');
        usersList.add(user);
    }

    public static int getResourceId(Context context, String varName, String resourceName, String packageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(varName, resourceName, packageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }
}
