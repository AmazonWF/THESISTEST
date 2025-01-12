package com.ulan.timetable.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;


public class BrowserUtil {
    public static void openUrlInChromeCustomTab(Context context, String url) {
        try {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent.launchUrl(context, url.contains("https://ismis.bisu.edu.ph/login") ? Uri.parse(url) : Uri.parse("https://ismis.bisu.edu.ph/login" + url));
        } catch (ActivityNotFoundException e) {
            // might not available.
            //openUrlLinkInWebView(context, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
