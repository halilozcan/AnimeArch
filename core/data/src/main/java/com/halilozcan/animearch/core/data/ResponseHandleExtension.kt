package com.halilozcan.animearch.core.data

import com.halilozcan.animearch.core.common.NetworkResponseState

fun <I:Any,O:Any> NetworkResponseState<I>.mapResponse(mapper:I.()->O): NetworkResponseState<O> {
    return when(this){
        is NetworkResponseState.Error -> NetworkResponseState.Error(this.exception)
        NetworkResponseState.Loading -> NetworkResponseState.Loading
        is NetworkResponseState.Success -> NetworkResponseState.Success(mapper.invoke(this.result))
    }
}