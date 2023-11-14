package com.example.androidrealestateproject;
import android.telephony.SmsManager;
import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SmsUtils {

    public static void sendSms(Context context, String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(context, "SMS sent successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Failed to send SMS", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
