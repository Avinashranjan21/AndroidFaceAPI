package avisoft.jsonparser;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {
    String[] values = new String[] { "Monday weather",
            "Tuesday weather",
            "Wednesday weather",
            "Thursday weather",
            "Friday weather",
            "Saturday weather",
            "Sunday weather",
            "Monday weather"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adpater = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,android.R.id.text1,values);
        mListView.setAdapter(adpater);

    }

    public class Data extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... voids) {
            return null;
        }
    }

    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }

}
