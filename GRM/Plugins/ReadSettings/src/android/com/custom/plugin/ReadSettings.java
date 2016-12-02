package com.custom.plugin;
import android.os.Build;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.Settings.Global;
import android.provider.Settings;

/**
 * This class echoes a string called from JavaScript.
 */
public class ReadSettings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("readDateAndTime")) {
            this.readDateAndTime(callbackContext);
            return true;
        }
        return false;
    }
    
    //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void readDateAndTime(CallbackContext callbackContext) 
	{    
		try
		{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if( Global.getInt(this.cordova.getActivity().getContentResolver(), Global.AUTO_TIME) == 1 &&
                        Global.getInt(this.cordova.getActivity().getContentResolver(), Global.AUTO_TIME_ZONE) == 1
                        )
                {
                    callbackContext.success("SI");
                }
                else
                {
                    callbackContext.success("NO");
                }
            }else
            {
                if(Settings.System.getInt(this.cordova.getActivity().getContentResolver(), Settings.System.AUTO_TIME) == 1 &&
                        Settings.System.getInt(this.cordova.getActivity().getContentResolver(), Settings.System.AUTO_TIME_ZONE) == 1 )
                {
                    callbackContext.success("SI");
                }
                else
                {
                    callbackContext.success("NO");
                }
            }  	
        }
		catch(Exception ex)
		{
			callbackContext.error("ERROR");
		}
    }
}
