package com.example.networkcalls.presentation.ui.universities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkcalls.presentation.ui.university.University
import com.github.kittinunf.fuel.coroutines.awaitByteArrayResponseResult
import com.github.kittinunf.fuel.httpGet
import kotlinx.coroutines.launch
import org.json.JSONArray
import kotlin.collections.ArrayList

class UniversitiesViewModel : ViewModel() {

    val universities : MutableLiveData<ArrayList<University>> by lazy {
        MutableLiveData<ArrayList<University>>()
    }


    /*
    * Using co-routines
    * */
    fun getUniversitiesUsingCoRoutine(keyword: String = "Texas", country: String = "united states"){
        viewModelScope.launch {
            universities.postValue(getUniversitiesWCoroutine(keyword, country))
        }
    }

    private suspend fun getUniversitiesWCoroutine(keyword: String = "Texas", country: String = "united states"): ArrayList<University> {
        val url = "http://universities.hipolabs.com/search?name=$keyword&country=$country"

        return parseUniversities(url.httpGet().header("Content-Type" to "application/json")
            .header("Accept" to "application/json")
            .awaitByteArrayResponseResult().third.component1()!!)

    }


    /*
    * Using no co-routines
    * */
    fun getUniversities(keyword: String = "Texas", country: String = "united states"){
        val url = "http://universities.hipolabs.com/search?name=$keyword&country=$country"

        url.httpGet().header("Content-Type" to "application/json")
                .header("Accept" to "application/json")
                .timeout(1500)
                .timeoutRead(1500)
                .response { _, response, _ ->
                    val statusCode = response.statusCode
                    val data = response.data

                    when (statusCode) {
                        -1 -> {
                            println("Request failed with status code $statusCode")
                        }
                        in 200..299 -> {
                            universities.postValue(parseUniversities(data))
                        }
                        in 400..500 -> {
                            if (statusCode == 401) {
                                println("Request failed with status code $statusCode")
                            } else {
                                println("Request failed with status code $statusCode")
                            }
                        }
                    }
                }
    }

    private fun parseUniversities(data: ByteArray): ArrayList<University> {
        val universities = ArrayList<University>()
        try {
            val stringData = String(data)
            val jsonArray = JSONArray(stringData)
            val len = jsonArray.length()
            for (i in 0 until len) {
                val tem = jsonArray.getJSONObject(i)

                val webpages = tem.get("web_pages").toString()
                    .replace("[", "")
                    .replace("\"","")
                    .replace("]","")
                    .replace("\\/", "/")
                    .split(",")

                val webpageList = ArrayList<String>(webpages)
                val state = tem.get("state-province").toString()
                val country = tem.get("country").toString()
                val domains = tem.get("domains").toString()
                    .replace("[", "")
                    .replace("\"","")
                    .replace("]","")
                    .replace("\\/", "/")
                    .split(",")

                val domainList = ArrayList<String>(domains)

                val code = tem.get("alpha_two_code").toString()
                val name = tem.get("name").toString()

                universities.add(
                    University(
                        webpageList,
                        state,
                        country,
                        domainList,
                        code,
                        name
                    )
                )
            }
        } catch (e: Exception) {
            //
        }
        return universities
    }
}
