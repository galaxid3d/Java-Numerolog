package com.mycompany.Numerolog;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.view.*;

public class Preferences extends Activity
{
	public static final String APP_PREFERENCES = "mysettings",APP_PREFERENCES_SIZE = "size",APP_PREFERENCES_R_F = "R_f",APP_PREFERENCES_G_F = "G_f",APP_PREFERENCES_B_F = "B_f",APP_PREFERENCES_IS_BOLD = "Is_bold",APP_PREFERENCES_IS_ITALIC = "Is_italic", APP_PREFERENCES_R_B = "R_b",APP_PREFERENCES_G_B = "G_b",APP_PREFERENCES_B_B = "B_b", APP_PREFERENCES_RADIUS_S = "radius_s",APP_PREFERENCES_DX_S = "Dx_s",APP_PREFERENCES_DY_S = "Dy_s",APP_PREFERENCES_A_S = "A_s",APP_PREFERENCES_R_S = "R_s",APP_PREFERENCES_G_S = "G_s",APP_PREFERENCES_B_S = "B_s",APP_PREFERENCES_IS_SAVE = "Is_save";
	
	private SharedPreferences mSettings;
	
	private boolean Is_bold,Is_italic,Is_save;
	private int R_f,G_f,B_f, R_b,G_b,B_b, radius_s,Dx_s,Dy_s,A_s,R_s,G_s,B_s;
	private float size;
	
