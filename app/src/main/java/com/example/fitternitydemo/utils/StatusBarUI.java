package com.example.fitternitydemo.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

import com.example.fitternitydemo.R;


public class StatusBarUI {

	public static void makeStatusBarUsable(Window window) {
		window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
	}
	
	public static void setLightStatusBarIcon(Window window) {
		window.getDecorView().setSystemUiVisibility(0);
	}

    public static void setDarkStatusBarIcon(Window window) {
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public static void setStatuBarColor(Window window, int statusBarColor){
	    if(isDark(statusBarColor)){
	        setDarkStatusBar(window, statusBarColor);
        }else{
	        setLightStatusBar(window, statusBarColor);
        }
    }

    public static void setDarkStatusBar(Window window, int statusBarDarkColor) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setLightStatusBarIcon(window);
			window.setStatusBarColor(statusBarDarkColor);
		}
	}
	
	public static void setLightStatusBar(Window window, int statusBarLightColor) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		    setDarkStatusBarIcon(window);
			window.setStatusBarColor(statusBarLightColor);
		}
	}

  public static int getStatusBarHeight(final Context context) {
    final Resources resources = context.getResources();
    final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0)
      return resources.getDimensionPixelSize(resourceId);
    else
      return (int) Math.ceil((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? 24 : 25) * resources.getDisplayMetrics().density);
  }
	
	public static void setTranslucentStatusBar(Window window) {
		if (window == null) return;
		int sdkInt = Build.VERSION.SDK_INT;
		if (sdkInt >= Build.VERSION_CODES.LOLLIPOP) {
			setTranslucentStatusBarLollipop(window);
		} else if (sdkInt >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatusBarKiKat(window);
		}
	}
	
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private static void setTranslucentStatusBarLollipop(Window window) {
		window.setStatusBarColor(ContextCompat.getColor(window.getContext(), R.color.red));
	}
	
	@TargetApi(Build.VERSION_CODES.KITKAT)
	private static void setTranslucentStatusBarKiKat(Window window) {
		window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	}
	
	public static boolean isColorDark(int color) {
		double darkness =
				1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
		return !(darkness < 0.5);
	}
	
	private static boolean isDark(int color) {
		return ColorUtils.calculateLuminance(color) < 0.5;
	}
	
}