package tv.savageboy74.usefulthings.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker
{
    public static void checkForUpdates() throws IOException
    {
        int currentVersion = Reference.UPDATE_NUMBER;
        int nextVersion = getNewest();

        if (currentVersion < nextVersion)
        {
            Reference.NEWVERSION = updatedVersion(nextVersion);
            Reference.OUTDATED = true;
        }
        else
        {
            Reference.OUTDATED = false;
        }
    }

    //Update Number, Each Update Requires A New Number. PasteBin: Reference: UPDATE_NUMBER
    public static int getNewest() throws IOException
    {
        URL url = new URL("https://raw.githubusercontent.com/savageboy74/usefulthings/master/UpdateNumber.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();

        while ((line = br.readLine()) != null)
        {
            response.append(line);

        }
        br.close();

        return Integer.parseInt(response.toString());
    }

    //This is the newest version. PasteBin: Reference: NEW_VERSION Keep Updated With The Current Version
    private static String updatedVersion(int version) throws IOException
    {
        URL url = new URL("https://raw.githubusercontent.com/savageboy74/usefulthings/master/NewestVersion.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();

        while ((line = br.readLine()) != null)
        {
            response.append(line);

        }
        br.close();

        return response.toString();
    }
}