	LinearLayout preferencesLinearLayout;
	TextView font_example;
	EditText R_bg,G_bg,B_bg, font_size, R_font,G_font,B_font, A_sh,R_sh,G_sh,B_sh,shadow_radius,shadow_Dx,shadow_Dy;
	CheckBox Is_bold_CB, Is_italic_CB,Is_save_CB;
	SeekBar R_font_SB,G_font_SB,B_font_SB, R_bg_SB,G_bg_SB,B_bg_SB, A_s_SB,R_s_SB,G_s_SB,B_s_SB;
	Button setFont;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.preferences);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		preferencesLinearLayout = (LinearLayout) findViewById(R.id.preferencesLinearLayout);
		R_font = (EditText) findViewById(R.id.R_font);
		G_font = (EditText) findViewById(R.id.G_font);
		B_font = (EditText) findViewById(R.id.B_font);
		R_font_SB = (SeekBar) findViewById(R.id.R_font_SB);
		G_font_SB = (SeekBar) findViewById(R.id.G_font_SB);
		B_font_SB = (SeekBar) findViewById(R.id.B_font_SB);
		font_example = (TextView) findViewById(R.id.font_example);
		font_size = (EditText) findViewById(R.id.font_size);
		Is_italic_CB = (CheckBox) findViewById(R.id.Is_italic_CB);
		Is_bold_CB = (CheckBox) findViewById(R.id.Is_bold_CB);Is_bold_CB.setChecked(true);
		R_bg = (EditText) findViewById(R.id.R_bg);
		G_bg = (EditText) findViewById(R.id.G_bg);
		B_bg = (EditText) findViewById(R.id.B_bg);
		R_bg_SB = (SeekBar) findViewById(R.id.R_bg_SB);
		G_bg_SB = (SeekBar) findViewById(R.id.G_bg_SB);
		B_bg_SB = (SeekBar) findViewById(R.id.B_bg_SB);
        setFont = (Button) findViewById(R.id.setFont);
        shadow_radius = (EditText) findViewById(R.id.shadow_radius);
		shadow_Dx = (EditText) findViewById(R.id.shadow_Dx);
		shadow_Dy = (EditText) findViewById(R.id.shadow_Dy);
		A_sh = (EditText) findViewById(R.id.A_sh);
		R_sh = (EditText) findViewById(R.id.R_sh);
		G_sh = (EditText) findViewById(R.id.G_sh);
		B_sh = (EditText) findViewById(R.id.B_sh);
		A_s_SB = (SeekBar) findViewById(R.id.A_s_SB);
		R_s_SB = (SeekBar) findViewById(R.id.R_s_SB);
		G_s_SB = (SeekBar) findViewById(R.id.G_s_SB);
		B_s_SB = (SeekBar) findViewById(R.id.B_s_SB);
		Is_save_CB= (CheckBox) findViewById(R.id.Is_save_CB);
		
		R_font_SB.setOnSeekBarChangeListener(seekBarChangeListener);  
		G_font_SB.setOnSeekBarChangeListener(seekBarChangeListener);
		B_font_SB.setOnSeekBarChangeListener(seekBarChangeListener);  

		R_bg_SB.setOnSeekBarChangeListener(seekBarChangeListener);  
		G_bg_SB.setOnSeekBarChangeListener(seekBarChangeListener);
		B_bg_SB.setOnSeekBarChangeListener(seekBarChangeListener);  
		
		A_s_SB.setOnSeekBarChangeListener(seekBarChangeListener); 
		R_s_SB.setOnSeekBarChangeListener(seekBarChangeListener);  
		G_s_SB.setOnSeekBarChangeListener(seekBarChangeListener);
		B_s_SB.setOnSeekBarChangeListener(seekBarChangeListener);  
	}
			
	private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() 
	{   
	    @Override  
	    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
		{    // TODO Auto-generated method stub
			if (seekBar==R_font_SB|seekBar==G_font_SB|seekBar==B_font_SB){ replaceFontColor(); }
			if (seekBar==R_bg_SB|seekBar==G_bg_SB|seekBar==B_bg_SB){ replaceBgColor(); }
			if (seekBar==A_s_SB|seekBar==R_s_SB|seekBar==G_s_SB|seekBar==B_s_SB){ replaceShadow(); }
		}
	    @Override  
	    public void onStartTrackingTouch(SeekBar seekBar)
		{    // TODO Auto-generated method stub
		}   
	    @Override   
	    public void onStopTrackingTouch(SeekBar seekBar)
		{   // TODO Auto-generated method stub  
		} 
	};

	private void replaceFontColor() {
		font_example.setTextColor(Color.rgb(R_font_SB.getProgress(),G_font_SB.getProgress(),B_font_SB.getProgress()));
		R_font.setText(String.valueOf(R_font_SB.getProgress()));
		G_font.setText(String.valueOf(G_font_SB.getProgress()));
		B_font.setText(String.valueOf(B_font_SB.getProgress())); }
	private void replaceBgColor() {
		R_bg.setText(String.valueOf(R_bg_SB.getProgress()));
		G_bg.setText(String.valueOf(G_bg_SB.getProgress()));
		B_bg.setText(String.valueOf(B_bg_SB.getProgress()));
		preferencesLinearLayout.setBackgroundColor(Color.rgb(R_bg_SB.getProgress(),G_bg_SB.getProgress(),B_bg_SB.getProgress()));  }
	private void replaceShadow() {
		A_sh.setText(String.valueOf(A_s_SB.getProgress()));
		R_sh.setText(String.valueOf(R_s_SB.getProgress()));
		G_sh.setText(String.valueOf(G_s_SB.getProgress()));
		B_sh.setText(String.valueOf(B_s_SB.getProgress()));
		font_example.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s_SB.getProgress(),R_s_SB.getProgress(),G_s_SB.getProgress(),B_s_SB.getProgress()));  }
			
	@Override
    protected void onResume() {
        super.onResume();
		 // Получаем число из настроек
			R_f = mSettings.getInt(APP_PREFERENCES_R_F, 0);
			  R_font.setText(Integer.toString(R_f));	
			G_f = mSettings.getInt(APP_PREFERENCES_G_F, 0);
			  G_font.setText(Integer.toString(G_f));	
			B_f = mSettings.getInt(APP_PREFERENCES_B_F, 0);
			  B_font.setText(Integer.toString(B_f));
		  setFontColor(setFont);  
 
            size = mSettings.getFloat(APP_PREFERENCES_SIZE, 16);
			  font_size.setText(Integer.toString((int) size));
			Is_bold = mSettings.getBoolean(APP_PREFERENCES_IS_BOLD, true);
              if (Is_bold) {Is_bold_CB.setChecked(true);}
			  else {Is_bold_CB.setChecked(false);}
			Is_italic = mSettings.getBoolean(APP_PREFERENCES_IS_ITALIC, false);
              if (Is_italic) {Is_italic_CB.setChecked(true);}
		      else {Is_italic_CB.setChecked(false);}
		  setFont(setFont);

			R_b = mSettings.getInt(APP_PREFERENCES_R_B, 255);
			  R_bg.setText(Integer.toString(R_b));	
			G_b = mSettings.getInt(APP_PREFERENCES_G_B, 255);
			  G_bg.setText(Integer.toString(G_b));	
			B_b = mSettings.getInt(APP_PREFERENCES_B_B, 255);
			  B_bg.setText(Integer.toString(B_b));
		  setBgColor(setFont);  
				
		    radius_s = mSettings.getInt(APP_PREFERENCES_RADIUS_S, 0);
		      shadow_radius.setText(Integer.toString(radius_s));
		    Dx_s = mSettings.getInt(APP_PREFERENCES_DX_S, 0);
		      shadow_Dx.setText(Integer.toString(Dx_s));
		    Dy_s= mSettings.getInt(APP_PREFERENCES_DY_S, 0);
		      shadow_Dy.setText(Integer.toString(Dy_s));	
		    A_s = mSettings.getInt(APP_PREFERENCES_A_S, 0);
		      A_sh.setText(Integer.toString(A_s));	
		    R_s = mSettings.getInt(APP_PREFERENCES_R_S, 0);
		      R_sh.setText(Integer.toString(R_s));	
		    G_s = mSettings.getInt(APP_PREFERENCES_G_S, 0);
		      G_sh.setText(Integer.toString(G_s));	
		    B_s = mSettings.getInt(APP_PREFERENCES_B_S, 0);
		      B_sh.setText(Integer.toString(B_s));
		  setShadow(setFont);
		  
		    Is_save = mSettings.getBoolean(APP_PREFERENCES_IS_SAVE, false);
		      if (Is_save) {Is_save_CB.setChecked(true);}
		      else {Is_save_CB.setChecked(false);}
    }

	@Override
    protected void onPause() {
        super.onPause();
         // Запоминаем данные
            SharedPreferences.Editor editor = mSettings.edit();
		    editor.putInt(APP_PREFERENCES_R_F, R_f);
		    editor.putInt(APP_PREFERENCES_G_F, G_f);
		    editor.putInt(APP_PREFERENCES_B_F, B_f);
            editor.putFloat(APP_PREFERENCES_SIZE, size);
     		editor.putBoolean(APP_PREFERENCES_IS_BOLD, Is_bold);
	    	editor.putBoolean(APP_PREFERENCES_IS_ITALIC, Is_italic);
	    	editor.putInt(APP_PREFERENCES_R_B, R_b);
	    	editor.putInt(APP_PREFERENCES_G_B, G_b);
	    	editor.putInt(APP_PREFERENCES_B_B, B_b);
		    editor.putInt(APP_PREFERENCES_RADIUS_S, radius_s);
	    	editor.putInt(APP_PREFERENCES_DX_S, Dx_s);
	    	editor.putInt(APP_PREFERENCES_DY_S, Dy_s);
		    editor.putInt(APP_PREFERENCES_A_S, A_s);
		    editor.putInt(APP_PREFERENCES_R_S, R_s);
	    	editor.putInt(APP_PREFERENCES_G_S, G_s);
	    	editor.putInt(APP_PREFERENCES_B_S, B_s);
		    editor.putBoolean(APP_PREFERENCES_IS_SAVE, Is_save);
	    	editor.apply();
    }
	
	
	public void setFontColor(View v)
	{
		if (R_font.getText().length()!=0)
		   { R_f=Integer.parseInt(R_font.getText().toString());
			 if (R_f>255) {R_f=255;}
			 if (R_f<0) {R_f=0;}  }
		if (G_font.getText().length()!=0)
		   { G_f=Integer.parseInt(G_font.getText().toString());
			 if (G_f>255) {G_f=255;}
			 if (G_f<0) {G_f=0;}  }
		if (B_font.getText().length()!=0)
		   { B_f=Integer.parseInt(B_font.getText().toString());
			 if (B_f>255) {B_f=255;}
			 if (B_f<0) {B_f=0;}  }
		R_font_SB.setProgress(R_f);G_font_SB.setProgress(G_f);B_font_SB.setProgress(B_f);
		R_font.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		G_font.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		B_font.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		R_bg.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		G_bg.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		B_bg.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		font_example.setTextColor(Color.rgb(R_f,G_f,B_f));
		font_size.setTextColor(Color.rgb(R_f,G_f,B_f));font_size.setHintTextColor(Color.argb(128,R_f,G_f,B_f));
		Is_bold_CB.setTextColor(Color.rgb(R_f,G_f,B_f));Is_italic_CB.setTextColor(Color.rgb(R_f,G_f,B_f));
		shadow_radius.setTextColor(Color.rgb(R_f,G_f,B_f));
		shadow_Dx.setTextColor(Color.rgb(R_f,G_f,B_f));shadow_Dy.setTextColor(Color.rgb(R_f,G_f,B_f));
		Is_save_CB.setTextColor(Color.rgb(R_f,G_f,B_f));
	}

	public void setFont(View v)
	{
		if (font_size.getText().length()!=0)
		   { size = Float.parseFloat(font_size.getText().toString()); }
	    int typeface = Typeface.NORMAL; 
		Is_bold=Is_bold_CB.isChecked();
		if (Is_bold)
		   { typeface+=Typeface.BOLD; }
		Is_italic=Is_italic_CB.isChecked();
		if (Is_italic)
		   { typeface+=Typeface.ITALIC; }
		font_example.setTextSize(size);font_example.setTypeface(Typeface.MONOSPACE,typeface);	
	}

	public void setBgColor(View v)
	{
		if (R_bg.getText().length()!=0)
		   { R_b=Integer.parseInt(R_bg.getText().toString());
			 if (R_b>255) {R_b=255;}
			 if (R_b<0) {R_b=0;}  }
		if (G_bg.getText().length()!=0)
		   { G_b=Integer.parseInt(G_bg.getText().toString());
			 if (G_b>255) {G_b=255;}
			 if (G_b<0) {G_b=0;}  }
		if (B_bg.getText().length()!=0)
		   { B_b=Integer.parseInt(B_bg.getText().toString());
			 if (B_b>255) {B_b=255;}
			 if (B_b<0) {B_b=0;}  }
		R_bg_SB.setProgress(R_b);G_bg_SB.setProgress(G_b);B_bg_SB.setProgress(B_b);
        preferencesLinearLayout.setBackgroundColor(Color.rgb(R_b,G_b,B_b));
	}
	
	public void setShadow(View v)
	{
		if (shadow_radius.getText().length()!=0)
		   { radius_s = Integer.parseInt(shadow_radius.getText().toString()); }
		if (shadow_Dx.getText().length()!=0)
		   { Dx_s = Integer.parseInt(shadow_Dx.getText().toString()); }
		if (shadow_Dy.getText().length()!=0)
		   { Dy_s = Integer.parseInt(shadow_Dy.getText().toString()); }
		if (A_sh.getText().length()!=0)
		   { A_s=Integer.parseInt(A_sh.getText().toString());
			 if (A_s>255) {A_s=255;}
			 if (A_s<0) {A_s=0;}  }
		if (R_sh.getText().length()!=0)
		   { R_s=Integer.parseInt(R_sh.getText().toString());
			 if (R_s>255) {R_s=255;}
			 if (R_s<0) {R_s=0;}  }
		if (G_sh.getText().length()!=0)
		   { G_s=Integer.parseInt(G_sh.getText().toString());
			 if (G_s>255) {G_s=255;}
			 if (G_s<0) {G_s=0;}  }
		if (B_sh.getText().length()!=0)
		   { B_s=Integer.parseInt(B_sh.getText().toString());
			 if (B_s>255) {B_s=255;}
			 if (B_s<0) {B_s=0;}  }
		A_s_SB.setProgress(A_s);R_s_SB.setProgress(R_s);G_s_SB.setProgress(G_s);B_s_SB.setProgress(B_s);
        font_example.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
	    font_size.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		Is_bold_CB.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		Is_italic_CB.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		shadow_radius.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		shadow_Dx.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));shadow_Dy.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		Is_save_CB.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
	}
	
	public void onClick_Is_save_CB(View v)
	{
		Is_save = Is_save_CB.isChecked();
	}
	
}
