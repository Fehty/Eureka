package com.fehtystudio.eurika.Schedule

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.thursday.*

class Thursday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "th_saved_text_one"
    private val SAVED_TEXT_TWO = "th_saved_text_two"
    private val SAVED_TEXT_THREE = "th_saved_text_three"
    private val SAVED_TEXT_FOUR = "th_saved_text_four"
    private val SAVED_TEXT_FIVE = "th_saved_text_five"
    private val SAVED_TEXT_SIX = "th_saved_text_six"
    private val SAVED_TEXT_SEVEN = "th_saved_text_seven"
    private val SAVED_TEXT_EIGHT = "th_saved_text_eight"
    private val SAVED_TEXT_NINE = "th_saved_text_nine"
    private val SAVED_TEXT_TEN = "th_saved_text_ten"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.thursday, container, false)
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
        val thu1 = sPref?.edit()
        val thu2 = sPref?.edit()
        val thu3 = sPref?.edit()
        val thu4 = sPref?.edit()
        val thu5 = sPref?.edit()
        val thu6 = sPref?.edit()
        val thu7 = sPref?.edit()
        val thu8 = sPref?.edit()
        val thu9 = sPref?.edit()
        val thu10 = sPref?.edit()

        thu1?.putString(SAVED_TEXT_ONE, th1.text.toString())
        thu1?.apply()

        thu2?.putString(SAVED_TEXT_TWO, th2.text.toString())
        thu2?.apply()

        thu3?.putString(SAVED_TEXT_THREE, th3.text.toString())
        thu3?.apply()

        thu4?.putString(SAVED_TEXT_FOUR, th4.text.toString())
        thu4?.apply()

        thu5?.putString(SAVED_TEXT_FIVE, th5.text.toString())
        thu5?.apply()

        thu6?.putString(SAVED_TEXT_SIX, th6.text.toString())
        thu6?.apply()

        thu7?.putString(SAVED_TEXT_SEVEN, th7.text.toString())
        thu7?.apply()

        thu8?.putString(SAVED_TEXT_EIGHT, th8.text.toString())
        thu8?.apply()

        thu9?.putString(SAVED_TEXT_NINE, th9.text.toString())
        thu9?.apply()

        thu10?.putString(SAVED_TEXT_TEN, th10.text.toString())
        thu10?.apply()
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

        th1.setText(savedTextOne)
        th2.setText(savedTextTwo)
        th3.setText(savedTextThree)
        th4.setText(savedTextFour)
        th5.setText(savedTextFive)
        th6.setText(savedTextSix)
        th7.setText(savedTextSeven)
        th8.setText(savedTextEight)
        th9.setText(savedTextNine)
        th10.setText(savedTextTen)
    }
}
