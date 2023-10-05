package com.mycompany.Numerolog;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.inputmethod.*;
import android.content.*;
import android.graphics.*;
import java.io.*;
public class MainActivity extends Activity 
{
	public static final String APP_PREFERENCES = "mysettings",APP_PREFERENCES_SIZE = "size",APP_PREFERENCES_R_F = "R_f",APP_PREFERENCES_G_F = "G_f",APP_PREFERENCES_B_F = "B_f",APP_PREFERENCES_IS_BOLD = "Is_bold",APP_PREFERENCES_IS_ITALIC = "Is_italic", APP_PREFERENCES_R_B = "R_b",APP_PREFERENCES_G_B = "G_b",APP_PREFERENCES_B_B = "B_b", APP_PREFERENCES_RADIUS_S = "radius_s",APP_PREFERENCES_DX_S = "Dx_s",APP_PREFERENCES_DY_S = "Dy_s",APP_PREFERENCES_A_S = "A_s",APP_PREFERENCES_R_S = "R_s",APP_PREFERENCES_G_S = "G_s",APP_PREFERENCES_B_S = "B_s",APP_PREFERENCES_IS_SAVE = "Is_save";
	
    private SharedPreferences mSettings;
	
	private boolean Is_bold,Is_italic,Is_save;
	private int R_f,G_f,B_f, R_b,G_b,B_b, radius_s,Dx_s,Dy_s,A_s,R_s,G_s,B_s;
	private float size;
	
