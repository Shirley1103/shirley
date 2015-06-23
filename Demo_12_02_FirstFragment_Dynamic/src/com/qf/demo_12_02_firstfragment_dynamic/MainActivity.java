package com.qf.demo_12_02_firstfragment_dynamic;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.qf.demo_12_02_fragment.FragmentA;
import com.qf.demo_12_02_fragment.FragmentB;

public class MainActivity extends Activity {

	private FragmentManager fm;
	FragmentA fragA; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//通过代码动态的给Activity添加fragment的步骤：(动态添加fragment对象)
		//1、在Activity的布局中提供一个容器，用于存放fragment对象
		//2、获取fragment管理器对象
		//3、开启fragment事务(指明事务的类型)
		//4、提交fragment事务
		
		
		//获取fragment管理器对象
		fm = getFragmentManager();
		//开始fragment事务(返回值对象  用于表示移除事务、替换事务、添加事务)
		FragmentTransaction ft = fm.beginTransaction();
		
		fragA = new FragmentA();
		//用于执行添加事务
		ft.add(R.id.container, fragA);
		//参数一：Activity布局的某一个容器的id   
		//参数二：被添加的fragment对象
		
		//提交事务(只有提交了事务，事务才会被执行)
		ft.commit();
	}
	
	//按钮被点击的时候，用FragmentB替换容器中的FragmentA
	public void click(View v){
		
		FragmentB fragB = new FragmentB();
		
		FragmentTransaction ft = fm.beginTransaction();
		//指定事务的类型(替换事务)
		ft.replace(R.id.container, fragB);
		//指定事务的类型(移除事务)
//		ft.remove(fragA);
		//提交事务
		ft.commit();
		
	}

}
