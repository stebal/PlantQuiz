package com.stebal.plantquiz.Model

class Plant(var genus: String, var species: String, var cultivar: String, var common: String,
            var pictureName: String, var description: String, var difficulty: Int, var id: Int = 0) {


    constructor() :this("", "", "", "", "",
            "", 0, 0)

  private var _planName: String? = null

    var plantName: String?
        get() = _planName
        set(value) {

                _planName = value
    }


}