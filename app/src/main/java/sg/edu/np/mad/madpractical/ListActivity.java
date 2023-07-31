package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private final Object[][] data = {
            {"John Doe", "Software engineer from Seattle who loves hiking and photography", 1, true},
            {"Jane Smith", "Graphic designer from New York with a passion for painting and fashion", 2, false},
            {"Bob Johnson", "Freelance writer from Chicago who enjoys traveling and trying new foods", 3, true},
            {"Alice Williams", "Marketing manager from San Francisco with an interest in yoga and meditation", 4, false},
            {"David Brown", "Data analyst from Boston who likes playing basketball and reading books", 5, true},
            {"Emily Davis", "HR specialist from Austin who enjoys listening to music and going to concerts", 6, false},
            {"Michael Miller", "Sales representative from Miami with a love for fishing and boating", 7, true},
            {"Sarah Wilson", "Project manager from Denver who likes skiing and snowboarding in the winter", 8, false},
            {"Chris Taylor", "Web developer from Portland with a passion for cycling and rock climbing", 9, true},
            {"Laura Anderson", "Accountant from Atlanta who enjoys cooking and trying new recipes", 10, false},
            {"James Thomas", "Lawyer from Washington D.C. who likes playing golf and watching movies", 11, true},
            {"Elizabeth Jackson", "Teacher from Nashville who loves gardening and bird watching", 12, false},
            {"William White", "Architect from Los Angeles with an interest in history and architecture", 13, true},
            {"Sophia Harris", "Nurse from Philadelphia who enjoys volunteering and helping others", 14, false},
            {"Richard Martin", "Chef from New Orleans with a passion for creating new dishes and flavors", 15, true},
            {"Ava Thompson", "Photographer from Las Vegas who loves capturing moments and memories", 16, false},
            {"Joseph Garcia", "Musician from Memphis with a love for playing guitar and writing songs", 17, true},
            {"Lily Martinez", "Artist from San Diego who enjoys painting landscapes and seascapes", 18, false},
            {"George Robinson", "Journalist from Dallas with an interest in politics and current events", 19, true},
            {"Olivia Clark", "Fashion designer from Phoenix with a passion for creating unique and stylish clothing", 20, false}
    };

    private ArrayList<User> createUserArrayList(Object[][] data) {
        ArrayList<User> userList = new ArrayList<>();
        for (Object[] user : data) {
            User newUser = new User((String) user[0], (String) user[1], (int) user[2], (boolean) user[3]);
            userList.add(newUser);
        }

        return userList;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Creates a list of users from the data array
        ArrayList<User> userList = createUserArrayList(data);

        // Creates the recycler view and sets the adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listRecyclerView);
        PeopleAdapter peopleAdapter = new PeopleAdapter(userList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(peopleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Adds an event listener to messageGroupButton to start MessageActivity
        Button messageGroupButton = (Button) findViewById(R.id.messageGroupButton);
        messageGroupButton.setOnClickListener(v -> {
            Intent messageActivity = new Intent(this, MessageGroupActivity.class);
            startActivity(messageActivity);
        });
    }
}