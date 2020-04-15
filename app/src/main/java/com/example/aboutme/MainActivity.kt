package com.example.aboutme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Ronnie")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname()

        }

    }

    private fun addNickname() {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
//            After the nickname is set, you want your code to refresh the UI with the new data.
//            To do this, you must invalidate all binding expressions
//            so that they are recreated with the correct data.
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE


        }


    }


}




//Steps to use data binding to replace calls to findViewById():
//
//Enable data binding in the android section of the build.gradle file:
//dataBinding { enabled = true }
//Use <layout> as the root view in your XML layout.
//Define a binding variable:
//private lateinit var binding: ActivityMainBinding
//Create a binding object in MainActivity, replacing setContentView:
//binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//Replace calls to findViewById() with references to the view in the binding object. For example:
//findViewById<Button>(R.id.done_button) ⇒ binding.doneButton
//(In the example, the name of the view is generated camel case from the view's id in the XML.)
//Steps for binding views to data:
//
//Create a data class for your data.
//Add a <data> block inside the <layout> tag.
//Define a <variable> with a name, and a type that is the data class.
//<data>
//<variable
//name="myName"
//type="com.example.android.aboutme.MyName" />
//</data>
//In MainActivity, create a variable with an instance of the data class. For example:
//private val myName: MyName = MyName("Aleks Haecky")
//In the binding object, set the variable to the variable you just created:
//binding.myName = myName
//In the XML, set the content of the view to the variable that you defined in the <data> block. Use dot notation to access the data inside the data class.
//android:text="@={myName.name}"
