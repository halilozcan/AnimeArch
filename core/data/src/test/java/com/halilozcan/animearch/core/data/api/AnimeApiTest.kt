package com.halilozcan.animearch.core.data.api

import com.google.common.truth.Truth.assertThat
import com.halilozcan.animearch.core.data.SERVER_PORT
import com.halilozcan.animearch.core.data.SINGLE_ANIME_CHARACTER_RESPONSE_FILE_NAME
import com.halilozcan.animearch.core.data.TOP_ANIME_CHARACTERS_RESPONSE_FILE_NAME
import com.halilozcan.animearch.core.data.singleAnimePathId
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

internal class AnimeApiTest {

    private val mockWebServer: MockWebServer = MockWebServer()

    private lateinit var animeApi: AnimeApi

    @Before
    fun setup() {
        mockWebServer.start(port = SERVER_PORT)
        animeApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeApi::class.java)
    }

    /**
     * TopAnimeCharacters Test
     */
    @Test
    fun response_whenTopAnimateSearched_isNotNull() {
        runBlocking {
            enqueueMockResponse(TOP_ANIME_CHARACTERS_RESPONSE_FILE_NAME)
            val response = animeApi.getTopCharacters()
            mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun requestPath_whenTopAnimatesRequested_isSameWithRequest() {
        runBlocking {
            enqueueMockResponse(TOP_ANIME_CHARACTERS_RESPONSE_FILE_NAME)
            animeApi.getTopCharacters()
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/top/characters")
        }
    }

    @Test
    fun firstElement_whenTopAnimeCharactersRequested_hasSameName() {
        runBlocking {
            enqueueMockResponse(TOP_ANIME_CHARACTERS_RESPONSE_FILE_NAME)
            val response = animeApi.getTopCharacters()
            val firstItem = response.data.first()
            assertThat(firstItem.name).isEqualTo("Lelouch Lamperouge")
        }
    }

    /**
     * SingleAnimeCharacter Test
     */
    @Test
    fun response_whenSingleAnimateSearched_isNotNull() {
        runBlocking {
            enqueueMockResponse(SINGLE_ANIME_CHARACTER_RESPONSE_FILE_NAME)
            val response = animeApi.getSingleCharacterFull(singleAnimePathId)
            mockWebServer.takeRequest()
            assertThat(response).isNotNull()
        }
    }

    @Test
    fun requestPath_whenSingleAnimeRequested_isSameWithRequest() {
        runBlocking {
            enqueueMockResponse(SINGLE_ANIME_CHARACTER_RESPONSE_FILE_NAME)
            animeApi.getSingleCharacterFull(singleAnimePathId)
            val request = mockWebServer.takeRequest()
            assertThat(request.path).isEqualTo("/characters/$singleAnimePathId/full")
        }
    }

    @Test
    fun animeName_whenSingleAnimeRequested_isSame() {
        runBlocking {
            enqueueMockResponse(SINGLE_ANIME_CHARACTER_RESPONSE_FILE_NAME)
            val response = animeApi.getSingleCharacterFull(singleAnimePathId)
            val firstItem = response.data
            assertThat(firstItem?.name).isEqualTo("Lelouch Lamperouge")
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