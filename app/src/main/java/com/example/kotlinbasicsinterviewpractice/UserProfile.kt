package com.example.kotlinbasicsinterviewpractice

data class UserProfile(val profile: Profile?)

// extension functions action on User Profile object
fun UserProfile?.getUserAddress(): String {
    return this?.profile?.address?.street ?: "Unknown address"
}

fun UserProfile?.getUserAddressWithLet(): String? {
    return this.let { profile -> profile.let { address-> address.let { street -> street.getUserAddress() } } }?:"Unknown address"
}
