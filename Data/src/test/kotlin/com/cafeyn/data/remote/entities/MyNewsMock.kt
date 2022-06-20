package com.cafeyn.data.remote.entities


object EntityMock {
    private val myNewsResponse1 =
        MyNewsResponse(10, 1, "Title News 1", "https://www.google.fr", "https://www.google.fr")
    private val myNewsResponse2 =
        MyNewsResponse(20, 2, "Title News 2", "https://www.google.fr", "https://www.google.fr")

    val listMyNewsResponse = listOf(myNewsResponse1, myNewsResponse2)
}
