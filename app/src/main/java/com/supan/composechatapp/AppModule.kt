package com.supan.composechatapp

import android.app.Application
import com.supan.data.repository.AuthRepositoryImpl
import com.supan.data.repository.MessageRepositoryImpl
import com.supan.data.repository.UsersRepositoryImpl
import com.supan.data.utils.MyNotificationManager
import com.supan.domain.model.UsersModel
import com.supan.domain.repository.AuthRepository
import com.supan.domain.repository.MessageRepository
import com.supan.domain.repository.UsersRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()


    @Provides
    @Singleton
    fun provideStorageReference(): StorageReference = FirebaseStorage.getInstance().getReference("Files")

    @Provides
    @Singleton
    fun provideProfileBuilder(): UserProfileChangeRequest.Builder = UserProfileChangeRequest.Builder()

    @Provides
    @Singleton
    fun provideUser(): UsersModel = UsersModel(null, null, null, null, null, null)

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        fireStore: FirebaseFirestore,
        profileUpdates: UserProfileChangeRequest.Builder,
        userModel: UsersModel
    ): AuthRepository =
        AuthRepositoryImpl(firebaseAuth, fireStore,profileUpdates, userModel)

    @Provides
    @Singleton
    fun provideUsersRepository(fireStore: FirebaseFirestore): UsersRepository =
        UsersRepositoryImpl( fireStore)

    @Provides
    @Singleton
    fun provideMessageRepository(fireStore: FirebaseFirestore,mStorageRef: StorageReference,application: Application,myNotificationManager : MyNotificationManager): MessageRepository =
        MessageRepositoryImpl( fireStore , mStorageRef , application , myNotificationManager)

}