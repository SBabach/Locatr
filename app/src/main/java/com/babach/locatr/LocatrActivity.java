package com.babach.locatr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class LocatrActivity extends SingleFragmentActivity
{
    private static final int REQUES_ERROR = 0;

    @Override
    protected Fragment createFragment()
    {
        return LocatrFragment.newInstance();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int errorCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (errorCode != ConnectionResult.SUCCESS)
        {
            Dialog errorDialog = apiAvailability.getErrorDialog(this, errorCode, REQUES_ERROR,
                    new DialogInterface.OnCancelListener()
                    {
                        @Override
                        public void onCancel(DialogInterface dialogInterface)
                        {
                            finish();
                        }
                    });
            errorDialog.show();
        }
    }
}
