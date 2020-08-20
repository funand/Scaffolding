package com.example.scaffoldiing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.scaffoldiing.model.Team
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.team_fragment.*

class TeamDetailFragment() : Fragment() {

    private var mTeam: Team? = null

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            mTeam = it.getParcelable("team")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(
            R.layout.team_fragment,
            container, false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTeam?.let { mTeam ->
            team_name.text = mTeam.strTeam.orEmpty()
            team_id.text = mTeam.idTeam.orEmpty()
            team_name.text = mTeam.strTeam.orEmpty()
            league.text = mTeam.strLeague.orEmpty()
            team_alternate_name.text = mTeam.strAlternate.orEmpty()
            team_stadium.text = mTeam.strStadium.orEmpty()
            team_stadium_location.text = mTeam.strStadiumLocation.orEmpty()
            stadium_capacity.text = mTeam.intStadiumCapacity.orEmpty()
            team_description.text = mTeam.strDescriptionEN.orEmpty()

            mTeam.strTeamBadge?.let { badge ->
                Picasso.get().load(badge).fit().into(team_stadium_img as ImageView)
            }

            mTeam.strStadiumThumb?.let { stadium ->
                Picasso.get().load(stadium).fit().into(team_logo as ImageView)
            }
        }
    }
}

