package com.example.memo

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity() {

    lateinit var db : MemoDatabase
    var memoList = listOf<MemoEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MemoDatabase.getInstance(this)!!

        button_add.setOnClickListener {
            var memo = MemoEntity(null,editText.text.toString())
            insertMemo(memo)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    //1. Insert Data .. MemoEntity 객체를 이용해서 데이터를 생성후 데이터베이스에 삽입
    //2. Get Data   .. 데이터베이스에 있는 값을 리스트에 보여주는 역할
    //3. Delete Data
    //4. Set RecyclerView

    fun insertMemo(memo : MemoEntity){
        //1. MainThread vs WorkerThread(Background Thread)
        //화면과 관련된 모든것들은 메인스레드, 그리고 데이터통신은 모두 워크스레드

        val insertTask = object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDAO().insert(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }
        }
        insertTask.execute()
    }


    fun getAllMemos(){
        val getTask = (object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                memoList = db.memoDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecylcerView(memoList)
            }
        }).execute()

    }
    fun deleteMemo(){

    }
    fun setRecylcerView(memoList : List<MemoEntity>){
        recyclerView.adapter = MyAdapter(this,memoList)
    }
}