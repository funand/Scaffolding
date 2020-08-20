package com.example.scaffoldiing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scaffoldiing.model.Team
import com.example.scaffoldiing.model.Teams
import com.example.scaffoldiing.rocketviewmodel.TeamViewmodel
import com.example.scaffoldiing.ui.adapter.ClickListener
import com.example.scaffoldiing.ui.adapter.DataAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mViewmodel by viewModel<TeamViewmodel>()
    private var mDataset = emptyList<Team>()
    private val clickListener: ClickListener = this::handleClick
    private val mAdapter = DataAdapter(clickListener)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()
    }

    private fun setUpViews() {
        initRecycleView()
        btnSearch.setOnClickListener { searchForTeamName(it) }
    }

    private fun initRecycleView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = mAdapter
        recycler_view.setHasFixedSize(true)
    }

    private fun searchForTeamName(view: View) {
        val teamName = team_name.text.trim().toString()
        if (teamName.isEmpty()) {
            Snackbar.make(view, "Enter team name", Snackbar.LENGTH_LONG).show()
            return
        }

        mViewmodel.getTeam(teamName).observe(this, Observer { it?.let { displayTeams(it) } })
        container.visibility = View.GONE
    }

    private fun displayTeams(teams: Teams) {
        Log.d("display::", "" + teams?.teams?.get(0)?.strTeam)

        mDataset = teams.teams ?: emptyList()
        mAdapter.updateDataset(mDataset)
        recycler_view.visibility = View.VISIBLE
    }

    private fun handleClick(team: Team) {
        recycler_view.visibility = View.GONE

        val bundle = Bundle()
        bundle.putParcelable("team", team)

        val teamDetailFragment = TeamDetailFragment.newInstance()
        teamDetailFragment.arguments = bundle

        container.visibility = View.VISIBLE

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, teamDetailFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
        container.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }
}