package com.mycompany.getpost;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang.StringUtils;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL url = new URL("https://jsonplaceholder.typicode.com/photos");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();

        parameters.put("param1", "val");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());

        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();

        out.close();
//Adding headers to a request
        con.setRequestProperty("Content-Type", "application/json");
//To read the value of a header from a connection
        String contentType = con.getHeaderField("Content-Type");
//These values define the interval of time to wait for the connection to the server to be established or data to be available for reading.
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
//to read the cookies from a response, we can retrieve the value of the Set-Cookie header and parse it to a list of HttpCookie objects
        String cookiesHeader = con.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
//Next, we will add the cookies to the cookie store
        CookieManager cookieManager = new CookieManager();
        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
//Let’s check if a cookie called username is present, and if not, we will add it to the cookie store with a value of “john”:
        Optional<HttpCookie> usernameCookie = cookies.stream()
                .findAny().filter(cookie -> cookie.getName().equals("username"));
        if (usernameCookie == null) {
            cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
        }
//Finally, to add the cookies to the request, we need to set the Cookie header, after closing and reopening the connection:
        con.disconnect();
        con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Cookie", StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));
//We can enable or disable automatically following redirects for a specific connection by using the setInstanceFollowRedirects() method with true or false parameter:
        con.setInstanceFollowRedirects(false);
//It is also possible to enable or disable automatic redirect for all connections:
        HttpURLConnection.setFollowRedirects(false);

        int status = con.getResponseCode();

//By default, the behavior is enabled. When a request returns a status code 301 or 302, indicating a redirect, we can retrieve the Location header and create a new request to the new URL        
        if (status == HttpURLConnection.HTTP_MOVED_TEMP
                || status == HttpURLConnection.HTTP_MOVED_PERM) {
            String location = con.getHeaderField("Location");
            URL newUrl = new URL(location);
            con = (HttpURLConnection) newUrl.openConnection();
        }
//Finally, let’s read the response of the request and place it in a content String:
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println(inputLine);
//        int status = con.getResponseCode();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }
        
        
        
        
        
    }

}
