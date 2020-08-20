package com.example.scaffoldiing.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @SerializedName("idTeam")
    var idTeam: String?,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String?,
    @SerializedName("idAPIfootball")
    var idAPIfootball: String?,
    @SerializedName("strTeam")
    var strTeam: String?,
    @SerializedName("strTeamShort")
    var strTeamShort: String?,
    @SerializedName("strAlternate")
    var strAlternate: String?,
    @SerializedName("intFormedYear")
    var intFormedYear: String?,
    @SerializedName("strSport")
    var strSport: String?,
    @SerializedName("strLeague")
    var strLeague: String?,
    @SerializedName("idLeague")
    var idLeague: String?,
    @SerializedName("strManager")
    var strManager: String?,
    @SerializedName("strStadium")
    var strStadium: String?,
    @SerializedName("strKeywords")
    var strKeywords: String?,
    @SerializedName("strRSS")
    var strRSS: String?,
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String?,
    @SerializedName("strStadiumDescription")
    var strStadiumDescription: String?,
    @SerializedName("strStadiumLocation")
    var strStadiumLocation: String?,
    @SerializedName("intStadiumCapacity")
    var intStadiumCapacity: String?,
    @SerializedName("strWebsite")
    var strWebsite: String?,
    @SerializedName("strFacebook")
    var strFacebook: String?,
    @SerializedName("strTwitter")
    var strTwitter: String?,
    @SerializedName("strInstagram")
    var strInstagram: String?,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String?,
    @SerializedName("strTeamJersey")
    var strTeamJersey: String?,
    @SerializedName("strTeamLogo")
    var strTeamLogo: String?,
    @SerializedName("strTeamBanner")
    var strTeamBanner: String?,
    @SerializedName("strYoutube")
    var strYoutube: String?,
    @SerializedName("strLocked")
    var strLocked: String?,
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String?
) : Parcelable
