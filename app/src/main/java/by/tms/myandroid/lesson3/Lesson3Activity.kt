package by.tms.myandroid.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson3.*
import kotlinx.coroutines.runBlocking

class Lesson3Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson3)
        val model = ViewModelProvider(this).get(Lesson3ViewModel::class.java)
        lifecycle.addObserver(Lesson3LifeObserver())

        plusConfBtn.setOnClickListener(this)
        plusRecBtn.setOnClickListener(this)
        plusDeadBtn.setOnClickListener(this)

//        showStats() // Ctrl+Alt+M

        model.currenctStats.observe(this, Observer {
            confirmedCount.text = it[0].toString()
            recoveredCount.text = it[1].toString()
            deadCount.text = it[2].toString()
        })

        refreshData.setOnClickListener {
            runBlocking {
                model.getDataFromInternet()
            }
        }
    }

    private fun showStats() {
        val model = ViewModelProvider(this).get(Lesson3ViewModel::class.java)
        confirmedCount.text = model.confirmed.toString()
        recoveredCount.text = model.recovered.toString()
        deadCount.text = model.dead.toString()
    }

    override fun onClick(v: View?) {
        val model = ViewModelProvider(this).get(Lesson3ViewModel::class.java)
        when (v?.id) {
            R.id.plusConfBtn -> {
                model.confirmed++
                confirmedCount.text = model.confirmed.toString()
            }
            R.id.plusRecBtn -> {
                model.recovered++
                recoveredCount.text = model.recovered.toString()
            }
            R.id.plusDeadBtn -> {
                model.dead++
                deadCount.text = model.dead.toString()
            }
        }
    }
}
