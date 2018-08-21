package com.fehtystudio.eurika.Schedule

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.monday.*


class Monday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "saved_text_one"
    private val SAVED_TEXT_TWO = "saved_text_two"
    private val SAVED_TEXT_THREE = "saved_text_three"
    private val SAVED_TEXT_FOUR = "saved_text_four"
    private val SAVED_TEXT_FIVE = "saved_text_five"
    private val SAVED_TEXT_SIX = "saved_text_six"
    private val SAVED_TEXT_SEVEN = "saved_text_seven"
    private val SAVED_TEXT_EIGHT = "saved_text_eight"
    private val SAVED_TEXT_NINE = "saved_text_nine"
    private val SAVED_TEXT_TEN = "saved_text_ten"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.monday, container, false)
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
        sPref = activity?.getPreferences(MODE_PRIVATE)
        val mon1 = sPref?.edit()
        val mon2 = sPref?.edit()
        val mon3 = sPref?.edit()
        val mon4 = sPref?.edit()
        val mon5 = sPref?.edit()
        val mon6 = sPref?.edit()
        val mon7 = sPref?.edit()
        val mon8 = sPref?.edit()
        val mon9 = sPref?.edit()
        val mon10 = sPref?.edit()

        mon1?.putString(SAVED_TEXT_ONE, mn1.text.toString())
        mon1?.apply()

        mon2?.putString(SAVED_TEXT_TWO, mn2.text.toString())
        mon2?.apply()

        mon3?.putString(SAVED_TEXT_THREE, mn3.text.toString())
        mon3?.apply()

        mon4?.putString(SAVED_TEXT_FOUR, mn4.text.toString())
        mon4?.apply()

        mon5?.putString(SAVED_TEXT_FIVE, mn5.text.toString())
        mon5?.apply()

        mon6?.putString(SAVED_TEXT_SIX, mn6.text.toString())
        mon6?.apply()

        mon7?.putString(SAVED_TEXT_SEVEN, mn7.text.toString())
        mon7?.apply()

        mon8?.putString(SAVED_TEXT_EIGHT, mn8.text.toString())
        mon8?.apply()

        mon9?.putString(SAVED_TEXT_NINE, mn9.text.toString())
        mon9?.apply()

        mon10?.putString(SAVED_TEXT_TEN, mn10.text.toString())
        mon10?.apply()
    }

    private fun loadText() {
        sPref = activity?.getPreferences(MODE_PRIVATE)
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

        mn1.setText(savedTextOne)
        mn2.setText(savedTextTwo)
        mn3.setText(savedTextThree)
        mn4.setText(savedTextFour)
        mn5.setText(savedTextFive)
        mn6.setText(savedTextSix)
        mn7.setText(savedTextSeven)
        mn8.setText(savedTextEight)
        mn9.setText(savedTextNine)
        mn10.setText(savedTextTen)
    }
}
