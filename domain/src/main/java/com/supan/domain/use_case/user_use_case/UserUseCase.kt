package com.supan.domain.use_case.user_use_case

import com.supan.domain.model.UsersModel
import com.supan.domain.repository.UsersRepository
import com.supan.domain.utils.Resource
import javax.inject.Inject

class UserUseCase @Inject constructor(private val usersRepository: UsersRepository) {


    operator fun invoke(userId: String, fireBaseResponse: (Resource<List<UsersModel>>) -> Unit) {


        usersRepository.getUser(userId) {
            fireBaseResponse(it)

        }


//    operator fun invoke(userId:String):Flow<Resource<List<UsersModel>>> = flow{
//
//        try {
//            emit(Resource.Loading<List<UsersModel>>())
//
//            usersRepository.getUser(userId).collect{
//                emit(Resource.Success<List<UsersModel>>(it))
//            }
//
//        }catch (e:Exception){
//            emit(Resource.Error<List<UsersModel>>(e.localizedMessage))
//        }
//
//    }

    }
}