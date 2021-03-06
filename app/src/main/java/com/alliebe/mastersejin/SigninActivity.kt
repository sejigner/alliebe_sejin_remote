package com.alliebe.mastersejin

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signin.*
import java.text.SimpleDateFormat
import java.util.*


class SigninActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var button_date: EditText? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        auth = Firebase.auth

        // get the references from layout file
        textview_date = this.hint_birth
        button_date = this.et_dateOfBirth_signin

        textview_date!!.text = "YYYY/MM/DD"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@SigninActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })


        ibtn_signin.setOnClickListener {
            performRegister()
        }
    }

    private fun updateDateInView() {
        val myFormat = "yyyy/MM/dd" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
        textview_date!!.text = sdf.format(cal.getTime())
    }

    private fun performRegister() {
        val email = et_email_signin.text.toString()
        val password = et_password_signin.text.toString()
        val nickname = et_nickname_signin.text.toString()
        val dateOfBirth = textview_date!!.text.toString()
        val sex : String

        // 성별 선택 여부 검사
        var sexId: Int = rg_sex_signin.checkedRadioButtonId
        // val dateOfBirth = et_dateOfBirth_signin.text.toString()
        // needs component for the date format

        if (sexId!=-1){ // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio: RadioButton = findViewById(rg_sex_signin.checkedRadioButtonId)
            sex = radio.toString()
        }else{
            // If no radio button checked in this radio group
            Toast.makeText(applicationContext,"성별을 선택해주세요.",
                Toast.LENGTH_SHORT).show()
        }



        // 이메일과 비밀번호 검사
        if (email.isEmpty()) {

            Toast.makeText(this,"이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this,"비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (nickname.isEmpty()) {
            Toast.makeText(this,"닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (dateOfBirth.isEmpty()) {
            Toast.makeText(this,"생년월일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }


        Log.d("SigninActivity", "Email is: " + email)
        Log.d("SigninActivity", "Password: $password ")

        // Firebase Authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if successful
                Log.d("Signin", "Successfully created user with uid: ${it.result?.user?.uid}")
                val user = auth.currentUser
                // saveUserToFirebaseDatabase()
                // updateUI(user)
            }
            .addOnFailureListener{
                Log.d("Signin", "Failed to create user: ${it.message}")
                Toast.makeText(this,"Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
    /* private fun saveUserToFirebaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")

        ref.setValue()
    } */
}

// class User(val uid: String, val nickname: String, val dateOfBirth: Int, val )