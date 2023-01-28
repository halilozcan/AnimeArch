package com.halilozcan.animearch.core.data


import androidx.annotation.VisibleForTesting
import com.halilozcan.animearch.core.data.dto.single.AnimeCharacter
import com.halilozcan.animearch.core.data.dto.single.ImagesX
import com.halilozcan.animearch.core.data.dto.single.SingleCharacterResponse
import com.halilozcan.animearch.core.data.dto.single.WebpX
import com.halilozcan.animearch.core.data.dto.top.Anime
import com.halilozcan.animearch.core.data.dto.top.TopAnimeCharacterResponse
import com.halilozcan.animearch.core.domain.entity.SingleAnimeEntity
import com.halilozcan.animearch.core.domain.entity.TopAnimeEntity

const val TOP_ANIME_CHARACTERS_RESPONSE_FILE_NAME = "TopAnimeCharactersResponse.json"
const val SINGLE_ANIME_CHARACTER_RESPONSE_FILE_NAME = "SingleAnimeCharacterResponse.json"

@VisibleForTesting
val topAnime = Anime(
    about = "Age: 17 (first season), 18 (second season)\nDate of Birth:  December 5, 1999 a.t.b. (Sagittarius)\nBlood Type: A\nNationality: Britannian\nHeight: 178 cm (5'10\")\nWeight: 56 kg (123 lbs)\nOccupation: Student, Terrorist, Knightmare Pilot, Politician, Emperor, Prince\nAllegiance: Order of the Black Knights\nPosition: Leader of the Black Knights\nKnightmare: Sutherland, Burai, Gawain, Shinkirou\n\nLelouch vi Britannia (\u30eb\u30eb\u30fc\u30b7\u30e5\u30fb\u30f4\u30a3\u30fb\u30d6\u30ea\u30bf\u30cb\u30a2, Rur\u016bshu Vui Buritania) is the main protagonist of the anime manga series Code Geass. He is the Eleventh Prince of the Holy Britannian Empire and the son of the 98th Emperor of Britannia, Charles zi Britannia.\n\nLelouch is a very clever individual who is also calm, sophisticated, and arrogant due to his aristocratic upbringing. While at school, Lelouch conducts himself as a friendly, likable, and often an easygoing student. However, this is a mask to hide his true nature. While as Zero, his true nature is expressed. His charisma and beliefs in justice gain him the trust and respect of many soldiers and leaders.\n\nHe is known for having a very stoic personality. He never cared about schoolwork, seeing the entire thing as trivial, even though his high intelligence would make it easy for him. He enjoys seeking out challenges, often playing chess against the nobility. In general, Lelouch takes most day-to-day affairs with open disinterest, often not even noticing the affection of others, especially Shirley, his classmate. He has a strong dislike for nobles, viewing them as tepid and \"overprivileged parasites.\"\n\nMany characters have noted that Lelouch is entirely selfish, as his desire to remake the world into what he wants it to become from his desire to avenge his mother's apparent death and Nunnally's sake. However, in time, he realizes that this goal is not just for them but also the entire world.\n\nDespite his cold, calculating demeanor and ruthlessness in battle, he can be a rather compassionate person to his friends and loved ones. To Nunnally, he is a loving older brother, and to Suzaku, a loyal friend, although the two are enemies. Lelouch, at first glance, seems to have relatively little concern for the well-being of his subordinates, but in reality, he does care about them, seeing them as valuable allies.\n\n\nCharacter Background (as Lelouch):\n\nCharacter Background (as Zero):\n\nFirst Season:\n\nSecond Season:\n\n\nGeass:\nLelouch's Geass, bestowed upon him by C.C., gives him \"The Power of Absolute Obedience,\" allowing him to plant commands within a person's mind upon eye contact in a manner comparable to hypnosis. Activation of his Geass is visually represented by the manifestation of a Geass Sigil in his left eye. Commands dictated are written into the minds of the designated targets, the Sigil projecting him from his eye to theirs.\n\nOf all the Geass abilities in the series, Lelouch's has been explored the most and also seems to have the most restrictions, and side effects of any Geass introduced:(Source: Code Geass Wiki, Villains Wiki, Heroes Wiki, Anime and Manga Universe Wiki)",
    favorites = 159789,
    images = null,
    malId = 417,
    name = "Lelouch Lamperouge",
    nameKanji = "ルルーシュ・ランペルージ",
    nicknames = null,
    url = "https://myanimelist.net/character/45627/Levi"
)

