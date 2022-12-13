package com.halilozcan.animearch.core.domain.mapper

interface AnimeBaseMapper<I, O> {
    fun map(input: I): O
}
