package com.fehtystudio.eurika.Schedule

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fehtystudio.eurika.R
import kotlinx.android.synthetic.main.wednesday.*

class Wednesday : Fragment() {

    private var sPref: SharedPreferences? = null
    private val SAVED_TEXT_ONE = "we_saved_text_one"
    private val SAVED_TEXT_TWO = "we_saved_text_two"
    private val SAVED_TEXT_THREE = "we_saved_text_three"
    private val SAVED_TEXT_FOUR = "we_saved_text_four"
    private val SAVED_TEXT_FIVE = "we_saved_text_five"
    private val SAVED_TEXT_SIX = "we_saved_text_six"
    private val SAVED_TEXT_SEVEN = "we_saved_text_seven"
    private val SAVED_TEXT_EIGHT = "we_saved_text_eight"
    private val SAVED_TEXT_NINE = "we_saved_text_nine"
    private val SAVED_TEXT_TEN = "we_saved_text_ten"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.wednesday, container, false)
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
        val wed1 = sPref?.edit()
        val wed2 = sPref?.edit()
        val wed3 = sPref?.edit()
        val wed4 = sPref?.edit()
        val wed5 = sPref?.edit()
        val wed6 = sPref?.edit()
        val wed7 = sPref?.edit()
        val wed8 = sPref?.edit()
        val wed9 = sPref?.edit()
        val wed10 = sPref?.edit()

        wed1?.putString(SAVED_TEXT_ONE, we1.text.toString())
        wed1?.apply()

        wed2?.putString(SAVED_TEXT_TWO, we2.text.toString())
        wed2?.apply()

        wed3?.putString(SAVED_TEXT_THREE, we3.text.toString())
        wed3?.apply()

        wed4?.putString(SAVED_TEXT_FOUR, we4.text.toString())
        wed4?.apply()

        wed5?.putString(SAVED_TEXT_FIVE, we5.text.toString())
        wed5?.apply()

        wed6?.putString(SAVED_TEXT_SIX, we6.text.toString())
        wed6?.apply()

        wed7?.putString(SAVED_TEXT_SEVEN, we7.text.toString())
        wed7?.apply()

        wed8?.putString(SAVED_TEXT_EIGHT, we8.text.toString())
        wed8?.apply()

        wed9?.putString(SAVED_TEXT_NINE, we9.text.toString())
        wed9?.apply()

        wed10?.putString(SAVED_TEXT_TEN, we10.text.toString())
        wed10?.apply()
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

        we1.setText(savedTextOne)
        we2.setText(savedTextTwo)
        we3.setText(savedTextThree)
        we4.setText(savedTextFour)
        we5.setText(savedTextFive)
        we6.setText(savedTextSix)
        we7.setText(savedTextSeven)
        we8.setText(savedTextEight)
        we9.setText(savedTextNine)
        we10.setText(savedTextTen)
    }

}
