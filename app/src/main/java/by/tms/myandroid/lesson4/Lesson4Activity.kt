package by.tms.myandroid.lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.tms.myandroid.R
import kotlinx.android.synthetic.main.activity_lesson4.*

const val REQUEST_FIELD_FLOWER_NAME = "flower name"
const val REQUEST_FIELD_FLOWER_PRICE = "flower price"
const val REQUEST_FIELD_FLOWER_URL = "flower url"

class Lesson4Activity : AppCompatActivity(), View.OnClickListener {
    private var fragmentTop: Lesson4Fragment? = null
    private var fragmentBottom: Lesson4Fragment? = null
    private val instance = Lesson4Collection.instance

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4)

        addTopFragmentLesson4.setOnClickListener(this)
        addBottomFragmentLesson4.setOnClickListener(this)
        removeTopFragmentLesson4.setOnClickListener(this)
        removeBottomFragmentLesson4.setOnClickListener(this)
        addFlowerLesson4.setOnClickListener(this)
        topFragmentLesson4.setOnClickListener(this)
        bottomFragmentLesson4.setOnClickListener(this)

        // for quick testing
/*        if (instance.getCount() == 0) {
            instance.addFlower(
                "rose",
                1.0,
                "https://flower-trade.ru/wp-content/uploads/2019/10/red-paris555.jpg"
            )
            instance.addFlower(
                "tulip",
                2.0,
                "https://donpion.ua/static/media/uploads/product/one_flower/tulips/.thumbnails/tulips-orange.jpg/tulips-orange-0x700.jpg"
            )
        } */

        if (instance.addTop && instance.getCount() > 0)
            fragmentTop = setFragment(R.id.topFragmentLesson4, 0)
        if (instance.addBottom && instance.getCount() > 1)
            fragmentBottom = setFragment(R.id.bottomFragmentLesson4, 1)
    }

    @Override
    override fun onResume() {
        super.onResume()
        updateCount()
    }

    @Override
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addTopFragmentLesson4 -> {
                if (instance.getCount() > 0) {
                    fragmentTop = setFragment(R.id.topFragmentLesson4, 0)
                    instance.addTop = true
                }
                else
                    Toast.makeText(
                        this,
                        R.string.lesson4_add_fragment_failed,
                        Toast.LENGTH_SHORT
                    ).show()
            }
            R.id.addBottomFragmentLesson4 -> {
                if (instance.getCount() > 1) {
                    fragmentBottom = setFragment(R.id.bottomFragmentLesson4, 1)
                    instance.addBottom = true
                }
                else
                    Toast.makeText(
                        this,
                        R.string.lesson4_add_fragment_failed,
                        Toast.LENGTH_SHORT
                    ).show()
            }
            R.id.removeTopFragmentLesson4 -> {
                if (fragmentTop != null) {
                    removeFragment(fragmentTop)
                    fragmentTop = null
                    instance.addTop = false
                } else
                    Toast.makeText(
                        this,
                        R.string.lesson4_delete_fragment_failed,
                        Toast.LENGTH_SHORT
                    ).show()
            }
            R.id.removeBottomFragmentLesson4 -> {
                if (fragmentBottom != null) {
                    removeFragment(fragmentBottom)
                    fragmentBottom = null
                    instance.addBottom = false
                } else
                    Toast.makeText(
                        this,
                        R.string.lesson4_delete_fragment_failed,
                        Toast.LENGTH_SHORT
                    ).show()
            }
            R.id.addFlowerLesson4 -> {
                val intent = Intent(this, Lesson4AddActivity::class.java)
                startActivity(intent)
            }
            R.id.topFragmentLesson4 -> {
                showFragmentInfo(0)
            }
            R.id.bottomFragmentLesson4 -> {
                showFragmentInfo(1)
            }
        }
    }

    private fun setFragment(resId: Int, index: Int) : Lesson4Fragment {
        val fragment = Lesson4Fragment()
        supportFragmentManager.beginTransaction()
            .replace(resId, fragment)
            .commit()
        fragment.updateData(instance.getFlower(index))
        return fragment
    }

    private fun removeFragment(fragment: Lesson4Fragment?) {
        supportFragmentManager.beginTransaction()
            .remove(fragment!!)
            .commit()
    }

    private fun showFragmentInfo(index: Int) {
        val intent = Intent(this, Lesson4InfoActivity::class.java).apply {
            putExtra(REQUEST_FIELD_FLOWER_NAME, instance.getFlower(index).name)
            putExtra(REQUEST_FIELD_FLOWER_PRICE, instance.getFlower(index).price)
            putExtra(REQUEST_FIELD_FLOWER_URL, instance.getFlower(index).url)
        }
        startActivity(intent)
    }

    private fun updateCount() {
        countLesson4.text = instance.getCount().toString()
    }
}
