package com.wrseven.gituser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    var name : String="",
    var username : String="",
    var company : String="",
    var location : String="",
    var repository : Int = 0,
    var followers : Int = 0,
    var following : Int = 0,
    var photo : Int = 0
) : Parcelable
