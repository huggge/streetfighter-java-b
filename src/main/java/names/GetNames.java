package names;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.*;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetNames {
    String inline = "";
    List<NameList> nameList;

    public void getHTTP() {
        try {
            URL url = new URL("https://uinames.com/api/?amount=9&region=sweden");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();

            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()) {
                inline +=  input.nextLine();
            }
            input.close();

            Gson gson = new Gson();
//            Used to set type when deserializing to arraylist / list. Is not needed when deserializing a object with a nested arraylist in it.
            Type nameListType = new TypeToken<ArrayList<NameList>>(){}.getType();
            nameList = gson.fromJson(inline, nameListType);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<NameList> getNameList() {
        return nameList;
    }




}