@VisibleForTesting
val singleAnime = AnimeCharacter(
    about = "Age: 17 (first season), 18 (second season)\nDate of Birth:  December 5, 1999 a.t.b. (Sagittarius)\nBlood Type: A\nNationality: Britannian\nHeight: 178 cm (5'10\")\nWeight: 56 kg (123 lbs)\nOccupation: Student, Terrorist, Knightmare Pilot, Politician, Emperor, Prince\nAllegiance: Order of the Black Knights\nPosition: Leader of the Black Knights\nKnightmare: Sutherland, Burai, Gawain, Shinkirou\n\nLelouch vi Britannia (\u30eb\u30eb\u30fc\u30b7\u30e5\u30fb\u30f4\u30a3\u30fb\u30d6\u30ea\u30bf\u30cb\u30a2, Rur\u016bshu Vui Buritania) is the main protagonist of the anime manga series Code Geass. He is the Eleventh Prince of the Holy Britannian Empire and the son of the 98th Emperor of Britannia, Charles zi Britannia.\n\nLelouch is a very clever individual who is also calm, sophisticated, and arrogant due to his aristocratic upbringing. While at school, Lelouch conducts himself as a friendly, likable, and often an easygoing student. However, this is a mask to hide his true nature. While as Zero, his true nature is expressed. His charisma and beliefs in justice gain him the trust and respect of many soldiers and leaders.\n\nHe is known for having a very stoic personality. He never cared about schoolwork, seeing the entire thing as trivial, even though his high intelligence would make it easy for him. He enjoys seeking out challenges, often playing chess against the nobility. In general, Lelouch takes most day-to-day affairs with open disinterest, often not even noticing the affection of others, especially Shirley, his classmate. He has a strong dislike for nobles, viewing them as tepid and \"overprivileged parasites.\"\n\nMany characters have noted that Lelouch is entirely selfish, as his desire to remake the world into what he wants it to become from his desire to avenge his mother's apparent death and Nunnally's sake. However, in time, he realizes that this goal is not just for them but also the entire world.\n\nDespite his cold, calculating demeanor and ruthlessness in battle, he can be a rather compassionate person to his friends and loved ones. To Nunnally, he is a loving older brother, and to Suzaku, a loyal friend, although the two are enemies. Lelouch, at first glance, seems to have relatively little concern for the well-being of his subordinates, but in reality, he does care about them, seeing them as valuable allies.\n\n\nCharacter Background (as Lelouch):\n\nCharacter Background (as Zero):\n\nFirst Season:\n\nSecond Season:\n\n\nGeass:\nLelouch's Geass, bestowed upon him by C.C., gives him \"The Power of Absolute Obedience,\" allowing him to plant commands within a person's mind upon eye contact in a manner comparable to hypnosis. Activation of his Geass is visually represented by the manifestation of a Geass Sigil in his left eye. Commands dictated are written into the minds of the designated targets, the Sigil projecting him from his eye to theirs.\n\nOf all the Geass abilities in the series, Lelouch's has been explored the most and also seems to have the most restrictions, and side effects of any Geass introduced:(Source: Code Geass Wiki, Villains Wiki, Heroes Wiki, Anime and Manga Universe Wiki)",
    anime = null,
    favorites = 159789,
    images = ImagesX(
        jpg = null,
        WebpX(
            imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp",
            smallImageUrl = "https://cdn.myanimelist.net/images/characters/8/406163t.webp"
        )
    ),
    malId = 417,
    manga = null,
    name = "Lelouch Lamperouge",
    nameKanji = "ルルーシュ・ランペルージ",
    nicknames = null,
    url = "https://myanimelist.net/character/417/Lelouch_Lamperouge",
    voices = null,
)

@VisibleForTesting
val topAnimeCharacterResponse =
    TopAnimeCharacterResponse(
        data = listOf(topAnime),
        pagination = null
    )

@VisibleForTesting
val singleAnimeCharacterResponse =
    SingleCharacterResponse(data = singleAnime)


@VisibleForTesting
const val SERVER_PORT = 8000

@VisibleForTesting
val topAnimeList = listOf(topAnime)

@VisibleForTesting
const val singleAnimePathId = "417"

@VisibleForTesting
val singleAnimeEntity =
    SingleAnimeEntity(
        id = "417",
        name = "Levi",
        nameKanji = "ルルーシュ・ランペルージ",
        description = "",
        imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp",
        favorites = 159789
    )

@VisibleForTesting
val topAnimeEntity = TopAnimeEntity(
    id = "417",
    name = "Lelouch Lamperouge",
    description = "",
    imageUrl = "https://cdn.myanimelist.net/images/characters/8/406163.webp"
)

@VisibleForTesting
val topAnimeEntities = listOf(topAnimeEntity)

