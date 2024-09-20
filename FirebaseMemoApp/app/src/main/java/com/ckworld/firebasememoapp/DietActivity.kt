package com.ckworld.firebasememoapp

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DietActivity : AppCompatActivity() {
    var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainList)
        val adapterList = ListViewAdapter(dataList)
        listView.adapter = adapterList

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children) {
                    Log.d("Database Data", dataModel.toString())
                    dataList.add(dataModel.getValue(DataModel::class.java)!!)
                }
                adapterList.notifyDataSetChanged()
                Log.d("DataModelList", dataList.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Database Data", "Failed to read value.", error.toException())
            }
        })


        val writeBtn = findViewById<ImageView>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            val dateSelectBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)
            val today = GregorianCalendar()
            val year: Int = today.get(Calendar.YEAR)
            val month: Int = today.get(Calendar.MONTH)
            val day: Int = today.get(Calendar.DAY_OF_MONTH)
            var dateText = "${year}-${month+1}-${day}"
            dateSelectBtn!!.setOnClickListener {
                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                        Log.d("DIET", "${year}-${month+1}-${day}")
                        dateSelectBtn!!.setText("${p1}-${p2+1}-${p3}")
                        dateText = "${p1}, ${p2+1}, ${p3}"
                    }
                }, year, month, day)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {
                val activityMemo = mAlertDialog.findViewById<EditText>(R.id.activityMemo)?.text.toString()
                val model = DataModel(dateText, activityMemo)
                Log.d("Dialog", model.toString())

                myRef.push().setValue(model)

                mAlertDialog.dismiss()
            }
        }



    }
}