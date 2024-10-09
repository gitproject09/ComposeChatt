package com.supan.domain.repository

import com.supan.domain.model.UsersModel
import com.supan.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

     fun getUsers():Flow<MutableList<UsersModel>>

     fun getUser(userId:String,fireBaseResponse:(Resource<List<UsersModel>>)->Unit)

}