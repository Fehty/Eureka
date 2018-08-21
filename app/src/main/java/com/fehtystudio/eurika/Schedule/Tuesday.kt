package com.fehtystudio.eurika.Schedule

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.tuesday.*

class Tuesday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "tu_saved_text_one"
    private val SAVED_TEXT_TWO = "tu_saved_text_two"
    private val SAVED_TEXT_THREE = "tu_saved_text_three"
    private val SAVED_TEXT_FOUR = "tu_saved_text_four"
    private val SAVED_TEXT_FIVE = "tu_saved_text_five"
    private val SAVED_TEXT_SIX = "tu_saved_text_six"
    private val SAVED_TEXT_SEVEN = "tu_saved_text_seven"
    private val SAVED_TEXT_EIGHT = "tu_saved_text_eight"
    private val SAVED_TEXT_NINE = "tu_saved_text_nine"
    private val SAVED_TEXT_TEN = "tu_saved_text_ten"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tuesday, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadText()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        saveText()
        super.onDestroyView()
    }

    private fun saveText() {
        sPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val tue1 = sPref?.edit()
        val tue2 = sPref?.edit()
        val tue3 = sPref?.edit()
        val tue4 = sPref?.edit()
        val tue5 = sPref?.edit()
        val tue6 = sPref?.edit()
        val tue7 = sPref?.edit()
        val tue8 = sPref?.edit()
        val tue9 = sPref?.edit()
        val tue10 = sPref?.edit()

        tue1?.putString(SAVED_TEXT_ONE, tu1.text.toString())
        tue1?.apply()

        tue2?.putString(SAVED_TEXT_TWO, tu2.text.toString())
        tue2?.apply()

        tue3?.putString(SAVED_TEXT_THREE, tu3.text.toString())
        tue3?.apply()

        tue4?.putString(SAVED_TEXT_FOUR, tu4.text.toString())
        tue4?.apply()

        tue5?.putString(SAVED_TEXT_FIVE, tu5.text.toString())
        tue5?.apply()

        tue6?.putString(SAVED_TEXT_SIX, tu6.text.toString())
        tue6?.apply()

        tue7?.putString(SAVED_TEXT_SEVEN, tu7.text.toString())
        tue7?.apply()

        tue8?.putString(SAVED_TEXT_EIGHT, tu8.text.toString())
        tue8?.apply()

        tue9?.putString(SAVED_TEXT_NINE, tu9.text.toString())
        tue9?.apply()

        tue10?.putString(SAVED_TEXT_TEN, tu10.text.toString())
        tue10?.apply()
    }

    private fun loadText() {
        sPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val savedTextOne = sPref?.getString(SAVED_TEXT_ONE, "")
        val savedTextTwo = sPref?.getString(SAVED_TEXT_TWO, "")
        val savedTextThree = sPref?.getString(SAVED_TEXT_THREE, "")
        val savedTextFour = sPref?.getString(SAVED_TEXT_FOUR, "")
        val savedTextFive = sPref?.getString(SAVED_TEXT_FIVE, "")
        val savedTextSix = sPref?.getString(SAVED_TEXT_SIX, "")
        val savedTextSeven = sPref?.getString(SAVED_TEXT_SEVEN, "")
        val savedTextEight = sPref?.getString(SAVED_TEXT_EIGHT, "")
        val savedTextNine = sPref?.getString(SAVED_TEXT_NINE, "")
        val savedTextTen = sPref?.getString(SAVED_TEXT_TEN, "")

        tu1.setText(savedTextOne)
        tu2.setText(savedTextTwo)
        tu3.setText(savedTextThree)
        tu4.setText(savedTextFour)
        tu5.setText(savedTextFive)
        tu6.setText(savedTextSix)
        tu7.setText(savedTextSeven)
        tu8.setText(savedTextEight)
        tu9.setText(savedTextNine)
        tu10.setText(savedTextTen)
    }
}