	EditText fam_input, imya_input, otchstv_input, day_input, mes_input, god_input;
	TextView Input_Data, Capture_Data, txtv0,txtv0_1,txtv0_2,txtv0_3,txtv0_4,txtv0_5,txtv1,txtv2,txtv3,txtv4,txtv5,txtv6,txtv7,txtv7_1,txtv7_2,txtv7_3,txtv8,txtv8_1,txtv8_2,txtv8_3,txtv8_4,txtv9,txtv9_1,txtv9_2,txtv9_3,txtv9_4,txtv10,txtv_day;
	Button Input_all,day_of_week_B;
	LinearLayout generalLinearLayout;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		
		fam_input = (EditText) findViewById(R.id.fam);
		imya_input = (EditText) findViewById(R.id.imya);
		otchstv_input = (EditText) findViewById(R.id.otchstv);
		day_input = (EditText) findViewById(R.id.day);
		mes_input = (EditText) findViewById(R.id.mes);
		god_input = (EditText) findViewById(R.id.god);
		Input_all = (Button) findViewById(R.id.Input_all);
		Input_Data = (TextView) findViewById(R.id.Input_Data);
		Capture_Data = (TextView) findViewById(R.id.Capture_Data);
		txtv0 = (TextView) findViewById(R.id.txtv0);
		txtv0_1 = (TextView) findViewById(R.id.txtv0_1);
		txtv0_2 = (TextView) findViewById(R.id.txtv0_2);
		txtv0_3 = (TextView) findViewById(R.id.txtv0_3);
		txtv0_4 = (TextView) findViewById(R.id.txtv0_4);
		txtv0_5 = (TextView) findViewById(R.id.txtv0_5);
		txtv1 = (TextView) findViewById(R.id.txtv1);
		txtv2 = (TextView) findViewById(R.id.txtv2);
		txtv3 = (TextView) findViewById(R.id.txtv3);
		txtv4 = (TextView) findViewById(R.id.txtv4);
		txtv5 = (TextView) findViewById(R.id.txtv5);
		txtv6 = (TextView) findViewById(R.id.txtv6);
		txtv7 = (TextView) findViewById(R.id.txtv7);
		txtv7_1 = (TextView) findViewById(R.id.txtv7_1);
		txtv7_2 = (TextView) findViewById(R.id.txtv7_2);
		txtv7_3 = (TextView) findViewById(R.id.txtv7_3);
		txtv8 = (TextView) findViewById(R.id.txtv8);
		txtv8_1 = (TextView) findViewById(R.id.txtv8_1);
		txtv8_2 = (TextView) findViewById(R.id.txtv8_2);
		txtv8_3 = (TextView) findViewById(R.id.txtv8_3);
		txtv8_4 = (TextView) findViewById(R.id.txtv8_4);
		txtv9 = (TextView) findViewById(R.id.txtv9);
		txtv9_1 = (TextView) findViewById(R.id.txtv9_1);
		txtv9_2 = (TextView) findViewById(R.id.txtv9_2);
		txtv9_3 = (TextView) findViewById(R.id.txtv9_3);
		txtv9_4 = (TextView) findViewById(R.id.txtv9_4);
		txtv10 = (TextView) findViewById(R.id.txtv10);
		day_of_week_B = (Button) findViewById(R.id.day_of_week_B);day_of_week_B.setVisibility(100); //прячем эту кнопку,т.к. на ней написан день недели рождения,а мы его не знаем до ввода чисел
		txtv_day= (TextView) findViewById(R.id.txtv_day);
		generalLinearLayout=(LinearLayout)findViewById(R.id.generalLinearLayout);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent = new Intent(this,Preferences.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	
	
    @Override
    protected void onResume() {
        super.onResume();
		  R_f = mSettings.getInt(APP_PREFERENCES_R_F, 0); //если такой ключ есть ("APP_PREFERENCES_R_F"), то записываем в переменную его значение,а если нет-то второе значение("0")
		  G_f = mSettings.getInt(APP_PREFERENCES_G_F, 0);
		  B_f = mSettings.getInt(APP_PREFERENCES_B_F, 0);
		  radius_s = mSettings.getInt(APP_PREFERENCES_RADIUS_S, 0);
		  Dx_s = mSettings.getInt(APP_PREFERENCES_DX_S, 0);
		  Dy_s= mSettings.getInt(APP_PREFERENCES_DY_S, 0);
		  A_s = mSettings.getInt(APP_PREFERENCES_A_S, 0);	
		  R_s = mSettings.getInt(APP_PREFERENCES_R_S, 0);	
		  G_s = mSettings.getInt(APP_PREFERENCES_G_S, 0);
		  B_s = mSettings.getInt(APP_PREFERENCES_B_S, 0);
		setFontColor(Input_all);
          size = mSettings.getFloat(APP_PREFERENCES_SIZE, 16);
	  	  Is_bold = mSettings.getBoolean(APP_PREFERENCES_IS_BOLD, true);
          Is_italic = mSettings.getBoolean(APP_PREFERENCES_IS_ITALIC, false);
        setFont(Input_all);
	      R_b = mSettings.getInt(APP_PREFERENCES_R_B, 255);
		  G_b = mSettings.getInt(APP_PREFERENCES_G_B, 255);
		  B_b = mSettings.getInt(APP_PREFERENCES_B_B, 255);
		setBgColor(Input_all);
		  Is_save = mSettings.getBoolean(APP_PREFERENCES_IS_SAVE, false);
    }

	
	static int[] tabl(String str)
	{
		int[] a=new int[str.length()];
		for (int i=0;i<str.length();i++)
		{
			if (str.charAt(i)=='а'||str.charAt(i)=='й'||str.charAt(i)=='т'||str.charAt(i)=='ы'||str.charAt(i)=='a'||str.charAt(i)=='j'||str.charAt(i)=='s')
			{a[i]=1;}
			if (str.charAt(i)=='б'||str.charAt(i)=='к'||str.charAt(i)=='у'||str.charAt(i)=='ь'||str.charAt(i)=='b'||str.charAt(i)=='k'||str.charAt(i)=='t')
			{a[i]=2;}
			if (str.charAt(i)=='в'||str.charAt(i)=='л'||str.charAt(i)=='ф'||str.charAt(i)=='э'||str.charAt(i)=='c'||str.charAt(i)=='l'||str.charAt(i)=='u')
			{a[i]=3;}
			if (str.charAt(i)=='г'||str.charAt(i)=='м'||str.charAt(i)=='х'||str.charAt(i)=='ю'||str.charAt(i)=='d'||str.charAt(i)=='m'||str.charAt(i)=='v')
			{a[i]=4;}
			if (str.charAt(i)=='д'||str.charAt(i)=='н'||str.charAt(i)=='ц'||str.charAt(i)=='я'||str.charAt(i)=='e'||str.charAt(i)=='n'||str.charAt(i)=='w')
			{a[i]=5;}
			if (str.charAt(i)=='е'||str.charAt(i)=='ё'||str.charAt(i)=='о'||str.charAt(i)=='ч'||str.charAt(i)=='f'||str.charAt(i)=='o'||str.charAt(i)=='x')
			{a[i]=6;}
			if (str.charAt(i)=='ж'||str.charAt(i)=='п'||str.charAt(i)=='ш'||str.charAt(i)=='g'||str.charAt(i)=='p'||str.charAt(i)=='y')
			{a[i]=7;}
			if (str.charAt(i)=='з'||str.charAt(i)=='р'||str.charAt(i)=='щ'||str.charAt(i)=='h'||str.charAt(i)=='q'||str.charAt(i)=='z')
			{a[i]=8;}
			if (str.charAt(i)=='и'||str.charAt(i)=='с'||str.charAt(i)=='ъ'||str.charAt(i)=='i'||str.charAt(i)=='r')
			{a[i]=9;}
		}
		return a;
	}

	static int count(int[] array,int k)
	{
		int count=0;
		for (int i=0;i<array.length;i++)
		{
			if (array[i]==k) { count++; }
		}
		return count;
	}
	
	static int glas(String FIO,int d)
	{
		String s_words="";
		if (d==0)
		{
			for (int i=0;i<FIO.length();i++)
			{
				if (FIO.charAt(i)=='а'||FIO.charAt(i)=='у'||FIO.charAt(i)=='е'||FIO.charAt(i)=='ё'||FIO.charAt(i)=='ы'||FIO.charAt(i)=='о'||FIO.charAt(i)=='э'||FIO.charAt(i)=='я'||FIO.charAt(i)=='и'||FIO.charAt(i)=='ю'||FIO.charAt(i)=='e'||FIO.charAt(i)=='y'||FIO.charAt(i)=='u'||FIO.charAt(i)=='i'||FIO.charAt(i)=='o'||FIO.charAt(i)=='a')
				{ s_words=s_words+FIO.charAt(i); }
			}
		}
		if (d==1)
		{
			for (int i=0;i<FIO.length();i++)
			{
				if (FIO.charAt(i)=='й'||FIO.charAt(i)=='ц'||FIO.charAt(i)=='к'||FIO.charAt(i)=='н'||FIO.charAt(i)=='г'||FIO.charAt(i)=='ш'||FIO.charAt(i)=='щ'||FIO.charAt(i)=='з'||FIO.charAt(i)=='х'||FIO.charAt(i)=='ф'||FIO.charAt(i)=='в'||FIO.charAt(i)=='п'||FIO.charAt(i)=='р'||FIO.charAt(i)=='л'||FIO.charAt(i)=='д'||FIO.charAt(i)=='ж'||
					FIO.charAt(i)=='ч'||FIO.charAt(i)=='с'||FIO.charAt(i)=='м'||FIO.charAt(i)=='т'||FIO.charAt(i)=='ь'||FIO.charAt(i)=='б'||FIO.charAt(i)=='q'||FIO.charAt(i)=='w'||FIO.charAt(i)=='r'||FIO.charAt(i)=='t'||FIO.charAt(i)=='p'||FIO.charAt(i)=='s'||FIO.charAt(i)=='d'||FIO.charAt(i)=='f'||FIO.charAt(i)=='g'||FIO.charAt(i)=='h'||
					FIO.charAt(i)=='j'||FIO.charAt(i)=='k'||FIO.charAt(i)=='l'||FIO.charAt(i)=='z'||FIO.charAt(i)=='x'||FIO.charAt(i)=='c'||FIO.charAt(i)=='v'||FIO.charAt(i)=='b'||FIO.charAt(i)=='n'||FIO.charAt(i)=='m')
				{ s_words=s_words+FIO.charAt(i); }
			}
		}
		return des(sum(tabl(s_words)));
	}

	static int sum(int[] array)
	{
		int res=0;
		for (int i=0;i<array.length;i++)
		{
			res=res+array[i];
		}
		return res;
	}

	static int des(int n)
	{
		int m=n;
		while (m>9)
		{
			String s_n=Integer.toString(m);
			int[] a_n=new int[s_n.length()];
			for (int i=0;i<s_n.length();i++)
			{
				a_n[i]=Integer.parseInt(Character.toString(s_n.charAt(i)));
			}
			m=sum(a_n);
		}

		return m;
	}

	static String title(String str)
	{
		if (str.length()!=0)
		{
			str=(Character.toString(str.charAt(0)).toUpperCase())+str.substring(1,str.length());
		}
		return	str;
	}

	static String fill(String str,int len)
	{
		String end_str=str;
		if (str.length()<len)
		{
			for (int i=0;i<(len-str.length());i++)
			{
				end_str=end_str+" ";
			}
		}
  	    return end_str;
	}

	static String dat(String all_date,char k)
	{	
		String s_dat="";
		for (int i=0;i<all_date.length();i++)
		{
			if (all_date.charAt(i)==k)
			{
				s_dat=s_dat+k;
			}
		}
		if (s_dat.length()==0)
		{
			s_dat="-";
		}
		return fill(s_dat,8);
	}

	static String nopunctuation(String str)
	{
		String end_str="";
		str=str.toLowerCase();
		for (int i=0;i<str.length();i++)
		{
			if (str.charAt(i)=='a'||str.charAt(i)=='b'||str.charAt(i)=='c'||str.charAt(i)=='d'||str.charAt(i)=='e'||str.charAt(i)=='f'||
				str.charAt(i)=='g'||str.charAt(i)=='h'||str.charAt(i)=='i'||str.charAt(i)=='j'||str.charAt(i)=='k'||str.charAt(i)=='l'||
				str.charAt(i)=='m'||str.charAt(i)=='n'||str.charAt(i)=='o'||str.charAt(i)=='p'||str.charAt(i)=='q'||str.charAt(i)=='r'||
				str.charAt(i)=='s'||str.charAt(i)=='t'||str.charAt(i)=='u'||str.charAt(i)=='v'||str.charAt(i)=='w'||str.charAt(i)=='x'||str.charAt(i)=='y'||str.charAt(i)=='z'||
		        str.charAt(i)=='а'||str.charAt(i)=='б'||str.charAt(i)=='в'||str.charAt(i)=='г'||str.charAt(i)=='д'||str.charAt(i)=='е'||str.charAt(i)=='ё'||str.charAt(i)=='ж'||str.charAt(i)=='з'||
				str.charAt(i)=='и'||str.charAt(i)=='й'||str.charAt(i)=='к'||str.charAt(i)=='л'||str.charAt(i)=='м'||str.charAt(i)=='н'||str.charAt(i)=='о'||str.charAt(i)=='п'||str.charAt(i)=='р'||
				str.charAt(i)=='с'||str.charAt(i)=='т'||str.charAt(i)=='у'||str.charAt(i)=='ф'||str.charAt(i)=='х'||str.charAt(i)=='ц'||str.charAt(i)=='ч'||str.charAt(i)=='ш'||str.charAt(i)=='щ'||
				str.charAt(i)=='ъ'||str.charAt(i)=='ы'||str.charAt(i)=='ь'||str.charAt(i)=='э'||str.charAt(i)=='ю'||str.charAt(i)=='я')
			{
				end_str=end_str+str.charAt(i);
			}
		}
		return end_str;
	}

	@Override
	public void onClick(View v)	//Сработает,когда нажмём на кнопку 'Ввести данные',т.к. у неё на 'onClick' назначен метод 'onClick'
	{
	 //Прячем клавиатуру,при нажатии на кнопку ввода
		InputMethodManager hide_clipboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		hide_clipboard.hideSoftInputFromWindow(Input_all.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
		String fam="";
		String imya="";
		String otchstv="";
        int day=0;
		int mes=0;
		int god=0;
	 //Проверяем пустые поля или нет,т.к. если пустое,то "Integer.parseInt()"-не сработает
		if (fam_input.getText().length()!=0)
		   {  fam=nopunctuation(fam_input.getText().toString());  }
		if (imya_input.getText().length()!=0)
		   {  imya=nopunctuation(imya_input.getText().toString());  }
		if (otchstv_input.getText().length()!=0)
		   {  otchstv=nopunctuation(otchstv_input.getText().toString());  }
		if (day_input.getText().length()!=0)
		   {  day = Integer.parseInt(day_input.getText().toString()); }
		if (mes_input.getText().length()!=0)
		   {  mes = Integer.parseInt(mes_input.getText().toString());  }
		if (god_input.getText().length()!=0)
		   {  god = Integer.parseInt(god_input.getText().toString());  }
		if ((day==0)|(mes==0)) //надо проверять,т.к. при расчёте дня недели день или месяц не могут быть нулём
		   {
			   if ((day==0) & (mes!=0)) {set_day_txt(day_of_week_B,1,mes,god);}
			   if ((mes==0) & (day!=0)) {set_day_txt(day_of_week_B,day,1,god);}
			   else {set_day_txt(day_of_week_B,1,1,god);}
		   }
		else {set_day_txt(day_of_week_B,day,mes,god); day_of_week_B.setVisibility(0);}
		Input_Data.setText("Введённый данные: "+fam_input.getText()+" "+imya_input.getText()+" "+otchstv_input.getText()+" "+day_input.getText()+" "+mes_input.getText()+" "+god_input.getText());
		Capture_Data.setText("Считанные данные: "+title(fam)+" "+title(imya)+" "+title(otchstv)+" "+day+" "+mes+" "+god);
		txtv0.setText("0)Дата рождения:");
		txtv0_1.setText("  "+fill(Integer.toString(day),2)+"  "+fill(Integer.toString(mes),2)+"  "+fill(Integer.toString(god),4));
		String s_tmp=Integer.toString(day)+Integer.toString(mes)+Integer.toString(god);
		int[] a_tmp=new int[s_tmp.length()];
		int i_tmp=des(des(day)+des(mes)+des(god));
		for (int i=0;i<s_tmp.length();i++)
		    { a_tmp[i]=Integer.parseInt(Character.toString(s_tmp.charAt(i))); }
		txtv0_2.setText("  "+fill(Integer.toString(sum(a_tmp)),2)+"  "+i_tmp+"   "+fill(Integer.toString(Math.abs(sum(a_tmp)-2*(Integer.parseInt(Character.toString(Integer.toString(day).charAt(0)))))),2)+"   "+(des(Math.abs(sum(a_tmp)-2*(Integer.parseInt(Character.toString(Integer.toString(day).charAt(0))))))));
		s_tmp=Integer.toString(day)+Integer.toString(mes)+Integer.toString(god)+Integer.toString(sum(a_tmp))+i_tmp+Integer.toString(Math.abs(sum(a_tmp)-2*(Integer.parseInt(Character.toString(Integer.toString(day).charAt(0))))))+(des(Math.abs(sum(a_tmp)-2*(Integer.parseInt(Character.toString(Integer.toString(day).charAt(0)))))));
		txtv0_3.setText("  "+dat(s_tmp,'1')+" "+dat(s_tmp,'4')+" "+dat(s_tmp,'7'));
		txtv0_4.setText("  "+dat(s_tmp,'2')+" "+dat(s_tmp,'5')+" "+dat(s_tmp,'8'));
		txtv0_5.setText("  "+dat(s_tmp,'3')+" "+dat(s_tmp,'6')+" "+dat(s_tmp,'9'));
		txtv1.setText("1)Число судьбы: "+des(des(sum(tabl(fam)))+des(sum(tabl(imya)))+des(sum(tabl(otchstv)))));
		txtv2.setText("2)Сила рождения: "+des(des(day)+des(mes)+des(god)));
		txtv3.setText("3)Сердечное желание: "+glas((fam+imya+otchstv),0));
		txtv4.setText("4)Внешний облик: "+glas((fam+imya+otchstv),1));
		txtv5.setText("5)Число реальности: "+des(des(des(sum(tabl(fam)))+des(sum(tabl(imya)))+des(sum(tabl(otchstv)))) + des(des(day)+des(mes)+des(god))));
		txtv6.setText("6)Вызов привычки: "+des((fam+imya+otchstv).length()));
		txtv7.setText("7)Точки интенсификации:");
		a_tmp=tabl(fam+imya+otchstv);
		txtv7_1.setText("  1- "+fill(Integer.toString(count(a_tmp,1)),2)+"  4-"+fill(Integer.toString(count(a_tmp,4)),2)+"  7-"+fill(Integer.toString(count(a_tmp,7)),2));
		txtv7_2.setText("  2- "+fill(Integer.toString(count(a_tmp,2)),2)+"  5-"+fill(Integer.toString(count(a_tmp,5)),2)+"  8-"+fill(Integer.toString(count(a_tmp,8)),2));
		txtv7_3.setText("  3- "+fill(Integer.toString(count(a_tmp,3)),2)+"  6-"+fill(Integer.toString(count(a_tmp,6)),2)+"  9-"+fill(Integer.toString(count(a_tmp,9)),2));
		txtv8.setText("8)Планы выражения:");
		txtv8_1.setText("  Ф: "+des(count(a_tmp,4)+count(a_tmp,5))+"/"+des(count(a_tmp,4)*4+count(a_tmp,5)*5));
		txtv8_2.setText("  М: "+des(count(a_tmp,1)+count(a_tmp,8))+"/"+des(count(a_tmp,1)+count(a_tmp,8)*8));
		txtv8_3.setText("  Э: "+des(count(a_tmp,2)+count(a_tmp,3)+count(a_tmp,6))+"/"+des(count(a_tmp,2)*2+count(a_tmp,3)*3+count(a_tmp,6)*6));
		txtv8_4.setText("  И: "+des(count(a_tmp,7)+count(a_tmp,9))+"/"+des(count(a_tmp,7)*7+count(a_tmp,9)*9));
		txtv9.setText("9)Жизненные этапы:");
		txtv9_1.setText("  00-"+(36-i_tmp)+": "+des(des(mes)+des(day))+"/"+des(Math.abs(des(mes)-des(day))));
		txtv9_2.setText("  "+(37-i_tmp)+"-"+(45-i_tmp)+": "+des(des(day)+des(god))+"/"+des(Math.abs(des(day)-des(god))));
		txtv9_3.setText("  "+(46-i_tmp)+"-"+(54-i_tmp)+": "+des( des(des(mes)+des(day))+des(des(day)+des(god)) )+"/"+des(Math.abs( des(des(mes)-des(day))-des(des(day)-des(god)) )));
		txtv9_4.setText("  "+(55-i_tmp)+"-**: "+des(des(mes)+des(god))+"/"+des(Math.abs(des(mes)-des(god))));
		txtv10.setText("10)Число года: "+des(des(day)+des(mes)+des(java.util.Calendar.getInstance(java.util.TimeZone.getDefault(),java.util.Locale.getDefault()).get(java.util.Calendar.YEAR))));
	//Запись в файл
	    if (Is_save)
		{
		    try
		    {
				File dir=new File("/sdcard/Numerolog");
				if (!dir.exists()){ dir.mkdir(); } //создаём папку,если ее нет
			    FileOutputStream file= new FileOutputStream("/sdcard/Numerolog/"+title(fam)+" "+title(imya)+" "+title(otchstv)+" "+day+" "+mes+" "+god+".txt");
			    Writer wrt = (new OutputStreamWriter(file,"Unicode"));
			    wrt.append(
					       Input_Data.getText().toString()+"\n\n"+
					       Capture_Data.getText().toString()+"\n\n"+
					       txtv0.getText().toString()+'\n'+
					       txtv0_1.getText().toString()+'\n'+
				      	   txtv0_2.getText().toString()+"\n\n"+
					       txtv0_3.getText().toString()+'\n'+
					       txtv0_4.getText().toString()+'\n'+
					       txtv0_5.getText().toString()+'\n'+
				 	       txtv1.getText().toString()+'\n'+
					       txtv2.getText().toString()+'\n'+
					       txtv3.getText().toString()+'\n'+
					       txtv4.getText().toString()+'\n'+
					       txtv5.getText().toString()+'\n'+
					       txtv6.getText().toString()+'\n'+
					       txtv7.getText().toString()+'\n'+
					       txtv7_1.getText().toString()+'\n'+
					       txtv7_2.getText().toString()+'\n'+
				       	   txtv7_3.getText().toString()+'\n'+
					       txtv8.getText().toString()+'\n'+
					       txtv8_1.getText().toString()+'\n'+
				     	   txtv8_2.getText().toString()+'\n'+
				           txtv8_3.getText().toString()+'\n'+
					       txtv8_4.getText().toString()+'\n'+
					       txtv9.getText().toString()+'\n'+
					       txtv9_1.getText().toString()+'\n'+
					       txtv9_2.getText().toString()+'\n'+
					       txtv9_3.getText().toString()+'\n'+
					       txtv9_4.getText().toString()+'\n'+
					       txtv10.getText().toString()+'\n'+
						   day_of_week_B.getText().toString()
				    );
			    wrt.flush();
				wrt.close();
		    }
		    catch (IOException e) { Toast.makeText(this,"Не удалось сохранить файл",Toast.LENGTH_LONG).show(); }
		}
	}


	public void setFontColor(View v)
	{	
		fam_input.setTextColor(Color.rgb(R_f,G_f,B_f));fam_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));fam_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		imya_input.setTextColor(Color.rgb(R_f,G_f,B_f));imya_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));imya_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		otchstv_input.setTextColor(Color.rgb(R_f,G_f,B_f));otchstv_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));otchstv_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		day_input.setTextColor(Color.rgb(R_f,G_f,B_f));day_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));day_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		mes_input.setTextColor(Color.rgb(R_f,G_f,B_f));mes_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));mes_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		god_input.setTextColor(Color.rgb(R_f,G_f,B_f));god_input.setHintTextColor(Color.argb(128,R_f,G_f,B_f));god_input.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		Input_Data.setTextColor(Color.rgb(R_f,G_f,B_f));Input_Data.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		Capture_Data.setTextColor(Color.rgb(R_f,G_f,B_f));Capture_Data.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0_1.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0_1.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0_2.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0_2.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0_3.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0_3.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0_4.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0_4.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv0_5.setTextColor(Color.rgb(R_f,G_f,B_f));txtv0_5.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv1.setTextColor(Color.rgb(R_f,G_f,B_f));txtv1.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv2.setTextColor(Color.rgb(R_f,G_f,B_f));txtv2.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv3.setTextColor(Color.rgb(R_f,G_f,B_f));txtv3.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv4.setTextColor(Color.rgb(R_f,G_f,B_f));txtv4.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv5.setTextColor(Color.rgb(R_f,G_f,B_f));txtv5.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv6.setTextColor(Color.rgb(R_f,G_f,B_f));txtv6.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv7.setTextColor(Color.rgb(R_f,G_f,B_f));txtv7.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv7_1.setTextColor(Color.rgb(R_f,G_f,B_f));txtv7_1.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv7_2.setTextColor(Color.rgb(R_f,G_f,B_f));txtv7_2.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv7_3.setTextColor(Color.rgb(R_f,G_f,B_f));txtv7_3.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv8.setTextColor(Color.rgb(R_f,G_f,B_f));txtv8.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv8_1.setTextColor(Color.rgb(R_f,G_f,B_f));txtv8_1.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv8_2.setTextColor(Color.rgb(R_f,G_f,B_f));txtv8_2.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv8_3.setTextColor(Color.rgb(R_f,G_f,B_f));txtv8_3.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv8_4.setTextColor(Color.rgb(R_f,G_f,B_f));txtv8_4.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv9.setTextColor(Color.rgb(R_f,G_f,B_f));txtv9.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv9_1.setTextColor(Color.rgb(R_f,G_f,B_f));txtv9_1.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv9_2.setTextColor(Color.rgb(R_f,G_f,B_f));txtv9_2.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv9_3.setTextColor(Color.rgb(R_f,G_f,B_f));txtv9_3.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv9_4.setTextColor(Color.rgb(R_f,G_f,B_f));txtv9_4.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv10.setTextColor(Color.rgb(R_f,G_f,B_f));txtv10.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
		txtv_day.setTextColor(Color.rgb(R_f,G_f,B_f));txtv_day.setShadowLayer(radius_s,Dx_s,Dy_s,Color.argb(A_s,R_s,G_s,B_s));
	}


	public void setFont(View v)
	{
	    int typeface = Typeface.NORMAL; 
		if (Is_bold) { typeface+=Typeface.BOLD; }
		if (Is_italic) { typeface+=Typeface.ITALIC; }
		Input_Data.setTextSize(size);Input_Data.setTypeface(Typeface.MONOSPACE,typeface);
		Capture_Data.setTextSize(size);Capture_Data.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0.setTextSize(size);txtv0.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0_1.setTextSize(size);txtv0_1.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0_2.setTextSize(size);txtv0_2.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0_3.setTextSize(size);txtv0_3.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0_4.setTextSize(size);txtv0_4.setTypeface(Typeface.MONOSPACE,typeface);
		txtv0_5.setTextSize(size);txtv0_5.setTypeface(Typeface.MONOSPACE,typeface);
		txtv1.setTextSize(size);txtv1.setTypeface(Typeface.MONOSPACE,typeface);
		txtv2.setTextSize(size);txtv2.setTypeface(Typeface.MONOSPACE,typeface);
		txtv3.setTextSize(size);txtv3.setTypeface(Typeface.MONOSPACE,typeface);
		txtv4.setTextSize(size);txtv4.setTypeface(Typeface.MONOSPACE,typeface);
		txtv5.setTextSize(size);txtv5.setTypeface(Typeface.MONOSPACE,typeface);
		txtv6.setTextSize(size);txtv6.setTypeface(Typeface.MONOSPACE,typeface);
		txtv7.setTextSize(size);txtv7.setTypeface(Typeface.MONOSPACE,typeface);
		txtv7_1.setTextSize(size);txtv7_1.setTypeface(Typeface.MONOSPACE,typeface);
		txtv7_2.setTextSize(size);txtv7_2.setTypeface(Typeface.MONOSPACE,typeface);
		txtv7_3.setTextSize(size);txtv7_3.setTypeface(Typeface.MONOSPACE,typeface);
		txtv8.setTextSize(size);txtv8.setTypeface(Typeface.MONOSPACE,typeface);
		txtv8_1.setTextSize(size);txtv8_1.setTypeface(Typeface.MONOSPACE,typeface);
		txtv8_2.setTextSize(size);txtv8_2.setTypeface(Typeface.MONOSPACE,typeface);
		txtv8_3.setTextSize(size);txtv8_3.setTypeface(Typeface.MONOSPACE,typeface);
		txtv8_4.setTextSize(size);txtv8_4.setTypeface(Typeface.MONOSPACE,typeface);
		txtv9.setTextSize(size);txtv9.setTypeface(Typeface.MONOSPACE,typeface);
		txtv9_1.setTextSize(size);txtv9_1.setTypeface(Typeface.MONOSPACE,typeface);
		txtv9_2.setTextSize(size);txtv9_2.setTypeface(Typeface.MONOSPACE,typeface);
		txtv9_3.setTextSize(size);txtv9_3.setTypeface(Typeface.MONOSPACE.MONOSPACE,typeface);
		txtv9_4.setTextSize(size);txtv9_4.setTypeface(Typeface.MONOSPACE,typeface);
		txtv10.setTextSize(size);txtv10.setTypeface(Typeface.MONOSPACE,typeface);
		txtv_day.setTextSize(size);txtv_day.setTypeface(Typeface.MONOSPACE,typeface);
		
	}

	public void setBgColor(View v)
	{	
        generalLinearLayout.setBackgroundColor(Color.rgb(R_b,G_b,B_b));
	}

	public void set_day_txt(View v,int day,int mes,int god) //пишет на кнопке в какой день недели родился человек
	{
	  //расчёт дня недели по дате рождения (результат:0-6,0-это воскресенье)
		int a= (14 - mes) / 12;
		int y = god - a;
		int m = mes + 12 * a - 2;
		int day_of_week = (7000 + (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12))%7;
		
		String day_of_week_txt="";
		if (day_of_week==1) {day_of_week_txt="Пн";}
		if (day_of_week==2) {day_of_week_txt="Вт";} 
		if (day_of_week==3) {day_of_week_txt="Ср";}
		if (day_of_week==4) {day_of_week_txt="Чт";} 
		if (day_of_week==5) {day_of_week_txt="Пт";} 
		if (day_of_week==6) {day_of_week_txt="Сб";}
		if (day_of_week==0) {day_of_week_txt="Вс";}
		day_of_week_B.setText(day_of_week_txt);
	}
	
	public void show_day_of_week(View v) //пишет "расшифровку" этого дня недели
	{
		String day_of_week=day_of_week_B.getText().toString();
		String day_of_week_txt="";
		if (day_of_week=="Пн") {day_of_week_txt="Понедельник."+'\n'+'\n'+"Этот день проходит под знаком Луны, поэтому людям понедельника присущи такие черты характера, как нерешительность и нервозность, они противоречивые по натуре, поэтому часто не могут добиться желаемых вершин. Общительны и эмоциональны. Обладают богатой фантазией. Многие из них одиноки по жизни, так как не готовы брать ответственность за кого-то. Что касается любовных отношений, то они верны и искренни."+'\n'+'\n'+"Магические способности. В полнолуние могут загадывать желание, встав напротив открытого окна. Оно обязательно исполнится.";}
		if (day_of_week=="Вт") {day_of_week_txt="Вторник."+'\n'+'\n'+"Этим днём управляет Марс – воинственная планета. Люди, рождённые в этот день, упрямы, напористы и часто агрессивны. Хотя нередко сомневаются в правильности своих действий и слов. Людям вторника нужен тот, кто сможет подставить своё сильное плечо в трудную минуту, это может быть кроткий и нежный человек, поэтому вторую половинку лучше выбирать из ненавязчивых парней или девушек, тогда союз будет долгий и счастливый."+'\n'+'\n'+"Магические способности. Видеть вещие сны по заказу. Для этого нужно лечь до полуночи и попросить сон-предсказание. Вставать потом с кровати нельзя до утра.";}
		if (day_of_week=="Ср") {day_of_week_txt="Среда."+'\n'+'\n'+"Правит этим днём Меркурий, поэтому люди, рождённые в среду, будут постоянно заниматься самосовершенствованием. Они консерваторы, им тяжело начинать что-то новое. Целеустремлённые, уже с малых лет чётко идут к поставленной цели. Но как только достигнутое будет получено, они начинают скучать и тогда дают выход негативу, накопившемуся за всё время. Затем снова ставят цель и чётко идут к ней. В браке, кстати, им тоже нужно иногда уходить от второй половинки в тихое и укромное место, откуда они вернутся спокойными и одухотворёнными, тогда отношения будут крепкими и стабильными."+'\n'+'\n'+"Магические способности. Лечат своей энергетикой головные боли и успокаивают расшалившуюся нервную систему наложением ладоней.";}
		if (day_of_week=="Чт") {day_of_week_txt="Четверг."+'\n'+'\n'+"Главенство в этот день передаётся Юпитеру, а это означает, что люди четверга – отличные организаторы и управленцы. Они лидеры по жизни, поэтому к ним и тянутся более слабые люди. Среди них много тех, кто упрям и несговорчив, эти качества доходят до абсурда. Дома они деспоты, поэтому идеальный брак возможен с ведомым и слабым. Они собственники, поэтому измену не прощают."+'\n'+'\n'+"Магические способности. Хорошо развита интуиция, поэтому могут предсказывать будущее.";}
			if (day_of_week=="Пт") {day_of_week_txt="Пятница."+'\n'+'\n'+"Венера – покровительница этого дня недели, поэтому люди, родившиеся в пятницу, оптимистичны и жизнерадостны, они кокетливы и даже в какой-то мере несерьёзны. В их доме всегда тепло и уютно, у них много друзей и знакомых. Однако, найти вторую половинку им тяжело, так как пятничные люди не могут жить в четырёх стенах – им нужна свобода, которая не каждому влюблённому понравится, поэтому ревнивцам лучше сразу же отказать от брака с пятничными особами."+'\n'+'\n'+"Магические способности. Хорошо развит нюх на выгоду, поэтому эти люди никогда не живут в бедности. У них всегда есть деньги и стабильный заработок.";}
		if (day_of_week=="Сб") {day_of_week_txt="Суббота."+'\n'+'\n'+"Рождённым в субботу покровительствует Сатурн, поэтому они могут многое выдержать. Эти люди трудолюбивы и умны, они неторопливы, но основательны. Не любят руководить, поэтому и не стремятся к карьерному росту, им ближе домашний уют. Но вот в семье они часто несчастны, так как считают, что брак – это навсегда, а значит и не нужно проявлять инициативу в поддерживании огня чувств. В партнёрах ценят рассудительность, остальные просто становятся для них изгоями. Часто они несчастны в молодости и довольны жизнью в зрелые годы."+'\n'+'\n'+"Магические способности. Никогда не ошибаются в человеке, их первое впечатление о ком-то всегда верное.";}
		if (day_of_week=="Вс") {day_of_week_txt="Воскресенье."+'\n'+'\n'+"Людям, рождённым в воскресенье, покровительствует Солнце, поэтому им всегда комфортно по жизни. Они активные и довольно успешные, хотя нельзя их назвать баловнями судьбы, так как довольно часто с ними происходят серьёзные проблемы. Причиной их является беспечность воскресных людей – они ленивы и необязательны. Среди них мало семейных, потому что им лень заводить семью, чтобы за кем-то ухаживать. Обычно они текут по течению, которое часто приносит их в нужное и прибыльное место. Этим людям нужно научиться трудолюбию и напористости. Добиться многого в жизни им помогает близкий человек, обладающий такими чертами, как рассудительность и властность."+'\n'+'\n'+"Магические способности. Везучесть и умение угадывать номера лотерей, которой они часто и пользуются.";}
		txtv_day.setText(day_of_week_txt);
	}
}
