package com.vahairston.diceroller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [StatsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatsFragment : Fragment() {

    lateinit var strengthScore: TextView
    lateinit var dexterityScore: TextView
    lateinit var constitutionScore: TextView
    lateinit var intelligenceScore: TextView
    lateinit var wisdomScore: TextView
    lateinit var charismaScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLayout()
    }

    private fun setUpLayout() {

        strengthScore = view!!.findViewById(R.id.strengthScore)
        dexterityScore = view!!.findViewById(R.id.dexterityScore)
        constitutionScore = view!!.findViewById(R.id.constitutionScore)
        intelligenceScore = view!!.findViewById(R.id.intelligenceScore)
        wisdomScore = view!!.findViewById(R.id.wisdomScore)
        charismaScore = view!!.findViewById(R.id.charismaScore)

        view!!.findViewById<Button>(R.id.reroll).setOnClickListener { reroll() }

        strengthScore.setText(rollStat())
        dexterityScore.setText(rollStat())
        constitutionScore.setText(rollStat())
        intelligenceScore.setText(rollStat())
        wisdomScore.setText(rollStat())
        charismaScore.setText(rollStat())
    }

    private fun rollStat(): String {
        var rolls = ArrayList<Int>()
        var count = 0
        while (count < 4) {
            var i = (Random.nextInt(6) + 1)
            rolls.add(i)
            Log.d("ROLL", "roll is " + i )
            count++
        }
        rolls.sort()
        rolls.removeAt(0)
        var total = 0
        for (i in rolls) {
            total += i
        }

        return total.toString()
    }

    private fun reroll(){
        strengthScore.setText(rollStat())
        dexterityScore.setText(rollStat())
        constitutionScore.setText(rollStat())
        intelligenceScore.setText(rollStat())
        wisdomScore.setText(rollStat())
        charismaScore.setText(rollStat())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            StatsFragment().apply {

            }
    }
}
