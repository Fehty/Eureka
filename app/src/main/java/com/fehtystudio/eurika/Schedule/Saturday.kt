package com.fehtystudio.eurika.Schedule

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.saturday.*

class Saturday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "st_saved_text_one"
    private val SAVED_TEXT_TWO = "st_saved_text_two"
    private val SAVED_TEXT_THREE = "st_saved_text_three"
    private val SAVED_TEXT_FOUR = "st_saved_text_four"
    private val SAVED_TEXT_FIVE = "st_saved_text_five"
    private val SAVED_TEXT_SIX = "st_saved_text_six"
    private val SAVED_TEXT_SEVEN = "st_saved_text_seven"
    private val SAVED_TEXT_EIGHT = "st_saved_text_eight"
    private val SAVED_TEXT_NINE = "st_saved_text_nine"
    private val SAVED_TEXT_TEN = "st_saved_text_ten"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.saturday, container, false)
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
        val sat1 = sPref?.edit()
        val sat2 = sPref?.edit()
        val sat3 = sPref?.edit()
        val sat4 = sPref?.edit()
        val sat5 = sPref?.edit()
        val sat6 = sPref?.edit()
        val sat7 = sPref?.edit()
        val sat8 = sPref?.edit()
        val sat9 = sPref?.edit()
        val sat10 = sPref?.edit()

        sat1?.putString(SAVED_TEXT_ONE, st1.text.toString())
        sat1?.apply()

        sat2?.putString(SAVED_TEXT_TWO, st2.text.toString())
        sat2?.apply()

        sat3?.putString(SAVED_TEXT_THREE, st3.text.toString())
        sat3?.apply()

        sat4?.putString(SAVED_TEXT_FOUR, st4.text.toString())
        sat4?.apply()

        sat5?.putString(SAVED_TEXT_FIVE, st5.text.toString())
        sat5?.apply()

        sat6?.putString(SAVED_TEXT_SIX, st6.text.toString())
        sat6?.apply()

        sat7?.putString(SAVED_TEXT_SEVEN, st7.text.toString())
        sat7?.apply()

        sat8?.putString(SAVED_TEXT_EIGHT, st8.text.toString())
        sat8?.apply()

        sat9?.putString(SAVED_TEXT_NINE, st9.text.toString())
        sat9?.apply()

        sat10?.putString(SAVED_TEXT_TEN, st10.text.toString())
        sat10?.apply()
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

        st1.setText(savedTextOne)
        st2.setText(savedTextTwo)
        st3.setText(savedTextThree)
        st4.setText(savedTextFour)
        st5.setText(savedTextFive)
        st6.setText(savedTextSix)
        st7.setText(savedTextSeven)
        st8.setText(savedTextEight)
        st9.setText(savedTextNine)
        st10.setText(savedTextTen)
    }

}
