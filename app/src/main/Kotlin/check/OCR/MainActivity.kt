package check.OCR

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import check.hmsOCR.hms.constants.Constants

/**
 * Activity 入口 在kotlin中写
 */
class MainActivity : ComponentActivity(){


    private val APP_PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main)
//        获取权限
        requestPermission(APP_PERMISSIONS)
    }
    fun requestPermission(permission: Array<String>){
        if (!hasPermissions(this, *permission)) {
            ActivityCompat.requestPermissions(
                this,
                permission!!,
                Constants.REQUEST_PERMISSIONS_CODE
            )
        }
    }

    private fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}