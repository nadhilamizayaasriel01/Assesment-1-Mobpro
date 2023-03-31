package org.d3if3078.assesment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if3078.assesment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFind.setOnClickListener { zodiakk() }

    }

    private fun zodiakk() {
        val input = binding.inputZodiak.text.toString()
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "Zodiac Empty !", Toast.LENGTH_LONG).show()
            return
        }
        val bintang = getInput(input)
        binding.describe.text = bintang
    }
    private fun getInput(inputtan: String): String {
        val zodiacSigns = arrayOf("Aquarius", "Taurus", "Pisces", "Aries", "Libra ", "Cancer",
                                "Sagitarius", "Gemini", "Virgo", "Libra", "Capricorn", "Leo", "Scorpio")
        return when (inputtan.capitalize()) {
            "Aquarius" -> {
                binding.imagee.setImageResource(R.drawable.aquarius)
                "Innovative, progressive, and shamelessly revolutionary. " +
                        "Aquarius is represented by the water bearer, " +
                        "the mystical healer who bestows water, or life, upon the land. " +
                        "Accordingly, aquarius is the most humanitarian astrological sign."
            }
            "Taurus" -> {
                binding.imagee.setImageResource(R.drawable.taurus)
                "An earth sign represented by the bull. Like their celestial " +
                        "spirit animal. Taureans enjoy relaxing in serene, bucolic environments " +
                        "surrounded by soft sounds, soothing aromas, and succulent flavors."
            }
            "Pisces" -> {
                binding.imagee.setImageResource(R.drawable.pisces)
                "Pisces is the most intuitive, sensitive, and empathetic sign of the entire zodiac. " +
                        "As the final sign, Pisces has absorbed every lesson " +
                        "the joys and the pain, the hopes and the fears learned " +
                        "by all of the other signs. "
            }
            "Aries" -> {
                binding.imagee.setImageResource(R.drawable.aries)
                "Naturally, this dynamic fire sign is no stranger to competition. " +
                        "Bold and ambitious, Aries dives headfirst into even the most challenging situations " +
                        "and they'll make sure they always come out on top!"
            }
            "Libra" -> {
                binding.imagee.setImageResource(R.drawable.libra)
                "Balance, harmony, and justice define Libra energy. As a cardinal air sign, " +
                        "Libra represented by the scales " +
                        "(interestingly, the only inanimate object of the zodiac), " +
                        "an association that reflects Libra's fixation on " +
                        "establishing equilibrium. Libra is obsessed with symmetry " +
                        "and strives to create equilibrium "  +
                        "in all areas of life — especially when it comes to matters of the heart."
            }
            "Cancer" -> {
                binding.imagee.setImageResource(R.drawable.cancer)
                "Cancer seamlessly weaves between the sea and shore representing " +
                        "Cancer’s ability to exist in both emotional and material realms. " +
                        "Cancer is Highly intuitive and their psychic abilities " +
                        "manifest in tangible spaces."
            }
            "Sagitarius" -> {
                binding.imagee.setImageResource(R.drawable.sagitarius)
                "Any pursuits like blazing arrows, chasing after geographical, " +
                        "intellectual, and spiritual adventures."
            }
            "Gemini" -> {
                binding.imagee.setImageResource(R.drawable.gemini)
                "Driven by its insatiable curiosity. Appropriately symbolized by the " +
                        "celestial twins, this air sign was interested in so many pursuits " +
                            "that it had to double itself. "
            }
            "Virgo" -> {
                binding.imagee.setImageResource(R.drawable.virgo)
                "An earth sign historically represented by the goddess of wheat and " +
                        "agriculture, an association that speaks to Virgo's deep-rooted " +
                        "presence in the material world."
            }

            "Capricorn" -> {
                binding.imagee.setImageResource(R.drawable.capricorn)
                "Limbing the mountain straight to the top, and knows that patience, " +
                        "perseverance, and dedication is the only way to scale"
            }

            "Leo" -> {
                binding.imagee.setImageResource(R.drawable.leo)
                "Represented by the lion and these spirited fire signs are " +
                        "the kings and queens of the celestial jungle"
            }
            "Scorpio" ->{
                binding.imagee.setImageResource(R.drawable.scorpio)
                "A water sign that uses emotional energy as fuel, cultivating powerful wisdom " +
                        "through both the physical and unseen realms. " +
                        "In fact, Scorpio derives its extraordinary courage from its " +
                        "psychic abilities, which is what makes this sign one of " +
                        "the most complicated, dynamic signs of the zodiac."
            }

            else -> {
                binding.imagee.setImageResource(R.drawable.ghost)
                "Invalid input, please enter a valid zodiac sign again."
            }

        }
    }
}


















