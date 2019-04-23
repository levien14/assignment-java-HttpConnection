import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnDemo {

    public static void main(String [] args)
    {
        try
        {
            URL url = new URL("https://www.w3schools.com/js/json_demo_array.txt");//"https://www.w3schools.com/js/json_demo_array.txt"
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                //day la downcasting
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("Please enter an HTTP URL.");
                return;
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
