package com.example.networkcalls.presentation.ui.university

class University(_webPages: ArrayList<String>, _state: String, _country: String,_domains: ArrayList<String>, _alphaCode: String, _name: String){
    val webPages = _webPages
    val state = _state
    val country = _country
    val domains = _domains
    val code = _alphaCode
    val name = _name

    override fun toString(): String {

        val webPagesToString = "\"" + webPages.joinToString(",").replace(",","\", \"") + "\""
        val domainsToString = "\"" + domains.joinToString(",").replace(",","\", \"") + "\""

        return "{\"web_pages\": [${webPagesToString}],\"state\":\"${this.state}\",\"country\":\"$country\",\"domains\":[${domainsToString}], \"code\":\"$code\", \"name\":\"$name\"}"

    }
}
