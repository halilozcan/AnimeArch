package com.halilozcan.animearch.data

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.SERVER_RESPONSE_FILE_NAME
import com.halilozcan.animearch.data.api.AnimeApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class PokeApiTest {

    private val mockWebServer: MockWebServer = MockWebServer()

    private lateinit var animeApi: AnimeApi

    @Before
    fun setup() {
        mockWebServer.start(port = 8000)
        animeApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApi::class.java)
    }

    @Test
    fun response_whenTopAnimateSearched_isNotNull() {
        runBlocking {
            enqueueMockResponse(SERVER_RESPONSE_FILE_NAME)
            val response = animeApi.getTopCharacters()
            mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun requestPath_whenTopAnimatesRequested_isSameWithRequest() {
        runBlocking {
            enqueueMockResponse(SERVER_RESPONSE_FILE_NAME)
            animeApi.getTopCharacters()
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/top/characters")
        }
    }

    @Test
    fun firstElement_whenTopAnimatesRequested_isExpected() {
        runBlocking {
            enqueueMockResponse(SERVER_RESPONSE_FILE_NAME)
            val response = animeApi.getTopCharacters()
            val firstItem = response.data.first()
            assertThat(firstItem.name).isEqualTo("Lelouch Lamperouge")
        }
    }

    private fun enqueueMockResponse(serverResponseFileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(serverResponseFileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDown() {
        mockWebServer.shutdown()
    }

}