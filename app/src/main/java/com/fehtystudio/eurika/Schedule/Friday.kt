package com.fehtystudio.eurika.Schedule

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.friday.*

class Friday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "fr_saved_text_one"
    private val SAVED_TEXT_TWO = "fr_saved_text_two"
    private val SAVED_TEXT_THREE = "fr_saved_text_three"
    private val SAVED_TEXT_FOUR = "fr_saved_text_four"
    private val SAVED_TEXT_FIVE = "fr_saved_text_five"
    private val SAVED_TEXT_SIX = "fr_saved_text_six"
    private val SAVED_TEXT_SEVEN = "fr_saved_text_seven"
    private val SAVED_TEXT_EIGHT = "fr_saved_text_eight"
    private val SAVED_TEXT_NINE = "fr_saved_text_nine"
    private val SAVED_TEXT_TEN = "fr_saved_text_ten"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.friday, container, false)
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
        val fri1 = sPref?.edit()
        val fri2 = sPref?.edit()
        val fri3 = sPref?.edit()
        val fri4 = sPref?.edit()
        val fri5 = sPref?.edit()
        val fri6 = sPref?.edit()
        val fri7 = sPref?.edit()
        val fri8 = sPref?.edit()
        val fri9 = sPref?.edit()
        val fri10 = sPref?.edit()

        fri1?.putString(SAVED_TEXT_ONE, fr1.text.toString())
        fri1?.apply()

        fri2?.putString(SAVED_TEXT_TWO, fr2.text.toString())
        fri2?.apply()

        fri3?.putString(SAVED_TEXT_THREE, fr3.text.toString())
        fri3?.apply()

        fri4?.putString(SAVED_TEXT_FOUR, fr4.text.toString())
        fri4?.apply()

        fri5?.putString(SAVED_TEXT_FIVE, fr5.text.toString())
        fri5?.apply()

        fri6?.putString(SAVED_TEXT_SIX, fr6.text.toString())
        fri6?.apply()

        fri7?.putString(SAVED_TEXT_SEVEN, fr7.text.toString())
        fri7?.apply()

        fri8?.putString(SAVED_TEXT_EIGHT, fr8.text.toString())
        fri8?.apply()

        fri9?.putString(SAVED_TEXT_NINE, fr9.text.toString())
        fri9?.apply()

        fri10?.putString(SAVED_TEXT_TEN, fr10.text.toString())
        fri10?.apply()
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

        fr1.setText(savedTextOne)
        fr2.setText(savedTextTwo)
        fr3.setText(savedTextThree)
        fr4.setText(savedTextFour)
        fr5.setText(savedTextFive)
        fr6.setText(savedTextSix)
        fr7.setText(savedTextSeven)
        fr8.setText(savedTextEight)
        fr9.setText(savedTextNine)
        fr10.setText(savedTextTen)
    }
}
