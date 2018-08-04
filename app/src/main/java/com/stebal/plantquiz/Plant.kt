package com.stebal.plantquiz

class Plant(genus: String, species: String, cultivar: String, common: String,
            pictureName: String, description: String, difficulty: Int, id: Int = 0) {


    constructor() :this("", "", "", "", "",
            "", 0, 0)

  private var _planName: String? = null

    var plantName: String?
        get() = _planName
        set(value) {

                _planName = value
    }


}